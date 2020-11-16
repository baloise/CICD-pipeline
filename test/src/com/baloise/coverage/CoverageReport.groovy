package com.baloise.coverage

import java.awt.Color

class CoverageReport {

	static void main(args) {
		println "reporting coverage"
		def parser = new XmlSlurper()
		parser.setFeature("http://apache.org/xml/features/disallow-doctype-decl", false)
		parser.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
		def report = parser.parse(new File("target/site/jacoco/jacoco.xml"))
		def LINE = report.counter.find { it.@type == "LINE" }
		float linesCovered = LINE.@covered.toString() as float
		float linesMissed = LINE.@missed.toString() as float
		float linePercentage = 100 * linesCovered /(linesCovered+ linesMissed)
		println "lines covered   " + linesCovered
		println "lines missed    " + linesMissed 
		println "line percentage " + linePercentage
		
		int maxC = 140
		int green = maxC* linePercentage / 100
		String color = "#"+Integer.toHexString(new Color(maxC-green, green, 0).RGB).substring(2)
		String label = "${linePercentage as int}%"
		File svg = new File("target/site/linecoverage.svg")
		svg.text = """<svg xmlns="http://www.w3.org/2000/svg"
	xmlns:xlink="http://www.w3.org/1999/xlink" width="96" height="20"
	role="img" aria-label="coverage: $label">
	<title>coverage: $label</title>
	<linearGradient id="s" x2="0" y2="100%">
		<stop offset="0" stop-color="#bbb" stop-opacity=".1" />
		<stop offset="1" stop-opacity=".1" />
	</linearGradient>
	<clipPath id="r">
		<rect width="96" height="20" rx="3" fill="#fff" />
	</clipPath>
	<g clip-path="url(#r)">
		<rect width="61" height="20" fill="#555" />
		<rect x="61" width="35" height="20" fill="$color" />
		<rect width="96" height="20" fill="url(#s)" />
	</g>
	<g fill="#fff" text-anchor="middle"
		font-family="Verdana,Geneva,DejaVu Sans,sans-serif"
		text-rendering="geometricPrecision" font-size="110">
		<text aria-hidden="true" x="315" y="150" fill="#010101"
			fill-opacity=".3" transform="scale(.1)" textLength="510">coverage</text>
		<text x="315" y="140" transform="scale(.1)" fill="#fff"
			textLength="510">coverage</text>
		<text aria-hidden="true" x="775" y="150" fill="#010101"
			fill-opacity=".3" transform="scale(.1)" textLength="250">$label</text>
		<text x="775" y="140" transform="scale(.1)" fill="#fff"
			textLength="250">$label</text>
	</g>
</svg>"""
		println "wrote "+svg
	}
}

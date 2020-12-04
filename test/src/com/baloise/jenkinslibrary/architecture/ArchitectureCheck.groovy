package com.baloise.jenkinslibrary.architecture

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses

import com.tngtech.archunit.core.importer.ImportOption
import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule

@AnalyzeClasses(
        packages = "com.baloise.sharedlib",
        importOptions =
                ImportOption.DoNotIncludeTests.class
)
class ArchitectureCheck {

    @ArchTest
    private static final ArchRule ALL_INTERNAL_CLASSES_SHOULD_BE_SERIALIZABLE = classes()
            .that()
            .resideInAPackage("..internal..")
            .should()
            .implement(Serializable.class)

    @ArchTest
    private static final ArchRule CLASSES_SHOULD_NOT_END_WITH_SERVICE = classes()
            .that()
            .areNotInterfaces()
            .should()
            .haveSimpleNameNotEndingWith("Service");

    @ArchTest
    private static final ArchRule NO_INTERFACES_IN_INTERNAL_PACKAGES = noClasses()
            .that()
            .resideInAPackage("..internal..")
            .should()
            .beInterfaces();

}

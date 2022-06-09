group = rootProject.property("group")!!
version = rootProject.property("version")!!

buildscript {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        maven {
            url = uri("https://jitpack.io")
        }
    }
    dependencies {
        classpath(libs.bundles.plugins)
    }
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
        maven {
            url = uri("https://jitpack.io")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
    for (childProject in childProjects.values) {
        delete(childProject.buildDir)
    }
}

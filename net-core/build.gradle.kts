import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jlleitschuh.gradle.ktlint")
    `maven-publish`
}
java.sourceCompatibility = JavaVersion.VERSION_11

val compileKotlin: KotlinCompile by tasks
val compileJava: JavaCompile by tasks
compileKotlin.destinationDirectory.set(compileJava.destinationDirectory.get())

java {
    modularity.inferModulePath.set(true)
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib"))
    implementation(project(":net-crypto"))
    api(project(":net-api"))
    implementation(libs.kotlinx.serialization.json)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.junit.platform.launcher)
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "11"
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}
publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = (parent ?: rootProject).group.toString()
            version = (parent ?: rootProject).version.toString()
            artifactId = project.name
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
    includeRepositories(project)
}

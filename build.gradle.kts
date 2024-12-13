plugins {
    kotlin("jvm") version "2.0.21"
    kotlin("plugin.allopen") version "2.0.21"

    id("io.quarkus") version "3.17.3"
    java
}

group = "org.acme"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation("io.quarkus:quarkus-config-yaml")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.0.21")

    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation ("io.quarkus:quarkus-rest")
    implementation ("io.quarkus:quarkus-rest-jackson")
    implementation ("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-hibernate-orm-panache")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    implementation("io.quarkus:quarkus-panache-mock")

    implementation ("com.google.code.gson:gson:2.8.9")

    testImplementation(kotlin("test"))
    testImplementation ("io.quarkus:quarkus-junit5")
    testImplementation ("io.rest-assured:rest-assured")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

allOpen {
    annotation("jakarta.persistence.Entity")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}
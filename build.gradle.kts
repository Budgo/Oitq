import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm") version "1.9.10"
    id("com.gradleup.shadow") version "8.3.0"
}

group = "me.aroze"
version = "1.0"

repositories {
    mavenCentral()
    maven {
        name = "papermc-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
    maven {
        name = "viaversion-repo"
        url = uri("https://repo.viaversion.com/")
    }
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.github.vaperion.blade:bukkit:3.0.8")
    implementation("com.viaversion:viaversion-api:4.7.0")
    implementation("net.luckperms:api:5.4")
    implementation("org.litote.kmongo:kmongo:4.9.0")
    implementation("com.github.uwuaroze:arozeutils:d8a4f1a809")
    implementation("fr.mrmickey:fastboard:2.1.3")
}

val targetJavaVersion = 17

java {
    val javaVersion = JavaVersion.toVersion(targetJavaVersion)
    if (JavaVersion.current() < javaVersion) {
        toolchain.languageVersion.set(JavaLanguageVersion.of(targetJavaVersion))
    }
}

tasks.withType<JavaCompile> {
    if (targetJavaVersion >= 10 || JavaVersion.current().isJava10Compatible()) {
        options.release.set(targetJavaVersion)
    }
}

tasks.named<ProcessResources>("processResources") {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}

tasks.shadowJar {
    relocate("fr.mrmicky.fastboard", "me.aroze.fastboard")
}

plugins {
    kotlin("jvm") version "1.3.61"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.uramnoil.apexlegendscutouttracker.MainKt"
    }
    from(configurations.compile.get().map { if (it.isDirectory) it else zipTree(it) })
}
group = "com.unrec"
version = "1.0-SNAPSHOT"
description = "java-demo"
java.sourceCompatibility = JavaVersion.VERSION_21

plugins {
    java
    id("com.autonomousapps.dependency-analysis") version "1.32.0"
}

tasks {
    test {
        useJUnitPlatform()
    }
}

dependencies {
    implementation("com.mysql:mysql-connector-j:9.0.0")

    implementation("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")


    implementation("org.apache.commons:commons-lang3:3.12.0")
    implementation("org.apache.commons:commons-compress:1.26.0")
    implementation("org.apache.commons:commons-configuration2:2.10.1")
    implementation("commons-io:commons-io:2.16.1")
    implementation("commons-codec:commons-codec:1.17.1")
    implementation("commons-fileupload:commons-fileupload:1.5")

    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.13.0")

    implementation("net.lingala.zip4j:zip4j:2.11.3")
    implementation("com.google.guava:guava:32.0.0-android")
    implementation("org.slf4j:slf4j-simple:2.0.0-alpha1")

    implementation("org.dom4j:dom4j:2.1.3")
    implementation("jaxen:jaxen:2.0.0")
    implementation("javax.xml.bind:jaxb-api:2.3.0")
    implementation("com.sun.xml.bind:jaxb-core:2.2.11")
    implementation("com.sun.activation:javax.activation:1.2.0")
    implementation("xerces:xercesImpl:2.12.2")

    implementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    implementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("org.assertj:assertj-core:3.16.1")
    implementation("org.hamcrest:hamcrest:3.0")

    compileOnly("javax.servlet:javax.servlet-api:4.0.1")
}

repositories {
    mavenCentral()
    mavenLocal()
}

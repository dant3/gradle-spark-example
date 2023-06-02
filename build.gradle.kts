plugins {
    id("java")
    scala
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val sparkVersion = "3.3.2"
val junit = "5.9.2"

dependencies {
    implementation("org.scala-lang:scala-library:2.12.17")
    implementation("org.apache.spark:spark-core_2.12:$sparkVersion")
    implementation("org.apache.spark:spark-sql_2.12:$sparkVersion")
    implementation("org.apache.spark:spark-mllib_2.12:$sparkVersion")
    implementation("org.apache.spark:spark-streaming_2.12:$sparkVersion")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junit")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
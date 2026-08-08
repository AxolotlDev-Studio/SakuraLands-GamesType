plugins {
  kotlin("jvm") version "2.3.21"
}

group = "com.sakuralands"
version = "1.0"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
  testImplementation("org.reflections:reflections:0.10.2")
  testImplementation(kotlin("reflect"))
}

kotlin {
  jvmToolchain(21)
}

tasks.test {
  useJUnitPlatform()
}
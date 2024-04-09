plugins {
  java
  id("org.springframework.boot") version "3.2.4"
  id("io.spring.dependency-management") version "1.1.4"
}

group = "io.github.ccscshq"
version = "0.1.0"

java {
  sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-security")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("io.projectreactor:reactor-test")
  testImplementation("org.springframework.security:spring-security-test")

  implementation ("net.logstash.logback:logstash-logback-encoder:7.2")
  runtimeOnly("io.opentelemetry.instrumentation:opentelemetry-logback-appender-1.0:1.28.0-alpha")
  implementation("io.opentelemetry:opentelemetry-api:1.28.0")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

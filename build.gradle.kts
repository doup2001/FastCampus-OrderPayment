plugins {
    java
    id("org.springframework.boot") version "3.4.2"
    id("io.spring.dependency-management") version "1.1.7"
    id("org.asciidoctor.jvm.convert") version "3.3.2"

    // RestDoc의 결과를 openAPI로 변환
    id("com.epages.restdocs-api-spec") version "0.17.1"
    // OpenAPI 3 spec을 기반으로 swaggerUI 생성
    id("org.hidetake.swagger.generator") version "2.18.2"
}

group = "lecture.fastcampus"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

extra["snippetsDir"] = file("build/generated-snippets")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // RestDoc
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("com.epages:restdocs-api-spec-mockmvc:0.17.1")

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

openapi3 { // 2.3
    this.setServer("http://localhost:8080")
    title = "FastCamp E-commerce"
    description = "주문 및 결제 파트."
    version = "1.0.0"
    format = "yaml"
}

tasks.withType<Test> {
    useJUnitPlatform()
}


tasks.register<Copy>("copyOasToSwagger") {
    delete("src/main/resources/static/swagger-ui/openapi3.yaml")
    from("$buildDir/api-spec/openapi3.yaml")
    into("src/main/resources/static/swagger-ui/.")
    dependsOn("openapi3")
}

tasks.test {
    outputs.dir(project.extra["snippetsDir"]!!)
}

tasks.asciidoctor {
    inputs.dir(project.extra["snippetsDir"]!!)
    dependsOn(tasks.test)
}

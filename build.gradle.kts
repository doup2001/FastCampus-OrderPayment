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

    // lombok
    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    // JPA 관련
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-j")
    runtimeOnly("com.h2database:h2")

    // 기타
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

    // 유효성 검사
    implementation("org.springframework.boot:spring-boot-starter-validation")

// Retrofit 의존성
    implementation("com.squareup.retrofit2:retrofit:2.10.0") // 버전은 필요에 따라 조정

// Jackson Converter 의존성
    implementation("com.squareup.retrofit2:converter-jackson:2.10.0") // Jackson converter
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0") // Jackson 데이터 바인딩
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.0") // Java 8 Date/Time 지원


    // Test관련
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-actuator")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // RestDoc
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("com.epages:restdocs-api-spec-mockmvc:0.17.1")

    // Mockito
    testImplementation("org.mockito:mockito-core:3.3.0")
    testImplementation("com.squareup.retrofit2:retrofit-mock:2.10.0")

}

openapi3 {
    this.setServer("https://localhost:8080") // list로 넣을 수 있어 각종 환경의 URL들을 넣을 수 있음!
    title = "FastEcommerce - Order/Payment"
    description = "Order/Payment API"
    version = "0.1.0"
    format = "yaml" // or json
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

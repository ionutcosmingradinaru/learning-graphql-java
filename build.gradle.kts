val flywayVersion = "11.13.0"
val jooqVersion = "3.19.26"
val postgresqlVersion = "42.7.8"
val mapstructVersion = "1.5.5.Final"

buildscript {
	repositories {
		mavenCentral()
	}
	dependencies {
		classpath("org.flywaydb:flyway-database-postgresql:11.13.0")
		classpath("org.postgresql:postgresql:42.7.8")
	}
}

plugins {
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
	id("org.flywaydb.flyway") version "11.13.0"
	id("org.jooq.jooq-codegen-gradle") version "3.19.26"
}

group = "com.ionutgradinaru.learning"
version = "0.0.1-SNAPSHOT"
description = "GraphQL project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-graphql")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework:spring-jdbc")
	implementation("org.springframework.boot:spring-boot-starter-jooq")

	implementation("org.postgresql:postgresql:${postgresqlVersion}")
	implementation("org.jooq:jooq:${jooqVersion}")
	implementation("org.jooq:jooq-codegen:${jooqVersion}")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	implementation("org.mapstruct:mapstruct:${mapstructVersion}")
	annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.graphql:spring-graphql-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

flyway {
	url = "jdbc:postgresql://localhost:5432/test_db"
	schemas = arrayOf("public")
	locations = arrayOf("filesystem:src/main/resources/db/migration")
	driver = "org.postgresql.Driver"
	user = "test_user"
	password = "test_password"
}

jooq {
	configuration {
		jdbc {
			driver = "org.postgresql.Driver"
			url = "jdbc:postgresql://localhost:5432/test_db"
			user = "test_user"
			password = "test_password"
		}

		generator {
			name = "org.jooq.codegen.DefaultGenerator"

			database {
				name = "org.jooq.meta.postgres.PostgresDatabase"
				inputSchema = "public"
			}

			generate {
				isDeprecated = false
				isRecords = true
				isImmutablePojos = true
			}

			target {
				packageName = "com.ionutgradinaru.learning.graphql.dao.generated"
				directory = "src/main/java"
			}
		}

	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

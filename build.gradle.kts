plugins {
    `java-library`
    `maven-publish`
}

group = "com.qa"
version = "0.1.0"

java {
    withSourcesJar()
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.11.0")
    implementation("io.github.bonigarcia:webdrivermanager:5.5.0")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifactId = "ta-automation"
        }
    }

    repositories {
        maven {
            url = uri("https://maven.pkg.github.com/YOUR_USERNAME/YOUR_REPO")
            credentials {
                username = project.findProperty("gpr.user") as String? ?: System.getenv("GITHUB_ACTOR")
                password = project.findProperty("gpr.key") as String? ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

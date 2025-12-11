plugins {
    `java-library`
    `maven-publish`
}

group = "com.qa"
version = "0.1.3"

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
            url = uri(project.property("githubRepoUrl") as String)
            credentials {
                username = project.property("githubUsername") as String
                password = project.property("githubPassword") as String
            }
        }
    }
}

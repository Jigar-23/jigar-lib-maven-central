plugins {
    id("java")
    `maven-publish`
    signing
}

group = "com.github.Jigar-23"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "com.github.jigar23" // Your Group ID
            artifactId = "jigar-lib-maven-central" // Your artifact ID
            version = "1.0.0" // Your version
            pom {
                name.set("jigar-lib-maven-central")
                description.set("This is a library of mine")
                url.set("https://github.com/Jigar-23/jigar-lib-maven-central")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("Jigar-23")
                        name.set("Jigar")
                        email.set("Pulkit10112@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/Jigar-23/jigar-lib-maven-central.git")
                    developerConnection.set("scm:git:ssh://github.com/Jigar-23/jigar-lib-maven-central.git")
                    url.set("https://github.com/Jigar-23/jigar-lib-maven-central/")
                }
            }
        }
    }
    repositories {
        maven {
            name = "OSSRH"
            url = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
        }
    }
}

signing {
    useGpgCmd()
    sign(publishing.publications["mavenJava"])
}




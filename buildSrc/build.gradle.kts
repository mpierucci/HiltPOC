plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {

    plugins {
        val masterPlugin = "module-plugin"

        register(masterPlugin) {
            id = masterPlugin
            implementationClass = "plugins.ModulePlugin"
        }
    }
}

repositories {
    google()
    jcenter()
}

dependencies {

    implementation("com.android.tools.build:gradle:4.1.1")
    implementation(kotlin("gradle-plugin", "1.4.21"))

    implementation("org.jacoco:org.jacoco.core:0.8.5")

    testImplementation(gradleTestKit())
    testImplementation("junit:junit:4.13")
    testImplementation("com.google.truth:truth:1.0.1")
}


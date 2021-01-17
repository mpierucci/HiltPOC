buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        google()
        jcenter()

    }
    dependencies {
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

import dependencies.Libs
import dependencies.Test

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    `module-plugin`
}

android {
    defaultConfig.applicationId = "com.mpierucci.android.hiltpoc"
}

dependencies {

    implementation(project(":btc:domain"))
    implementation(project(":btc:data"))
    implementation(project(":network"))
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(Libs.stdlibJdk8)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.Ktx.core)
    implementation(Libs.AndroidX.LifeCycle.runtime)
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation(Libs.Dagger.Hilt.android)
    kapt(Libs.Dagger.Hilt.androidCompiler)

    testImplementation(Test.jUnit)
    androidTestImplementation(Test.Esspresso.jUnit)
    androidTestImplementation(Test.Esspresso.core)
}

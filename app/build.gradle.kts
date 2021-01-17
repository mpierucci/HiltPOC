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
    implementation(project(":btc:presentation"))
    implementation(project(":network"))
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(Libs.stdlibJdk8)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.Ktx.core)
    implementation(Libs.AndroidX.LifeCycle.runtime)
    implementation(Libs.Dagger.Hilt.android)
    implementation(Libs.Dagger.Hilt.jetPack)

    kapt(Libs.Dagger.Hilt.androidCompiler)
    kapt(Libs.Dagger.Hilt.jetPackCompiler)

    testImplementation(Test.jUnit)
    androidTestImplementation(Test.Esspresso.jUnit)
    androidTestImplementation(Test.Esspresso.core)
}

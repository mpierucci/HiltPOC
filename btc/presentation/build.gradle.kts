import dependencies.Libs
import dependencies.Test
import plugins.`module-plugin`

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    `module-plugin`
}

dependencies {

    implementation(project(":btc:domain"))
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(Libs.stdlibJdk8)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.Ktx.fragment)
    implementation("androidx.fragment:fragment-ktx:1.2.5")
    implementation(Libs.AndroidX.Ktx.core)
    implementation(Libs.AndroidX.LifeCycle.viewModel)
    implementation(Libs.AndroidX.LifeCycle.runtime)
    implementation(Libs.Dagger.Hilt.jetPack)
    implementation(Libs.Dagger.Hilt.android)
    kapt(Libs.Dagger.Hilt.jetPackCompiler)
    kapt(Libs.Dagger.Hilt.androidCompiler)
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.Esspresso.jUnit)
    androidTestImplementation(Test.Esspresso.core)
}



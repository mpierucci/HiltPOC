import dependencies.Libs
import dependencies.Test
import plugins.`module-plugin`

plugins {
    id("com.android.library")
    id("dagger.hilt.android.plugin")
    `module-plugin`
}

dependencies {

    implementation(project(":network"))
    implementation(project(":btc:domain"))

    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(Libs.stdlibJdk8)
    implementation(Libs.Coroutines.core)
    implementation(Libs.Dagger.Hilt.android)
    kapt(Libs.Dagger.Hilt.androidCompiler)


    testImplementation(Test.jUnit)
    testImplementation(Test.truth)
    testImplementation(Test.mockitoKotlin)
    testImplementation(Test.coroutne)
    androidTestImplementation(Test.Esspresso.jUnit)
    androidTestImplementation(Test.Esspresso.core)
}



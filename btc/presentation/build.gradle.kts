import dependencies.Libs
import dependencies.Test
import plugins.`module-plugin`

plugins {
    id("com.android.library")
    `module-plugin`
}

dependencies {

    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation(Libs.stdlibJdk8)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.Ktx.core)
    testImplementation(Test.jUnit)
    androidTestImplementation(Test.Esspresso.jUnit)
    androidTestImplementation(Test.Esspresso.core)
}



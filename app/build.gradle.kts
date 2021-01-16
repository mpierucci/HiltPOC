import dependencies.Libs
import dependencies.Test

plugins {
    id("com.android.application")
    `module-plugin`
}

android {
    defaultConfig.applicationId = "com.mpierucci.android.template"
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

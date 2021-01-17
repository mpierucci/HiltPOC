import dependencies.Libs
import plugins.`module-plugin`

plugins {
    `module-plugin`
}

dependencies {
    implementation(Libs.okHttp)
    implementation(Libs.Retrofit.moshiConverter)
    implementation(Libs.Dagger.Hilt.core)

    api(Libs.Retrofit.retrofit)

    kapt(Libs.Dagger.Hilt.compiler)
}
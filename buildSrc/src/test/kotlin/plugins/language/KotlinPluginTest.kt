package plugins.language

import com.google.common.truth.Truth
import org.gradle.api.JavaVersion
import org.gradle.testfixtures.ProjectBuilder
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.junit.Test

class KotlinPluginTest {

    @Test
    fun `applies sets kotlin compatibility`() {
        val project = ProjectBuilder.builder().build()
        project.plugins.apply(KotlinPlugin::class.java)

        project.extensions.findByType(KotlinJvmOptions::class.java)?.let {
            Truth.assertThat(it.jvmTarget).isEqualTo(JavaVersion.VERSION_1_8.toString())
        }
    }

    @Test
    fun `applies kotlin jvm plugin`() {
        val project = ProjectBuilder.builder().build()

        project.plugins.apply(KotlinPlugin::class.java)

        val kotlinPlugin = project.plugins.findPlugin("org.jetbrains.kotlin.jvm")

        Truth.assertThat(kotlinPlugin).isNotNull()
    }

    @Test
    fun `applies kotlin kapt plugin`() {
        val project = ProjectBuilder.builder().build()

        project.plugins.apply(KotlinPlugin::class.java)

        val kotlinPlugin = project.plugins.findPlugin("kotlin-kapt")

        Truth.assertThat(kotlinPlugin).isNotNull()
    }

    @Test
    fun `applies kotlin source sets`() {
        val project = ProjectBuilder.builder().build()

        project.plugins.apply(KotlinPlugin::class.java)

        val kotlinExtension = project.extensions.findByType(KotlinJvmProjectExtension::class.java)

        //java and kotlin sourcets
        Truth.assertThat(kotlinExtension?.sourceSets?.getByName("main")?.kotlin?.srcDirs).hasSize(2)
        Truth.assertThat(kotlinExtension?.sourceSets?.getByName("test")?.kotlin?.srcDirs).hasSize(2)
    }
}
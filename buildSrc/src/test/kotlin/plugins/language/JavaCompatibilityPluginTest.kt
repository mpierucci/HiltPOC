package plugins.language


import com.android.build.gradle.BaseExtension
import com.google.common.truth.Truth.assertThat
import org.gradle.api.JavaVersion
import org.gradle.api.plugins.JavaPlugin
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Ignore
import org.junit.Test

class JavaCompatibilityPluginTest {


    @Test
    fun `applies java compatibility to kotlin module`() {
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("kotlin")
        project.plugins.apply(JavaCompatibilityPlugin::class.java)

        project.extensions.findByType(JavaPluginExtension::class.java)?.let {
            assertThat(it.sourceCompatibility).isEqualTo(JavaVersion.VERSION_1_8)
            assertThat(it.targetCompatibility).isEqualTo(JavaVersion.VERSION_1_8)
        }
    }

    @Test
    fun `applies java compatibility to java module`() {
        val project = ProjectBuilder.builder().build()
        project.plugins.apply(JavaPlugin::class.java)
        project.plugins.apply(JavaCompatibilityPlugin::class.java)

        project.extensions.findByType(JavaPluginExtension::class.java)?.let {
            assertThat(it.sourceCompatibility).isEqualTo(JavaVersion.VERSION_1_8)
            assertThat(it.targetCompatibility).isEqualTo(JavaVersion.VERSION_1_8)
        }
    }


    @Test
    @Ignore("something is worng when applying android plugin")
    fun `applies java compatibility to android module`() {
        val project = ProjectBuilder.builder().build()
        project.plugins.apply("com.android.library")
        project.plugins.apply(JavaCompatibilityPlugin::class.java)

        project.extensions.findByType(BaseExtension::class.java)?.let {
            assertThat(it.compileOptions.sourceCompatibility).isEqualTo(JavaVersion.VERSION_1_8)
            assertThat(it.compileOptions.targetCompatibility).isEqualTo(JavaVersion.VERSION_1_8)
        }
    }


}
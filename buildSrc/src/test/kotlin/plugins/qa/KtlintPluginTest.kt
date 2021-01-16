package plugins.qa

import com.google.common.truth.Truth
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test
import plugins.language.KotlinPlugin

class KtlintPluginTest {

    @Test
    fun `register ktlint tasks`() {
        val project = ProjectBuilder.builder().build()
        project.plugins.apply(KotlinPlugin::class.java)
        project.plugins.apply(KtlintPlugin::class.java)

        val ktlintTask = project.tasks.findByName("ktlint")
        val ktlintFormatTask = project.tasks.findByName("ktlintFormat")

        Truth.assertThat(ktlintTask).isNotNull()
        Truth.assertThat(ktlintFormatTask).isNotNull()
    }
}
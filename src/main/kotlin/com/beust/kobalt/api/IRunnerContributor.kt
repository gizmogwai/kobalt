package com.beust.kobalt.api

import com.beust.kobalt.TaskResult
import com.beust.kobalt.maven.dependency.IClasspathDependency

/**
 * Plugins that can run a project (task "run" or "test") should implement this interface.
 */
interface IRunnerContributor : IContributor {
    companion object {
        /**
         * The recommended default affinity if your plug-in can run this project. Use a higher
         * number if you expect to compete against other runners and you'd like to win over them.
         */
        const val DEFAULT_POSITIVE_AFFINITY = 100
    }

    /**
     * @return an integer indicating your affinity for running the current project. The runner with
     * the highest affinity is selected to run it.
     */
    fun runAffinity(project: Project, context: KobaltContext) : Int

    /**
     * Run the project.
     */
    fun run(project: Project, context: KobaltContext, classpath: List<IClasspathDependency>) : TaskResult
}



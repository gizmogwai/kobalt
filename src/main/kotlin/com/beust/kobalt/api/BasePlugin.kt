package com.beust.kobalt.api

import com.beust.kobalt.Plugins
import com.beust.kobalt.internal.TaskManager
import kotlin.properties.Delegates

abstract public class BasePlugin : IPlugin {
    override var taskManager: TaskManager by Delegates.notNull()
    override fun accept(project: Project) = true
    var plugins: Plugins by Delegates.notNull()

    var context: KobaltContext by Delegates.notNull()

    override fun apply(project: Project, context: KobaltContext) {
        this.context = context
    }

    protected val projects = arrayListOf<ProjectDescription>()

    fun addProject(project: Project, dependsOn: Array<out Project>) {
        projects.add(ProjectDescription(project, dependsOn.toList()))
    }
}

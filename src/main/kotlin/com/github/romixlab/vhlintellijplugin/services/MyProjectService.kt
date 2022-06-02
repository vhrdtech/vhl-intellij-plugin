package com.github.romixlab.vhlintellijplugin.services

import com.intellij.openapi.project.Project
import com.github.romixlab.vhlintellijplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}

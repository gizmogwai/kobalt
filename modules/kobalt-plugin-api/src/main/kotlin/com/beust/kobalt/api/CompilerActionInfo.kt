package com.beust.kobalt.api

import java.io.File

/**
 * Describe the information necessary to run a compiler.
 */
data class CompilerActionInfo(val directory: String?,
        val dependencies: List<IClasspathDependency>,
        val sourceFiles: List<String>,
        val suffixesBeingCompiled: List<String>,
        val outputDir: File,
        val compilerArgs: List<String>,
        val friendPaths: List<String>,
        val forceRecompile: Boolean,
        val compilerSeparateProcess: Boolean = false)

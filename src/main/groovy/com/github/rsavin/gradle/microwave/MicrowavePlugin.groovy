package com.github.rsavin.gradle.microwave

import org.gradle.api.Plugin
import org.gradle.api.Project


class MicrowavePlugin implements Plugin<Project> {

    void beep() {
        println 'Beep!'
    }

    void apply(final Project project) {
        project.gradle.buildFinished {
            beep()
        }
    }
}
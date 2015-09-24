package com.github.rsavin.gradle.microwave

import org.gradle.api.Plugin
import org.gradle.api.Project

import javax.sound.sampled.AudioSystem
import javax.sound.sampled.LineEvent

class MicrowavePlugin implements Plugin<Project> {

    def playingDone = false

    void beep() {
        try {
            def clip = AudioSystem.getClip()
            def audioStream = AudioSystem.getAudioInputStream(
                    new BufferedInputStream(getClass().getResourceAsStream('/sounds/microwave-bell.wav'))
            )

            clip.addLineListener({ event ->
                def eventType = event.getType()
                if (eventType == LineEvent.Type.STOP || eventType == LineEvent.Type.CLOSE) {
                    playingDone = true
                }
            })

            clip.open(audioStream)
            try {
                clip.start()
                while (!playingDone) {
                    sleep(1000)
                }
                audioStream.close()
            } finally {
                clip.close()
            }
        } catch (Exception e) {
            System.err.println(e.getMessage())
        }
    }

    void apply(final Project project) {
        project.gradle.buildFinished {
            beep()
        }
    }
}
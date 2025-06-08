package com.smartdev.incorpfounds.game.actors

import com.smartdev.incorpfounds.game.actors.button.AButton
import com.smartdev.incorpfounds.game.actors.progress.AProgressTest
import com.smartdev.incorpfounds.game.utils.actor.disable
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedGroup
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedScreen

class ATestWithProgress(
    override val screen: AdvancedScreen,
): AdvancedGroup() {

    private val btn      = AButton(screen, AButton.Type.Test_Progress)
    private val progress = AProgressTest(screen)

    var blockClick = {}

    override fun addActorsOnGroup() {
        addAndFillActor(btn)
        addActor(progress)
        progress.setBounds(42f, 60f, 964f, 12f)
        progress.disable()

        btn.setOnClickListener { blockClick() }
    }

    fun setProgress(progress: Float) {
        this.progress.progressPercentFlow.value = progress
    }

}

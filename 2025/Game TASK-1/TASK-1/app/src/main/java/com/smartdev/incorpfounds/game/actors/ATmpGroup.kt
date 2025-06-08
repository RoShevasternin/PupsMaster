package com.smartdev.incorpfounds.game.actors

import com.smartdev.incorpfounds.game.utils.advanced.AdvancedGroup
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedScreen

class ATmpGroup(
    override val screen: AdvancedScreen,
): AdvancedGroup() {

    override fun getPrefHeight(): Float {
        return height
    }

    override fun addActorsOnGroup() {}

}

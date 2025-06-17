package com.fond.buduchego.game.actors

import com.fond.buduchego.game.utils.advanced.AdvancedGroup
import com.fond.buduchego.game.utils.advanced.AdvancedScreen

class ATmpGroup(
    override val screen: AdvancedScreen,
): AdvancedGroup() {

    override fun getPrefHeight(): Float {
        return height
    }

    override fun addActorsOnGroup() {}

}

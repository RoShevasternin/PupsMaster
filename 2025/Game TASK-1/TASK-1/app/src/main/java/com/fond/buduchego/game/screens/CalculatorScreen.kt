package com.fond.buduchego.game.screens

import com.fond.buduchego.game.actors.main.AMainCalculator
import com.fond.buduchego.game.utils.advanced.AdvancedMainScreen
import com.fond.buduchego.game.utils.advanced.AdvancedStage
import com.fond.buduchego.game.utils.gdxGame
import com.fond.buduchego.game.utils.region

class CalculatorScreen: AdvancedMainScreen() {

    override val aMain = AMainCalculator(this)

    override fun show() {
        setBackBackground(gdxGame.assetsLoader.BACKGROUND.region)
        super.show()
    }

    override fun AdvancedStage.addActorsOnStageUI() {
        addMain()
    }

    override fun hideScreen(block: Runnable) {
        aMain.animHideMain { block.run() }
    }

    // Actors UI------------------------------------------------------------------------

    override fun AdvancedStage.addMain() {
        addAndFillActor(aMain)
    }

}

package com.fond.buduchego.game.screens.savings

import com.fond.buduchego.game.actors.main.savings.AMainSavings
import com.fond.buduchego.game.utils.advanced.AdvancedMainScreen
import com.fond.buduchego.game.utils.advanced.AdvancedStage
import com.fond.buduchego.game.utils.gdxGame
import com.fond.buduchego.game.utils.region

class SavingsScreen: AdvancedMainScreen() {

    override val aMain = AMainSavings(this)

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

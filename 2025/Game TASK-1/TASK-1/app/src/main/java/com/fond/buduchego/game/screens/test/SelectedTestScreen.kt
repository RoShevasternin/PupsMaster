package com.fond.buduchego.game.screens.test

import com.fond.buduchego.game.actors.main.test.AMainSelectedTest
import com.fond.buduchego.game.utils.advanced.AdvancedMainScreen
import com.fond.buduchego.game.utils.advanced.AdvancedStage
import com.fond.buduchego.game.utils.gdxGame
import com.fond.buduchego.game.utils.region

class SelectedTestScreen: AdvancedMainScreen() {

    companion object {
        var WIN_COUNT = 0
    }

    override val aMain = AMainSelectedTest(this)

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

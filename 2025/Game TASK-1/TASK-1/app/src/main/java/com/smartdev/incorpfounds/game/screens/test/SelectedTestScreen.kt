package com.smartdev.incorpfounds.game.screens.test

import com.smartdev.incorpfounds.game.actors.main.test.AMainSelectedTest
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedMainScreen
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedStage
import com.smartdev.incorpfounds.game.utils.gdxGame
import com.smartdev.incorpfounds.game.utils.region

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

package com.smartdev.incorpfounds.game.screens.savings

import com.smartdev.incorpfounds.game.actors.main.savings.AMainSavingsEdit
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedMainScreen
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedStage
import com.smartdev.incorpfounds.game.utils.gdxGame
import com.smartdev.incorpfounds.game.utils.region

class SavingsEditScreen: AdvancedMainScreen() {

    override val aMain = AMainSavingsEdit(this)

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

package com.smartdev.incorpfounds.game.screens

import com.smartdev.incorpfounds.game.actors.main.AMainGlossary
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedMainScreen
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedStage
import com.smartdev.incorpfounds.game.utils.gdxGame
import com.smartdev.incorpfounds.game.utils.region

class GlossaryScreen: AdvancedMainScreen() {

    override val aMain = AMainGlossary(this)

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

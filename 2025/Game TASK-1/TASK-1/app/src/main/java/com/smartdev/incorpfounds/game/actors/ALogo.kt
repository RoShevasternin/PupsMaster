package com.smartdev.incorpfounds.game.actors

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.scenes.scene2d.ui.Image
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.utils.Align
import com.smartdev.incorpfounds.game.utils.GameColor
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedGroup
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedScreen
import com.smartdev.incorpfounds.game.utils.font.FontParameter
import com.smartdev.incorpfounds.game.utils.gdxGame

class ALogo(
    override val screen: AdvancedScreen,
): AdvancedGroup() {

    private val parameter = FontParameter()
        .setCharacters("SmartFunds")
        .setSize(77)

    private val font = screen.fontGenerator_Bold.generateFont(parameter)
    private val ls   = LabelStyle(font, Color.WHITE)

    private val imgLogo = Image(gdxGame.assetsLoader.wallet)
    private val lblLogo = Label("SmartFunds", ls)

    override fun addActorsOnGroup() {
        addActors(imgLogo, lblLogo)
        imgLogo.setBounds(172f, 84f, 105f, 115f)
        lblLogo.setBounds(0f, 1f, 451f, 59f)
        lblLogo.setAlignment(Align.center)
    }

}

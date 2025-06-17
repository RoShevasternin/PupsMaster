package com.fond.buduchego.game.actors

import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle
import com.badlogic.gdx.utils.Align
import com.fond.buduchego.game.dataStore.DataSaving
import com.fond.buduchego.game.utils.DepositCalculation
import com.fond.buduchego.game.utils.advanced.AdvancedGroup
import com.fond.buduchego.game.utils.advanced.AdvancedScreen
import com.fond.buduchego.game.utils.calculateDeposit
import com.fond.buduchego.game.utils.calculateDepositCompound
import com.fond.buduchego.game.utils.toSeparate
import kotlin.math.roundToInt

class AResultCalculatorGroup(
    override val screen: AdvancedScreen,
    isSimple: Boolean,
    val dataSaving: DataSaving,
    ls60: LabelStyle,
    ls54: LabelStyle
): AdvancedGroup() {

    private val depositCalculation: DepositCalculation = if (isSimple) calculateDeposit(dataSaving) else calculateDepositCompound(dataSaving)

    private val listFieldName = listOf(
        "Первоначальный взнос",
        "Общая сумма депозитов",
        "Полученные процентные",
        "Срок полномочий",
        "Эффективная процентная ставка",
    )
    private val listCalculationValue = listOf<String>(
        "${depositCalculation.initialDeposit.toSeparate()}$",
        "${depositCalculation.totalDeposits.toSeparate()}$",
        "${String.format("%.2f", depositCalculation.effectiveInterestRate).take(5)}%",
        "${depositCalculation.interestEarned.roundToInt().toSeparate()}$",
        "${depositCalculation.term} месяц",
    )


    private val listField = List(5) { Label(listFieldName[it], ls54) }
    private val listValue = List(5) { Label(listCalculationValue[it], ls60) }

    override fun addActorsOnGroup() {
        addFields()
        addValues()
    }

    private fun addFields() {
        var ny = 527f
        listField.forEachIndexed { index, label ->
            addActor(label)
            label.setBounds(0f, ny, 315f, 65f)
            ny -= 58 + 65
        }
    }

    private fun addValues() {
        var ny = 529f
        listValue.forEachIndexed { index, label ->
            addActor(label)
            label.setBounds(819f, ny, 228f, 72f)
            ny -= 60 + 72

            label.setAlignment(Align.right)
        }
    }

}

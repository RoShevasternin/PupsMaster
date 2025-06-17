package com.fond.buduchego.game.utils

import com.fond.buduchego.game.dataStore.DataSaving
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow
import kotlin.math.roundToInt

data class DepositCalculation(
    val initialDeposit: Int,
    val totalDeposits: Int,
    val effectiveInterestRate: Double,
    val interestEarned: Double,
    val term: Int
)

data class DataCalculatorResult(
    var depositAmount      : Int,
    var interestRate       : Int,
    var depositTerm        : Int,
    var monthlyContribution: Int,
)

fun calculateDeposit(depositInfo: DataSaving): DepositCalculation {
    val initialDeposit = depositInfo.amount
    val term = depositInfo.term
    val monthlyContribution = depositInfo.contr
    val annualInterestRate = depositInfo.rate / 100.0
    val monthlyInterestRate = annualInterestRate / 12.0

    // Загальна сума депозиту без відсотків
    val totalDeposits = initialDeposit + (monthlyContribution * term)

    // Розрахунок складних відсотків (щомісячна капіталізація)
    var futureValue = initialDeposit.toDouble()
    for (i in 1..term) {
        futureValue += monthlyContribution
        futureValue *= (1 + monthlyInterestRate)
    }

    // Нараховані відсотки
    val interestEarned = futureValue - totalDeposits

    // Ефективна процентна ставка (APY)
    val effectiveInterestRate = (interestEarned / totalDeposits) * 100

    return DepositCalculation(
        initialDeposit = initialDeposit,
        totalDeposits = totalDeposits,
        effectiveInterestRate = effectiveInterestRate,
        interestEarned = interestEarned,
        term = term
    )
}

fun calculateDepositCompound(depositInfo: DataSaving): DepositCalculation {
    val initialDeposit = depositInfo.amount.toDouble()
    val term = depositInfo.term
    val monthlyContribution = depositInfo.contr.toDouble()
    val annualInterestRate = depositInfo.rate / 100.0
    val monthlyInterestRate = annualInterestRate / 12.0
    val termYears = term / 12.0

    // 📌 Загальна сума внесків без урахування відсотків
    val totalDeposits = initialDeposit + (monthlyContribution * term)

    // 📌 Розрахунок майбутньої вартості вкладень (Compound Interest Formula)
    val futureValueInitial = initialDeposit * (1 + monthlyInterestRate).pow(term)
    val futureValueContributions = if (monthlyInterestRate > 0) {
        monthlyContribution * ((1 + monthlyInterestRate).pow(term) - 1) / monthlyInterestRate
    } else {
        monthlyContribution * term // Якщо ставка 0, то просто внески без відсотків
    }

    val futureValue = futureValueInitial + futureValueContributions

    // 📌 Нараховані відсотки
    val interestEarned = futureValue - totalDeposits

    // 📌 Ефективна процентна ставка (APY)
    val effectiveInterestRate = if (totalDeposits > 0) (interestEarned / totalDeposits) * 100 else 0.0

    return DepositCalculation(
        initialDeposit = initialDeposit.toInt(),
        totalDeposits = totalDeposits.toInt(),
        effectiveInterestRate = BigDecimal(effectiveInterestRate).setScale(2, RoundingMode.HALF_UP).toDouble(),
        interestEarned = BigDecimal(interestEarned).setScale(2, RoundingMode.HALF_UP).toDouble(),
        term = term
    )
}

fun calculateSummary(listDataSaving: List<DataSaving>): Map<String, Int> {
    val deposits = mutableListOf<DepositCalculation>()

    listDataSaving.forEach {
        deposits.add(calculateDeposit(it))
    }

    val totalInvested = deposits.sumOf { it.totalDeposits }
    val totalInterestEarned = deposits.sumOf { it.interestEarned }
    val totalTerm = deposits.sumOf { it.term }

    val monthlyProfit = if (totalTerm > 0) totalInterestEarned / totalTerm else 0.0
    val expectedAmountAtClosure = totalInvested + totalInterestEarned

    return mapOf(
        "Total Invested" to totalInvested,
        "Monthly Profit" to monthlyProfit.roundToInt(),
        "Expected Amount at Closure" to expectedAmountAtClosure.roundToInt()
    )
}

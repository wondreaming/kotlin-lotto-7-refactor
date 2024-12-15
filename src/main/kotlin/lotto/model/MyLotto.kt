package lotto.model

import lotto.constant.WinnerType
import lotto.util.RandomNumbers

data class MyLotto(
    private val purchaseCost: Int,
    private val _lottos: MutableList<Lotto> = mutableListOf(),
    private val _winners: MutableList<WinnerType> = mutableListOf(),
) {
    val lottoCount: Int
        get() = purchaseCost / 1000

    val lottos: List<Lotto>
        get() = _lottos

    val winners: List<WinnerType>
        get() = _winners

    val rateOfReturn: String
        get() {
            val totalPrizeAmount = _winners.sumOf { it.prizeAmount }
            val rate = totalPrizeAmount / purchaseCost.toDouble() * 100
            return String.format("%.1f", rate)
        }

    init {
        generateLottos()
    }

    private fun generateLottos() {
        val randomNumbers = RandomNumbers()
        for (count in 1..lottoCount) {
            val nums = randomNumbers()
            _lottos.add(Lotto(nums))
        }
    }

    fun getWinner(winningNumber: Lotto, bonusNumber: Int) {
        _lottos.forEach { lotto ->
            val matchCount = lotto.winningNumbers.intersect(winningNumber.winningNumbers).size
            val hasBonus = bonusNumber in lotto.winningNumbers
            val winner = when {
                matchCount == 6 -> WinnerType.FIRST
                matchCount == 5 && hasBonus -> WinnerType.SECOND
                matchCount == 5 -> WinnerType.THIRD
                matchCount == 4 -> WinnerType.FOURTH
                matchCount == 3 -> WinnerType.FIFTH
                else -> WinnerType.NONE
            }
            _winners.add(winner)
        }
    }
}
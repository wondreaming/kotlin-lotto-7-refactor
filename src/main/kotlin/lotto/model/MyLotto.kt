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

    init {
        getLotto()
    }

    private fun getLotto() {
        val randomNumbers = RandomNumbers()
        for (count in 1..lottoCount) {
            val nums = randomNumbers()
            _lottos.add(Lotto(nums))
        }
    }

    fun getWinner(winningNumber: Lotto, bonusNumber: Int) {
        for (lotto in _lottos) {
            val difference = _lottos.minus(winningNumber)
            val duplicationCount = _lottos.size - difference.size
            val matchingBonusNumber = bonusNumber in lotto.winningNumbers
            val winner = when (duplicationCount) {
                6 -> WinnerType.FIRST
                5 -> if (matchingBonusNumber) WinnerType.SECOND else WinnerType.THIRD
                4 -> WinnerType.FOURTH
                3 -> WinnerType.FIFTH
                else -> WinnerType.NONE
            }
            _winners.add(winner)
        }
    }
}
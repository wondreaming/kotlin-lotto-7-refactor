package lotto.model

import lotto.util.RandomNumbers

data class MyLotto(
    private val purchaseCost: Int,
    private val _lottos: MutableList<Lotto> = mutableListOf(),
) {
    val lottoCount: Int
        get() = purchaseCost / 1000

    val lottos: List<Lotto>
        get() = _lottos

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
}
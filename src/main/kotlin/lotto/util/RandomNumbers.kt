package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class RandomNumbers {
    operator fun invoke(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(START_NUMBER, LAST_NUMBER, LOTTE_NUMBER_COUNT).sorted()
    }

    companion object {
        private const val START_NUMBER = 1
        private const val LAST_NUMBER = 45
        private const val LOTTE_NUMBER_COUNT = 6
    }
}
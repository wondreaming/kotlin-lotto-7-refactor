package lotto.util

import camp.nextstep.edu.missionutils.Randoms

class RandomNumbers {
    operator fun invoke(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
    }
}
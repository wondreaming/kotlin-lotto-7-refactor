package lotto.view

import lotto.constant.WinnerType
import lotto.model.MyLotto

class OutputView {
    fun showStartMessage() {
        println("구입금액을 입력해 주세요.")
    }

    fun showPurchaseLotto(myLotto: MyLotto) {
        println()
        println("${myLotto.lottoCount}개를 구매했습니다.")
        myLotto.lottos.forEach { println(it.toString()) }
    }

    fun showLottoNumbers() {
        println()
        println("당첨 번호를 입력해 주세요.")
    }

    fun showBonusNumber() {
        println()
        println("보너스 번호를 입력해 주세요.")
    }

    fun showPrize(myLotto: MyLotto) {
        println()
        println("당첨 통계")
        println("---")

        val fifthCount = myLotto.winners.count { it == WinnerType.FIFTH }
        val fourthCount = myLotto.winners.count { it == WinnerType.FOURTH }
        val thirdCount = myLotto.winners.count { it == WinnerType.THIRD }
        val secondCount = myLotto.winners.count { it == WinnerType.SECOND }
        val firstCount = myLotto.winners.count { it == WinnerType.FIRST }

        println("${WinnerType.FIFTH} - ${fifthCount}개")
        println("${WinnerType.FOURTH} - ${fourthCount}개")
        println("${WinnerType.THIRD} - ${thirdCount}개")
        println("${WinnerType.SECOND} - ${secondCount}개")
        println("${WinnerType.FIRST} - ${firstCount}개")
        println("총 수익률은 ${myLotto.rateOfReturn}%입니다.")
    }
}
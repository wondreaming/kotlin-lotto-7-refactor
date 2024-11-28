package lotto.view

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
}
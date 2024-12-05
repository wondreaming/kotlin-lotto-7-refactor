package lotto.controller.domain

import lotto.model.MyLotto
import lotto.view.InputView
import lotto.view.OutputView

class UserInteractionController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {
    fun handlePurchaseCost(): String {
        outputView.showStartMessage()
        val purchaseCost = inputView.getInput()
        return purchaseCost
    }

    fun handlePurchaseLotto(myLotto: MyLotto) {
        outputView.showPurchaseLotto(myLotto)
    }

    fun handleLottoNumbers(): String {
        outputView.showLottoNumbers()
        val lottoNumbers = inputView.getInput()
        return lottoNumbers
    }

    fun handleBonusNumber(): String {
        outputView.showBonusNumber()
        val bonusNumber = inputView.getInput()
        return bonusNumber
    }

    fun handlePrize(myLotto: MyLotto) {
        outputView.showPrize(myLotto)
    }
}
package lotto.controller.domain

import lotto.view.InputView
import lotto.view.OutputView

class UserInteractionController(
    val inputView: InputView = InputView(),
    val outputView: OutputView = OutputView(),
) {
    fun handlePurchaseCost(): String {
        outputView.showStartMessage()
        val purchaseCost = inputView.getInput()
        return purchaseCost
    }
}
package lotto.controller.domain

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
}
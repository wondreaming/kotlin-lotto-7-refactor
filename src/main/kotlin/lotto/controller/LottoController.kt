package lotto.controller

import lotto.controller.domain.UserInteractionController

class LottoController(
    val userInteractionController: UserInteractionController = UserInteractionController()
) {
    fun run() {
        val purchaseCost = userInteractionController.handlePurchaseCost()
    }
}
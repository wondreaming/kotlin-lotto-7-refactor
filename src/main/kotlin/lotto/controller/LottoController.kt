package lotto.controller

import lotto.controller.domain.UserInteractionController
import lotto.controller.validator.PurchaseCostValidator

class LottoController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val purchaseCostValidator: PurchaseCostValidator = PurchaseCostValidator(),
) {
    fun run() {
        val purchaseCost = userInteractionController.handlePurchaseCost()
        purchaseCostValidator(purchaseCost)
    }
}
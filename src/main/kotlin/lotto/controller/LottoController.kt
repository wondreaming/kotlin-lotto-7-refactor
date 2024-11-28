package lotto.controller

import lotto.controller.domain.UserInteractionController
import lotto.controller.validator.PurchaseCostValidator
import lotto.model.MyLotto

class LottoController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val purchaseCostValidator: PurchaseCostValidator = PurchaseCostValidator(),
) {
    fun run() {
        val purchaseCost = getPurchaseCost()
        val myLotto = MyLotto(purchaseCost)
        showPurchaseLotto(myLotto)
    }

    private fun getPurchaseCost(): Int {
        val purchaseCost = userInteractionController.handlePurchaseCost()
        purchaseCostValidator(purchaseCost)
        return purchaseCost.toInt()
    }

    private fun showPurchaseLotto(myLotto: MyLotto) {
        userInteractionController.handlePurchaseLotto(myLotto)
    }
}
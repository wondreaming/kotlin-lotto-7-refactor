package lotto.controller

import lotto.controller.domain.UserInteractionController
import lotto.controller.validator.BonusNumberValidator
import lotto.controller.validator.PurchaseCostValidator
import lotto.controller.validator.LottoNumbersValidator
import lotto.model.Lotto
import lotto.model.MyLotto

class LottoController(
    private val userInteractionController: UserInteractionController = UserInteractionController(),
    private val purchaseCostValidator: PurchaseCostValidator = PurchaseCostValidator(),
    private val lottoNumbersValidator: LottoNumbersValidator = LottoNumbersValidator(),
    private val bonusNumberValidator: BonusNumberValidator = BonusNumberValidator(),
) {
    fun run() {
        val purchaseCost = getPurchaseCost()
        val myLotto = MyLotto(purchaseCost)
        showPurchaseLotto(myLotto)
        val winningNumbers = getLottoNumber()
        val bonusNumber = getBonusNumber(winningNumbers)
    }

    private fun getPurchaseCost(): Int {
        val purchaseCost = userInteractionController.handlePurchaseCost()
        purchaseCostValidator(purchaseCost)
        return purchaseCost.toInt()
    }

    private fun showPurchaseLotto(myLotto: MyLotto) {
        userInteractionController.handlePurchaseLotto(myLotto)
    }

    private fun getLottoNumber(): Lotto {
        val lottoNumbers = userInteractionController.handleLottoNumbers()
        lottoNumbersValidator(lottoNumbers)
        val winningNumbers = Lotto(lottoNumbers.split(",").map { it.trim().toInt() })
        return winningNumbers
    }

    private fun getBonusNumber(winningNumbers: Lotto): Int {
        val bonusNumber = userInteractionController.handleBonusNumber()
        bonusNumberValidator(bonusNumber, winningNumbers)
        return bonusNumber.toInt()
    }
}
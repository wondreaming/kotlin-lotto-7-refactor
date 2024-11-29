package lotto.controller.validator

import lotto.model.Lotto

class BonusNumberValidator {
    operator fun invoke(input: String, winningNumbers: Lotto) {
        isEmpty(input)
        isInteger(input)
        isBetween(input)
        isDuplicate(input, winningNumbers)
    }

    private fun isEmpty(input: String) {
        require(input.isNotEmpty()) { BonusNumberErrorType.EMPTY_INPUT }
    }

    private fun isInteger(input: String) {
        requireNotNull(input.toIntOrNull()) { BonusNumberErrorType.NOT_INTEGER }
    }

    private fun isBetween(input: String) {
        val bonusNumber = input.toInt()
        require(bonusNumber in 1..45) { BonusNumberErrorType.BETWEEN_1_45 }
    }

    private fun isDuplicate(input: String, winningNumbers: Lotto) {
        val bonusNumber = input.toInt()
        require(bonusNumber !in winningNumbers.winningNumbers) { BonusNumberErrorType.DUPLICATE }
    }
}
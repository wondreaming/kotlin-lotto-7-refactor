package lotto.controller.validator

class PurchaseCostValidator {
    operator fun invoke(input: String) {
        isEmpty(input)
        isInteger(input)
        isZero(input)
        isNegativeNumber(input)
        isBetween(input)
        isUnits(input)
    }

    private fun isEmpty(input: String) {
        require(input.isNotEmpty()) { PurchaseErrorType.EMPTY_INPUT }
    }

    private fun isInteger(input: String) {
        requireNotNull(input.toIntOrNull()) { PurchaseErrorType.NOT_INTEGER }
    }

    private fun isZero(input: String) {
        require(input.toInt() != 0) { PurchaseErrorType.ZERO }
    }

    private fun isNegativeNumber(input: String) {
        require(input.toInt() > 0) {
            PurchaseErrorType.NEGATIVE_NUMBER
        }
    }

    private fun isBetween(input: String) {
        require(input.toInt() >= 1000) { PurchaseErrorType.BETWEEN }
    }

    private fun isUnits(input: String) {
        require(input.toInt() % 1000 == 0) { PurchaseErrorType.NO_UNITS }
    }
}
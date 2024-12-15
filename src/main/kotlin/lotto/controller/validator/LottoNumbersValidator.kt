package lotto.controller.validator

class LottoNumbersValidator {
    operator fun invoke(input: String) {
        isEmpty(input)
        val numbers = input.split(",").map { it.trim() }
        isEmpty(numbers)
        isInteger(numbers)
        isBetween(numbers)
        isDuplicate(numbers)
        isSix(numbers)
    }

    private fun isEmpty(input: String) {
        require(input.isNotEmpty()) { LottoNumbersErrorType.EMPTY_INPUT }
    }

    private fun isEmpty(numbers: List<String>) {
        require(numbers.all { it.isNotEmpty() }) { LottoNumbersErrorType.EMPTY_INPUT }
    }

    private fun isInteger(numbers: List<String>) {
        require(numbers.all { it.toIntOrNull() != null }) { LottoNumbersErrorType.NOT_INTEGER }
    }

    private fun isBetween(numbers: List<String>) {
        val nums = numbers.map { it.toInt() }
        require(nums.all { it in 1..45 }) { LottoNumbersErrorType.BETWEEN_1_45 }
    }

    private fun isDuplicate(numbers: List<String>) {
        val nums = numbers.map { it.toInt() }
        require(nums.size == nums.toSet().size) { LottoNumbersErrorType.DUPLICATE }
    }

    private fun isSix(numbers: List<String>) {
        val nums = numbers.map { it.toInt() }
        require(nums.size == 6) { LottoNumbersErrorType.SIX }
    }
}
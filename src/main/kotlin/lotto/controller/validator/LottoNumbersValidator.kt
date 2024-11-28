package lotto.controller.validator

class LottoNumbersValidator {
    operator fun invoke(input: String) {
        isEmpty(input)
        val nums = input.split(",").map { it.trim() }
        isEmpty(nums)
        isInteger(nums)
        isBetween(nums)
        isDuplicate(nums)
        isSix(nums)
    }

    private fun isEmpty(input: String) {
        require(input.isNotEmpty()) { LottoNumbersErrorType.EMPTY_INPUT }
    }

    private fun isEmpty(nums: List<String>) {
        require(nums.all { it.isNotEmpty() }) { LottoNumbersErrorType.EMPTY_INPUT }
    }

    private fun isInteger(nums: List<String>) {
        require(nums.all { it.toIntOrNull() != null }) { LottoNumbersErrorType.NOT_INTEGER }
    }

    private fun isBetween(nums: List<String>) {
        val nums = nums.map { it.toInt() }
        require(nums.all { it in 1..45 }) { LottoNumbersErrorType.BETWEEN_1_45 }
    }

    private fun isDuplicate(nums: List<String>) {
        val nums = nums.map { it.toInt() }
        require(nums.size == nums.toSet().size) { LottoNumbersErrorType.DUPLICATE }
    }

    private fun isSix(nums: List<String>) {
        val nums = nums.map { it.toInt() }
        require(nums.size == 6) { LottoNumbersErrorType.SIX }
    }
}
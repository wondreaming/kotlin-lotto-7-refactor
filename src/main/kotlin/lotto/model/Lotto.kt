package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    val winningNumbers: List<Int>
        get() = numbers

    override fun toString(): String {
        return numbers.joinToString(prefix = "[", separator = ", ", postfix = "]")
    }
}
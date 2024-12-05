package lotto.controller.validator

enum class PurchaseErrorType(
    private val errorMessage: String
) {
    EMPTY_INPUT("구입 금액에 빈 문자를 입력했습니다."),
    NOT_INTEGER("long 타입의 숫자나 문자 타입을 입력했습니다."),
    NEGATIVE_NUMBER("음수를 입력했습니다."),
    ZERO("0을 입력했습니다."),
    BETWEEN("1000원 미만의 금액을 입력했습니다."),
    NO_UNITS("1000원 단위가 아닌 금액을 입력했습니다.");

    override fun toString(): String = "$ERROR $errorMessage"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}
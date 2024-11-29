package lotto.controller.validator

enum class BonusNumberErrorType(
    private val errorMessage: String
) {
    EMPTY_INPUT("보너스 번호에 빈 문자를 입력했습니다."),
    NOT_INTEGER("long 타입의 숫자나 문자 타입을 입력했습니다."),
    BETWEEN_1_45("1에서 45까지 가능합니다."),
    DUPLICATE("보너스 번호에 로또 번호와 중복된 숫자를 입력했습니다.");

    override fun toString(): String = "$ERROR $errorMessage"

    companion object {
        private const val ERROR = "[ERROR]"
    }
}
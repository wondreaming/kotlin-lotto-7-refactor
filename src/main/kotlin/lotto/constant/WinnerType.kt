package lotto.constant

import java.text.NumberFormat
import java.util.*

enum class WinnerType(
    val matchingNumberCount: Int,
    val prizeAmount: Int,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    override fun toString(): String {
        return when (this) {
            SECOND -> "${matchingNumberCount}개 일치, 보너스 볼 일치 (${
                NumberFormat.getNumberInstance(Locale.KOREA).format(prizeAmount)
            }원)"

            else -> "${matchingNumberCount}개 일치 (${NumberFormat.getNumberInstance(Locale.KOREA).format(prizeAmount)}원)"
        }
    }
}
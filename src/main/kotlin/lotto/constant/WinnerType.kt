package lotto.constant

import java.text.NumberFormat
import java.util.*

enum class WinnerType(
    val matchingNumberCount: Int,
    val prizeAmount: Int,
) {
    FIRST(6, 2000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

//    val prizeAmount: String
//        get() = NumberFormat.getNumberInstance(Locale.KOREA).format(_prizeAmount)
}
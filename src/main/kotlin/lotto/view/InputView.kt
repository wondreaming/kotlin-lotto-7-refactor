package lotto.view

import camp.nextstep.edu.missionutils.Console.readLine

class InputView {
    fun getInput(): String {
        val userInput = readLine().trim()
        return userInput
    }
}
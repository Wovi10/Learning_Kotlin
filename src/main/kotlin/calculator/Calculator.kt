package calculator

import calculator.utils.Constants.DIVISION_OPERAND
import calculator.utils.Constants.PRODUCT_OPERAND
import calculator.utils.Constants.SUBTRACTION_OPERAND
import calculator.utils.Constants.SUM_OPERAND
import utils.Constants.SPACE

object Calculator {
    fun parse(s: String): Int {
        val (a, op, b) = s.split(SPACE)
        return when (op) {
            PRODUCT_OPERAND -> a.toInt() * b.toInt()
            DIVISION_OPERAND -> a.toInt() / b.toInt()
            SUM_OPERAND -> a.toInt() + b.toInt()
            SUBTRACTION_OPERAND -> a.toInt() - b.toInt()
            else -> throw IllegalArgumentException("Invalid operator")
        }
    }
}

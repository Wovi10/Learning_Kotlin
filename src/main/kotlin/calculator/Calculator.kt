package calculator

import utils.Constants.Calculator.DIVISION_OPERAND
import utils.Constants.Calculator.PRODUCT_OPERAND
import utils.Constants.Calculator.SUBTRACTION_OPERAND
import utils.Constants.Calculator.SUM_OPERAND
import utils.Constants.SPACE

object Calculator {
    fun parse(s: String): Int {
        val (a, op, b) = s.split(SPACE)
        return when (op){
            PRODUCT_OPERAND -> a.toInt() * b.toInt()
            DIVISION_OPERAND -> a.toInt() / b.toInt()
            SUM_OPERAND -> a.toInt() + b.toInt()
            SUBTRACTION_OPERAND -> a.toInt() - b.toInt()
            else -> throw IllegalArgumentException("Invalid operator")
        }
    }
}

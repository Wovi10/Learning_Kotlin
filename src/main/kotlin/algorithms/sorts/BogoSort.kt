package algorithms.sorts

import algorithms.sorts.utils.Constants.BOGO_SORT_TEXT
import algorithms.sorts.utils.Functions.createInputArray
import algorithms.sorts.utils.Functions.swapIndexes
import utils.Constants.ZERO
import java.time.LocalDateTime
import java.util.*
import java.util.Collections.shuffle
import kotlin.random.Random

object BogoSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = BOGO_SORT_TEXT
    private var numTries: Int = ZERO

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultBogoSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
        }
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this)
        bogoSort(arrayToSort_)
        return getSortInfo(numTries)
    }

    private fun defaultBogoSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = createInputArray(arraySize_, lowestValue_, highestValue_)
        bogoSort(arrayToSort)
    }

    private fun bogoSort(arrayToSort_: IntArray) {
        while (!isSorted(arrayToSort_)){
            shuffleArray(arrayToSort_)
            numTries++
        }
    }

    private fun shuffleArray(arrayToSort_: IntArray) {
        val arraySize = arrayToSort_.size
        for (i in arrayToSort_.indices){
            swapIndexes(arrayToSort_, i, Random.nextInt(0, arraySize))
        }
    }

    private fun isSorted(arrayToSort_: IntArray): Boolean {
        val arraySize = arrayToSort_.size
        for (i in 1 until arraySize){
            if (arrayToSort_[i] < arrayToSort_[i -1]) return false
        }
        return true
    }
}
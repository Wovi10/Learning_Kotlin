package algorithms.sorts

import algorithms.sorts.utils.Constants.HEAP_SORT_TEXT
import algorithms.sorts.utils.Functions.createInputArray
import algorithms.sorts.utils.Functions.swapIndexes
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime

private const val TWO = 2

object HeapSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = HEAP_SORT_TEXT
    override var numTries: Int = ZERO

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        startup(name, this)
        repeat(numRun_) { i ->
            defaultHeapSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(i, numRun_)
        }
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this, arrayToSort_)
        heapSort(arrayToSort_)
        startup(name, this, arrayToSort_)
        return getSortInfo()
    }

    private fun defaultHeapSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = createInputArray(arraySize_, lowestValue_, highestValue_)
        heapSort(arrayToSort)
    }

    private fun heapSort(arrayToSort_: IntArray) {
        val arraySize = arrayToSort_.size
        buildHeap(arrayToSort_, arraySize)
        for (i in (arraySize - ONE) downTo 1) {
            swapIndexes(arrayToSort_, ZERO, i)
            heapify(arrayToSort_, i, ZERO)
        }
    }

    private fun buildHeap(arrayToSort_: IntArray, arraySize: Int) {
        for (i in (arraySize / TWO - ONE) downTo ZERO) {
            heapify(arrayToSort_, arraySize, i)
        }
    }

    private fun heapify(arrayToSort_: IntArray, arraySize: Int, startNode: Int) {
        var largest = startNode
        val left = TWO * startNode + ONE
        val right = TWO * startNode + TWO

        largest = assignLargest(left, arraySize, arrayToSort_, largest)
        largest = assignLargest(right, arraySize, arrayToSort_, largest)

        if (largest != startNode){
            swapIndexes(arrayToSort_, startNode, largest)
            heapify(arrayToSort_, arraySize, largest)
        }
    }

    private fun assignLargest(potLargest: Int, arraySize: Int, arrayToSort_: IntArray, largest_: Int): Int {
        var largest = largest_
        if (potLargest < arraySize && arrayToSort_[potLargest] > arrayToSort_[largest]) largest = potLargest
        return largest
    }
}
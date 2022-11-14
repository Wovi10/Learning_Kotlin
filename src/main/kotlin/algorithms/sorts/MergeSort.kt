package algorithms.sorts

import algorithms.sorts.utils.Constants.MERGE_SORT_TEXT
import algorithms.sorts.utils.Functions.createInputArray
import utils.Constants.ONE
import utils.Constants.ZERO
import java.time.LocalDateTime


object MergeSort : SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String = MERGE_SORT_TEXT
    override var numTries: Int = ZERO

    override fun sort(arraySize_: Int, lowestValue_: Int, highestValue_: Int, numRun_: Int) {
        if (lowestValue_ > highestValue_) return
        startup(name, this)
        repeat(numRun_) { runNum ->
            defaultMergeSort(arraySize_, lowestValue_, highestValue_)
            updateProgressBar(runNum, numRun_)
        }
    }

    override fun sort(arrayToSort_: IntArray): String {
        startup(name, this, arrayToSort_)
        mergeSort(arrayToSort_, ZERO, arrayToSort_.size - ONE)
        return getSortInfo()
    }

    private fun defaultMergeSort(arraySize_: Int, lowestValue_: Int, highestValue_: Int) {
        val arrayToSort = createInputArray(arraySize_, lowestValue_, highestValue_)
        mergeSort(arrayToSort, ZERO, arraySize_ - ONE)
    }

    private fun mergeSort(arrayToSort_: IntArray, lowestIndex: Int, highestIndex: Int) {
        if (lowestIndex >= highestIndex) return
        val middlePoint = getMiddleNum(lowestIndex, highestIndex)

        mergeSort(arrayToSort_, lowestIndex, middlePoint)
        mergeSort(arrayToSort_, middlePoint + ONE, highestIndex)

        merge(arrayToSort_, lowestIndex, middlePoint, highestIndex)
    }

    private fun merge(arrayToSort_: IntArray, lowestIndex: Int, middlePoint: Int, highestIndex: Int) {
        val leftArrSize = middlePoint - lowestIndex + ONE
        val rightArrSize = highestIndex - middlePoint

        val leftArr = IntArray(leftArrSize)
        val rightArr = IntArray(rightArrSize)

        fillLeftArray(leftArrSize, leftArr, arrayToSort_, lowestIndex)
        fillRightArray(rightArrSize, rightArr, arrayToSort_, middlePoint)

        var i = ZERO;
        var j = ZERO;
        var k = lowestIndex
        while (i < leftArrSize && j < rightArrSize) {
            if (leftArr[i] <= rightArr[j]) {
                arrayToSort_[k] = leftArr[i]
                i++
            } else {
                arrayToSort_[k] = rightArr[j]
                j++
            }
            k++
        }

        k = copyRestOfArr(i, leftArrSize, arrayToSort_, k, leftArr)
        k = copyRestOfArr(j, rightArrSize, rightArr, k, arrayToSort_)
    }

    private fun copyRestOfArr(
        indexSourceArr: Int,
        sourceArrSize: Int,
        sourceArr: IntArray,
        indexDestArr: Int,
        destinationArr: IntArray
    ): Int {
        var iSource = indexSourceArr
        var iDest = indexDestArr
        while (iSource < sourceArrSize) {
            destinationArr[iDest] = sourceArr[iSource]
            iSource++
            iDest++
        }
        return iDest
    }

    private fun fillRightArray(
        rightArrSize: Int,
        rightArr: IntArray,
        arrayToSort_: IntArray,
        middlePoint: Int
    ) {
        for (i in 0 until rightArrSize) {
            rightArr[i] = arrayToSort_[middlePoint + ONE + i]
        }
    }

    private fun fillLeftArray(
        leftArrSize: Int,
        leftArr: IntArray,
        arrayToSort_: IntArray,
        lowestIndex: Int
    ) {
        for (i in 0 until leftArrSize) {
            leftArr[i] = arrayToSort_[lowestIndex + i]
        }
    }
}
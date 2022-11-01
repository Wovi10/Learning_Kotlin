package algorithms.sorts

import java.time.LocalDateTime

object RadixSort: SortType() {
    override var startTime: LocalDateTime = LocalDateTime.now()
    override val name: String
        get() = TODO("Not yet implemented")

    override fun sort(arraySize: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        resetVariables()
        for (i in 0 until numRun){
            runRadixSort(arraySize, lowerBound, upperBound)
        }
        printEndText(numRun, name)
    }

    private fun runRadixSort(arraySize: Int, lowerBound: Int, upperBound: Int) {
        
        TODO("Not yet implemented")
    }
}
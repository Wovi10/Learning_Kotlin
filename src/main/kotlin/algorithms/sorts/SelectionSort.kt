package algorithms.sorts

object SelectionSort: SortType() {

    override fun sort(size: Int, lowerBound: Int, upperBound: Int, numRun: Int) {
        for (x in 0 .. numRun){
            runSelectionSort(size, lowerBound, upperBound)
        }

        TODO("Not yet implemented")
    }

    private fun runSelectionSort(size: Int, lowerBound: Int, upperBound: Int) {
        val arrayToSort = createInputArray(size, lowerBound, upperBound)
        TODO("Not yet implemented")
    }
}
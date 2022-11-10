package algorithms.utils

object Constants {
    const val TWO = 2
    const val SIXTY = 60
    const val HUNDRED = 100
    const val THOUSAND = 1000
    const val ONE_MILLION = 1000000

    const val NUMBER_BASE = 10

    object SearchTypes{
        private const val SEARCH_TEXT = "search"
        const val BINARYSEARCH_TEXT = "Binary $SEARCH_TEXT"
        const val LINEARSEARCH_TEXT = "Linear $SEARCH_TEXT"
        const val EMPTYSEARCH_TEXT = "Empty $SEARCH_TEXT"
    }

    object SortTypes{
        private const val SORT_TEXT = "sort"
        const val BUBBLESORT_TEXT = "Bubble $SORT_TEXT"
        const val INSERTIONSORT_TEXT = "Insertion $SORT_TEXT"
        const val QUICKSORT_TEXT = "Quick $SORT_TEXT"
        const val RADIXSORT_TEXT = "Radix $SORT_TEXT"
        const val SELECTIONSORT_TEXT = "Selection $SORT_TEXT"
        const val EMPTYSORT_TEXT = "Empty $SORT_TEXT"
    }
}
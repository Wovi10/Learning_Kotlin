package interactive_Projects

class Questionaire constructor(numQuestions: Int) {
    private var numQuests: Int
    private var qAndA: ArrayList<Pair<String, String>>

    init {
        numQuests = numQuestions
        qAndA = ArrayList<Pair<String, String>>()
    }
}
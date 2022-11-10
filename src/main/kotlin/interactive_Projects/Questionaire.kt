package interactive_Projects

class Quiz constructor(numQuestions: Int) {
    private var numQuests: Int
    private var qAndA: ArrayList<Pair<String, String>>

    init {
        numQuests = numQuestions
        qAndA = ArrayList<Pair<String, String>>()
    }

    private fun setQuestions(){
        repeat(numQuests){questNumber ->
            println("What is your question?")
            val question = readln()
            println("What is the answer?")
            val answer = readln()
            val pairToAdd = Pair(question, answer)
            qAndA.add(pairToAdd)
        }
        println("That were all the questions.")
        println("Press")
    }
}
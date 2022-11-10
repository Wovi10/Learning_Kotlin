package interactive_Projects

import utils.Constants.ZERO

class Quiz constructor(numQuestions: Int) {
    private var numQuests: Int
    private var qAndA: ArrayList<Pair<String, String>>
//    private var points: Int = ZERO

    init {
        numQuests = numQuestions
        qAndA = ArrayList<Pair<String, String>>()
    }

    fun runQuiz() {
        setQuestions()
    }

    private fun setQuestions(){
        repeat(numQuests){
            println("What is your question?")
            val question = readln()
            println("What is the answer?")
            val answer = readln().lowercase()
            val pairToAdd = Pair(question, answer)
            qAndA.add(pairToAdd)
        }
        println("That were all the questions.")
        clearScreen()
        println("Type start and press enter to start the quiz. (q to stop)")
        val startQuiz = lookForStart()
        if (!startQuiz){
            quitQuiz()
            return
        }
        val points = startQuiz()
        endQuiz(points)
    }

    private fun endQuiz(points_: Int) {
        println("Quiz finished")
    }

    private fun lookForStart(): Boolean {
        var startQuiz = false
        when (readln().lowercase()){
            "start" -> startQuiz = true
            "q" -> startQuiz = false
            else -> {
                println("Did you mean start? (q to stop)")
                lookForStart()
            }
        }
        return startQuiz
    }

    private fun startQuiz(): Int {
        var points = 0
        for (pair in qAndA) {
            println(pair.first)
            when(readln().lowercase()){
                pair.second -> points = correctAnswer(points)
                else -> wrongAnswer(pair.second)
            }
        }
        return points
    }

    private fun wrongAnswer(answer: String) {
        println("Wrong...")
        println("Answer was $answer.")
        println()
    }

    private fun correctAnswer(points_: Int): Int {
        var points = points_
        points++
        println("Right!!!")
        println()
        return points
    }

    private fun quitQuiz() {
        println("See you another time!")
    }

    private fun clearScreen() {
        repeat(15){
            println()
        }
    }
}
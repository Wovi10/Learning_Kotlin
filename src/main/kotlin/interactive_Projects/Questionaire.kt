package interactive_Projects

import utils.Constants.InteractiveProjects.TEN
import utils.Constants.RichText.FOREGROUND_GREEN
import utils.Constants.RichText.FOREGROUND_RED
import utils.Constants.RichText.TEXT_STYLE_RESET
import utils.Constants.ZERO

class Quiz constructor(numQuestions: Int) {
    private var numQuests: Int
    private var qAndA: ArrayList<Pair<String, String>>
    private var points: Int = ZERO

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
        println()
        println("Quiz finished.")
        println("You scored $points_/${qAndA.size}")
    }

    private fun lookForStart(): Boolean {
        val answer = readln().lowercase()
        println(answer)
        when (answer){
            "start" -> return true
            "q" -> return false
            else -> {
                println("else triggered")
                println("Did you mean start? (q to stop)")
                lookForStart()
            }
        }
        return true
    }

    private fun startQuiz(): Int {
        var points = ZERO
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
        println(FOREGROUND_RED + "Wrong... Answer was $answer.")
        println(TEXT_STYLE_RESET)
    }

    private fun correctAnswer(points_: Int): Int {
        var points = points_
        points++
        println(FOREGROUND_GREEN + "Right!!!")
        println(TEXT_STYLE_RESET)
        return points
    }

    private fun quitQuiz() {
        println("See you another time!")
    }

    private fun clearScreen() {
        repeat(TEN){
            println()
        }
    }
}
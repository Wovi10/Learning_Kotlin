package algorithms

abstract class Algorithm {
    open fun getTimeString(_time: Double): String{
        var time = _time
        if (time < 1000){
            return "It took $time nanos."

        }
        time /= 1000
        if (time < 60){
            return "It took $time seconds."
        }
        time /= 60
        if (time < 60){
            return "It took $time minutes."
        }
        time /= 60
        return "It took $time hours."
    }

    abstract fun printStartText(numRun: Int, name: String)
}
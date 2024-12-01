import java.io.BufferedReader
import java.io.File

abstract class AoCDay<T>(path: String) {

    var data: T

    abstract fun firstSolution(): Any

    abstract fun secondSolution(): Any

    abstract fun processData(rawData: String): T

    init {
        val raw: String = readData(path)
        data = processData(raw)
    }
    private fun readData(path: String): String {
        val bufferedReader: BufferedReader = File(path).bufferedReader()
        val inputString = bufferedReader.use { it.readText() }
        return inputString
    }
}


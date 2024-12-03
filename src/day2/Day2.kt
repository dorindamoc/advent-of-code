package day2

import AoCDay
import kotlin.math.absoluteValue

typealias Day2Data = List<List<Int>>

class Day2: AoCDay<Day2Data>("src/day2/input.txt") {
    override fun firstSolution(): Int {

        fun notSafe(num: Int) = num > 3 || num == 0

        val filteredData = data.filter { line ->
            var safe = true
            var up = mutableListOf<Boolean>() // true up, false down
            for (i in 0..line.size-2) {
                val diff = (line[i]-line[i+1])
                if (notSafe(diff.absoluteValue)) {
                    safe = false
                    break
                } else {
                    up.add(diff > 0)
                    if (up.any{it == true} && up.any{it == false}) {
                        safe = false
                        up = mutableListOf<Boolean>()
                        break
                    }
                }
                up = mutableListOf<Boolean>()
            }
            safe
        }
        return filteredData.size
    }

    override fun secondSolution(): Any {
        TODO("Not yet implemented")
    }

    override fun processData(rawData: String): Day2Data {
        val processedData = mutableListOf<List<Int>>()
        for (line in rawData.lines()) {
            val cleanLine = line.trim().split("\\s+".toRegex())
            if (cleanLine.isEmpty()) continue
            val convertedLine = cleanLine.filter {it.isNotBlank()}.map { it.toInt() }
            processedData.add(convertedLine)
        }
        return processedData.toList()
    }

    companion object {
        data class DummyData(
            val data: List<List<Int>> = listOf(
                listOf(7, 6, 4, 2, 1),
                listOf(1, 2, 7, 8, 9),
                listOf(9, 7, 6, 2, 1),
                listOf(1, 3, 2, 4, 5),
                listOf(8, 6, 4, 4, 1),
                listOf(1, 3, 6, 7, 9),
            )
        )
    }
}
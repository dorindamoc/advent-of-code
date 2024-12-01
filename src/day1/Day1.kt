package day1

import AoCDay
import kotlin.math.absoluteValue

typealias ScrambledData = Pair<List<Int>, List<Int>>

class Day1: AoCDay<ScrambledData>("src/day1/day1.txt") {

    override fun  processData(rawData: String): ScrambledData {
        val leftList = mutableListOf<Int>()
        val rightList = mutableListOf<Int>()

        for (line in rawData.lines()) {
            val cleanLine = line.trim().split("\\s+".toRegex())
            if (cleanLine.size < 2) continue
            leftList.add(cleanLine[0].toInt())
            rightList.add(cleanLine[1].toInt())
        }

        return Pair(leftList.sorted().toList(), rightList.sorted().toList())
    }

    override fun firstSolution(): Int {
        val diffs = mutableListOf<Int>()
        val f = data.first.sorted()
        val s = data.second.sorted()
        for (i in data.first.indices) {
            val diff = (f[i] - s[i]).absoluteValue
            diffs.add(diff)
        }
        return diffs.sum()
    }

    override fun secondSolution(): Int {
        val left = data.first.sorted()
        val right = data.second.sorted()

        var result = 0
        for (num in left) {
            val count = right.count {it == num}
            result+= num*count
        }
        return result
    }

    companion object {
        data class _DummyData(
            val firstList: List<Int> = listOf(3,4,2,1,3,3),
            val secondList: List<Int> = listOf(4,3,5,3,9,3)
        )
    }
}



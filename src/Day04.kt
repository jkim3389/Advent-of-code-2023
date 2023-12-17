import java.lang.Math.pow
import kotlin.math.pow


fun main() {
    fun part1(input: List<String>):Int {
        var sum = 0
        input.forEach {
            str ->
                val (winning, numbers) =str.split(":")[1].trim().split("|")
                val numArr = numbers.trim().split(" ").filter{it.isNotEmpty()}
                val result = winning.trim().split(" ")
                    .filter {
                        it.isNotEmpty() && numArr.contains(it.trim())
                    }
                if(result.isNotEmpty()) {
                    sum+= 2.0.pow((result.size - 1)).toInt()
                }
        }
        return sum
    }
    fun part2(input: List<String>):Int {
        return 0
    }
    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}

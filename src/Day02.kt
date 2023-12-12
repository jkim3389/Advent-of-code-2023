import kotlin.math.max

data class Cube(
//        val id: Int,
        var red: Int,
        var green: Int,
        var blue: Int,
)

fun main() {

    fun part1(input: List<String>):Int {
        var idSum = 0
        val maxCubeLimit = Cube(12, 13, 14)
        input.filter {
            str ->
                val (_, cubes) = str.split(":")
                var isValid = true
                cubes.trim().split(";").forEach {
                    it.trim().split(",").forEach {
                        if(
                            (it.contains("red") && it.split("red")[0].trim().toInt() > maxCubeLimit.red) ||
                            (it.contains("green") && it.split("green")[0].trim().toInt() > maxCubeLimit.green) ||
                            (it.contains("blue") && it.split("blue")[0].trim().toInt() > maxCubeLimit.blue)
                        ){
                            isValid = false
                        }
                    }
                }
            isValid
        }.forEach {
            println(it)
            idSum += it.split(":")[0].split("Game")[1].trim().toInt()
        }
        return idSum
    }
    fun part2(input: List<String>):Int {
        var sum = 0
        input.forEach { str: String ->
            val minCube = Cube(0,0,0)
            val (_, cubes) = str.split(":")
            cubes.trim().split(";").forEach{
                it.trim().split(",").forEach{
                    if(it.contains("red")) {
                        minCube.red = max(it.split("red")[0].trim().toInt(), minCube.red)
                    }
                    if(it.contains("green")) {
                        minCube.green = max(it.split("green")[0].trim().toInt(), minCube.green)
                    }
                    if(it.contains("blue")) {
                        minCube.blue = max(it.split("blue")[0].trim().toInt(), minCube.blue)
                    }
                }
            }
            sum += (minCube.red * minCube.blue * minCube.green)
        }
        return sum
    }

    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}


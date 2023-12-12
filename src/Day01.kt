val map = mapOf(
        "one" to 1,
        "two" to 2,
        "three" to 3,
        "four" to 4,
        "five" to 5,
        "six" to 6,
        "seven" to 7,
        "eight" to 8,
        "nine" to 9
)

fun main() {
    fun part1(input: List<String>): Int {
        var sum = 0
        for (str in input) {
            val first: Char = str.first { c: Char -> c.isDigit()}
            val last: Char = str.last { c: Char -> c.isDigit() }
            sum+="$first$last".toInt()
        }
        return sum
    }
//    Brute Force solution..
    fun part2(input: List<String>): Int {
        val keyList = map.keys
        val newInput = mutableListOf<String>()
        for (str in input) {
            var replacedStr = str
            val firstIndex = str.indexOfAny(keyList)
            if (firstIndex != -1) {
                var letter = ""
                for (i in 3..5) {
                    if (map[str.substring(firstIndex, firstIndex + i)] != null) {
                        letter = str.substring(firstIndex, firstIndex + i)
                        break
                    }
                }
                replacedStr = str.replaceFirst(oldValue = letter, newValue = map[letter].toString())
            }

            val lastIndex = replacedStr.lastIndexOfAny((keyList))
            if (lastIndex != -1) {
                var letter = ""
                for (i in 3..5) {
                    if (map[replacedStr.substring(lastIndex, lastIndex + i)] != null) {
                        letter = replacedStr.substring(lastIndex, lastIndex + i)
                        break
                    }
                }
                replacedStr = replacedStr.replaceRange(lastIndex..lastIndex+letter.length-1, replacement = map[letter].toString())
            }
            newInput.add(replacedStr)
        }
        return part1(newInput)
    }

    // test if implementation meets criteria from the description, like:
//    val testInput = readInput("Day01_test")
//    check(part1(testInput) == 1)

    val input = readInput("Day01")
//    part1(input).println()
    part2(input).println()
}


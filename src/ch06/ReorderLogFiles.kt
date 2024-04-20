package ch06

class Solution3 {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val letterLogs = mutableListOf<String>()
        val digitLogs = mutableListOf<String>()

        for (log in logs) {
            val elmList = log.split(" ")
            val contents = elmList.subList(1, elmList.size)

            // if (contents == contents.filter { it == it.filter { char -> char.isLetter() } }) {
                // if (contents == contents.map { it.toLowerCase() }) {
            if (contents[0][0].isLetter() && contents[0][0].isLowerCase()) {
                letterLogs.add(log)
            }

            // if (contents == contents.filter { it == it.filter { char -> char.isDigit() } }) {
            if (contents[0][0].isDigit()) {
                digitLogs.add(log)
            }
        }

        letterLogs.sortWith(Comparator { i, j ->
            val splitI = i.split(" ")
            val contentsI = splitI.subList(1, splitI.size).joinToString(" ")
            val identifierI = splitI[0]
            val splitJ = j.split(" ")
            val contentsJ = splitJ.subList(1, splitJ.size).joinToString(" ")
            val identifierJ = splitJ[0]

            val cmp = contentsI.compareTo(contentsJ)
            if (cmp == 0) {
                identifierI.compareTo(identifierJ)
            }
            else {
                cmp
            }
        })

        return (letterLogs + digitLogs).toTypedArray()
    }
}

fun main() {
    val sol = Solution3()
    println(sol.reorderLogFiles(arrayOf("dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero")).contentToString())
    println(sol.reorderLogFiles(arrayOf("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo")).contentToString())
}
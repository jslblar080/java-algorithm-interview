package ch06

class Solution3 {
    fun reorderLogFiles(logs: Array<String>): Array<String> {
        val len = logs.size
        val logsOriginal = logs.copyOf()

        fun isLetterLogs(s: String): Boolean {
            val elmList = s.split(" ")

            for (elm in elmList.subList(1, elmList.size)) {
                if (elm != elm.toLowerCase()) { return false }
                if (elm != elm.filter { it.isLetter() }) { return false }
            }

            return true
        }

        fun isDigitLogs(s: String): Boolean {
            val elmList = s.split(" ")

            for (elm in elmList.subList(1, elmList.size)) {
                if (elm != elm.filter { it.isDigit() }) { return false }
            }

            return true
        }

        fun contents(s: String): String {
            val elmList = s.split(" ")

            return elmList.subList(1, elmList.size).joinToString(" ")
        }

        fun identifier(s: String): String {
            val elmList = s.split(" ")

            return elmList[0]
        }

        // The letter-logs come before all digit-logs.
        for (i in 0 until len-1) {
            for (j in i+1 until len) {
                if (isDigitLogs(logs[i]) && isLetterLogs(logs[j])) {
                    val temp = logs[i]
                    logs[i] = logs[j]
                    logs[j] = temp
                }
            }
        }

        // The letter-logs are sorted lexicographically by their contents.
        // If their contents are the same, then sort them lexicographically by their identifiers.
        for (i in 0 until len-1) {
            for (j in i+1 until len) {
                if (isLetterLogs(logs[i]) && isLetterLogs(logs[j])) {
                    if (contents(logs[i]) > contents(logs[j])) {
                        val temp = logs[i]
                        logs[i] = logs[j]
                        logs[j] = temp
                    }

                    if (contents(logs[i]) == contents(logs[j])) {
                        if (identifier(logs[i]) > identifier(logs[j])) {
                            val temp = logs[i]
                            logs[i] = logs[j]
                            logs[j] = temp
                        }
                    }
                }
            }
        }

        // The digit-logs maintain their relative ordering.
        for (i in 0 until len-1) {
            for (j in i+1 until len) {
                if (isDigitLogs(logs[i]) && isDigitLogs(logs[j])) {
                    val idxI = logsOriginal.indexOf(logs[i])
                    val idxJ = logsOriginal.indexOf(logs[j])
                    if (idxI > idxJ) {
                        val temp = logs[i]
                        logs[i] = logs[j]
                        logs[j] = temp
                    }
                 }
            }
        }

        return logs
    }
}

fun main() {
    val sol = Solution3()
    println(sol.reorderLogFiles(arrayOf("dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero")).contentToString())
    println(sol.reorderLogFiles(arrayOf("a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo")).contentToString())
}
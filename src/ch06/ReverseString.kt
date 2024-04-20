package ch06

class Solution2 {
    fun reverseString(s: CharArray): Unit {
        val len = s.size
        val s2 = CharArray(len)

        for (i in len-1 downTo 0) {
            s2[len - 1 - i] = s[i]
        }

        for (i in 0..len-1) {
            s[i] = s2[i]
        }

        println(s.contentToString())
    }
}

fun main() {
    val sol = Solution2()
    sol.reverseString(charArrayOf('h', 'e', 'l', 'l', 'o'))
    sol.reverseString(charArrayOf('H', 'a', 'n', 'n', 'a', 'h'))
}

package ch06

class Solution {
    fun isPalindrome(s: String): Boolean {
        val str = s.filter{ it.isLetterOrDigit()}.toLowerCase()
        val len = str.length
        val mid = len / 2

        for (i in 0 until mid) {
            if (str[i] != str[len - i - 1]) {
                return false
            }
        }

        return true
    }
}

fun main() {
    val solution = Solution()
    println(solution.isPalindrome("A man, a plan, a canal: Panama")) // true
    println(solution.isPalindrome("race a car")) // false
    println(solution.isPalindrome(" ")) // true
}
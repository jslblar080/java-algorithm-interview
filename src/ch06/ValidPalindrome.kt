package ch06

class Solution {
    fun isPalindrome(s: String): Boolean {
        val str = s.replace("[^a-zA-Z0-9]".toRegex(), "").toLowerCase()
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
    println(solution.isPalindrome("A man, a plan, a canal: Panama"))
    println(solution.isPalindrome("race a car"))
    println(solution.isPalindrome(" "))
}
package ua.kpi.its

// Task 1: Check if a number is even or odd
fun checkEvenOrOdd(input: Int? = null): String {
    if (input == null){
        return ""
    }
    else if (input % 2 == 0){
        return "even"
    }
    return "odd"

}

// Task 2: Sum of the first five prime numbers
fun sumOfFirstFivePrimes(): Int = generatePrimes(5).sum()

private fun generatePrimes(count: Int): List<Int> {
    val primes = mutableListOf<Int>()
    var num = 2
    while (primes.size < count) {
        if (num.isPrime()) primes.add(num)
        num++
    }
    return primes
}

private fun Int.isPrime(): Boolean {
    if (this < 2) return false
    return (2..kotlin.math.sqrt(this.toDouble()).toInt()).none { this % it == 0 }
}

// Task 3: Sum of a series of numbers made up of ones
fun sumOfOnesSeries(n: Int): Int = (1..n).fold(0 to 0) { (sum, current), _ ->
    val next = current * 10 + 1
    sum + next to next
}.first

// Task 4: Fibonacci sequence
fun fibonacci(n: Int): Int {
    require(n >= 0) { "n should be non-negative" }
    return generateFibonacciSequence(n).last()
}

private fun generateFibonacciSequence(n: Int): List<Int> {
    val sequence = mutableListOf(0, 1)
    for (i in 2..n) {
        sequence.add(sequence[i - 1] + sequence[i - 2])
    }
    return sequence.take(n + 1)
}

// Task 5: Reverse a string
fun reverseString(input: String): String = input.reversed()

// Task 6: Factorial of a number
fun factorial(n: Int): Int {
    require(n >= 0) { "n should be non-negative" }
    return (1..n).fold(1) { acc, i -> acc * i }
}

// Task 7: Frequency analysis of a string
fun frequencyAnalysis(input: String): Map<Char, Int> =
    input.groupingBy { it }.eachCount()

// Task 8: Find the minimum element in a list
fun findMinimum(numbers: List<Int>): Int? = numbers.minOrNull()

// Task 9: Check if a string is a palindrome
fun isPalindrome(input: String): Boolean {
    val cleanedInput = input.filter { it.isLetterOrDigit() }.toLowerCase()
    return cleanedInput == cleanedInput.reversed()
}

// Task 10: Caesar cipher
fun caesarCipher(input: String, shift: Int): String {
    val actualShift = shift % 26
    return input.map { char ->
        when {
            char.isUpperCase() -> shiftChar(char, actualShift, 'A')
            char.isLowerCase() -> shiftChar(char, actualShift, 'a')
            else -> char
        }
    }.joinToString("")
}

private fun shiftChar(char: Char, shift: Int, base: Char): Char {
    val baseCode = base.toInt()
    return ((char.toInt() - baseCode + shift) % 26 + baseCode).toChar()
}

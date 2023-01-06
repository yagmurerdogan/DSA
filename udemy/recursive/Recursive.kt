fun main(args: Array<String>) {
    println("Power Of Two, n=3 (8)-> ${powerOfTwo(3)}")
    println("Power Of Three, n=3 (27)-> ${powerOfThree(3)}")
    println("Factorial, n=-4 (-1)-> ${factorial(-4)}")
    println("Fibonacci, n=5 (120)-> ${factorial(5)}")
    println("Sum of Digits, n=54 (9)-> ${sumOfDigits(54)}")
    println("Decimal to binary, n=13 (1101)-> ${decimalToBinary(13)}")
}

// Recursive way
fun powerOfTwo(n: Int): Int {
    return when (n) {
        0 -> 1
        else -> 2 * powerOfTwo(n - 1)
    }
}

//Iterative way
fun powerOfThree(n: Int): Int {
    var power = 1
    for (i in 1..n) {
        power *= 3
    }
    return power
}


//Recursive Factorial
fun factorial(n: Int): Int {
    return when {
        n < 0 -> -1
        n == 1 || n == 0 -> 1
        else -> n.times(factorial(n - 1))
    }
}

//Recursive Fibonacci
fun fibonacci(n: Int): Int {
    return when {
        n < 0 -> -1
        n == 0 || n == 1 -> n
        else -> fibonacci(n - 1).plus(fibonacci(n - 2))
    }
}


// Recursion Interview Questions

// How to find the sum of digits of a positive integer number using recursion?

// 10 -> 10/10 = 1 and Remainder = 0
// 54 -> 54/10 = 5 and Remainder = 4
// 112 -> 112/10 = 11 and Remainder = 2

fun sumOfDigits(n: Int): Int {
    return when {
        n <= 0 -> 0
        else -> n % 10 + sumOfDigits(n / 10)
    }
}

// How to find the greatest common divisor of two numbers using recursion?

// gcd(8,12) = 4  -> 8 = 2*2*2  12 = 2*2*3
// Euclidean algorithm -> gcd(a,0) = a | gcd(a,b) = gcd(b, a mod b)
// gcd(48,18)
// 48/18 = 2 remainder = 12
// 18/12 = 1 remainder = 6
// 12/6 = 2 reminder = 0

fun gcd(a: Int, b: Int): Int {
    return when {
        a < 0 || b < 0 -> -1
        b == 0 -> a
        else -> return gcd(b, a % b)
    }
}

fun decimalToBinary(n: Int): Int {
    return when (n) {
        0 -> 0
        else -> n%2 + 10*decimalToBinary(n/2)
    }
}
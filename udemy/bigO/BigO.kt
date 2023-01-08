/*
Question-1
Create a func which calculates the sum and product of elements of array
Find the time complexity for created method
 */

//Time complexity -> O(n) linear
fun spofArray(arr: Array<Int>) {
    var sum = 0    // O(1)
    var product = 1    // O(1)
    for(i in arr.indices) {    // O(n)
        sum += arr[i]    // O(1)
    }
    for(i in arr.indices) {    // O(n)
        product *= arr[i]    // O(1)
    }

    println("sum -> $sum product -> $product")    // O(1)
}


/*
Question-2
Create a func which prints to the console the pairs from given array
Find the time complexity for created method
 */

//Time complexity -> O(n^2) quadratic
fun printPairs(arr: Array<Int>) {
    for (i in arr.indices) {    // O(n)
        for (j in arr.indices) {    // O(n)
            println("${arr[i]},${arr[j]}")    // O(1)
        }
    }
}

//Time complexity -> O(n^2) quadratic
fun printUnorderedPairs(array: Array<Int>) {
    for (i in array.indices) {
        for (j in i + 1 until array.size) {
            println(array[i].toString() + ", " + array[j])
        }
    }
}

//Time complexity -> O(ab)
fun printUnorderedPairs(arrA: Array<Int>, arrB: Array<Int>) {
    for (i in arrA.indices) {
        for (j in arrB.indices) {
            if (arrA[i] < arrB[j]) {
                println("${arrA[i]},${arrB[j]}")
            }
        }
    }
}

//Time complexity -> O(ab) not O(n^2)!!
fun printUnorderedPairs(arrA: Array<Int>, arrB: Array<Int>) {
    for (i in arrA.indices) {
        for (j in arrB.indices) {
            if (arrA[i] < arrB[j]) {
                println("${arrA[i]},${arrB[j]}")
            }
        }
    }
}

//Time complexity -> O(ab) not O(n^2)!!
fun printUnorderedPairs(arrA: Array<Int>, arrB: Array<Int>) {
    for (i in arrA.indices) {    // O(a)
        for (j in arrB.indices) {    // O(b)
            for (k in 0..1000000) {    // O(1)!!!
                println("${arrA[i]},${arrB[j]}")    // O(1)
            }
        }
    }
}

/*
Question-6
Create a method which takes an array as a parameter and reverses it
Find the runtime of the created method?
 */

//Time complexity -> O(N) not O(N/2)!! Drop constants
fun reverseIntArray(arr: Array<Int>) {
    for (i in 0 until arr.size/2) {    // O(N/2)
        var other = arr.size-i-1    // O(1)
        var temp = arr[i]    // O(1)
        arr[i] = arr[other]    // O(1)
        arr[other] = temp    // O(1)
    }
    println(Arrays.toString(arr))    // O(1)
}

/*
Question-8
What is the runtime of the below code?
M(n) = O(1)+M(n-1)
-> O(n) (WTF?! search recursive funs big o notations again)
*/
fun factorial(n: Int): Int {    // M(n)
    return when {
        n < 0 -> -1    // O(1)
        n == 1 || n == 0 -> 1    // O(1)
        else -> n.times(factorial(n - 1))    // M(n-1)
    }
}

/*
Question-9
What is the runtime of the below code?
O(2^N)
*/
fun fibonacci(n: Int) {
    for (i in 0 until n) {
        fib(i)
    }
}
fun fib(n: Int) : Int{
    return when {
        n < 0 -> -1
        n == 0 || n == 1 -> n
        else -> fib(n - 1).plus(fib(n - 2))
    }
}
/*
Array can store data of specified type
Elements of an array are located in a contiguous
Each element of an array has a unique index
The size of an array is predefined and can not be modified

Types of arrays
-> one dimensional (access element directly one index arr[4] )
-> multi dimensional ( ex. Two dimensional -> row - column |  arr[0,4] )

 */

//Without array
fun avg() {
    val console = Scanner(System.`in`)
    println("How many day's temperatures?")
    val numDays = console.nextInt()
    var sum = 0
    for (i in 1..numDays) {
        println("Day$i's high temp: ")
        val next = console.nextInt()
        sum += next
    }
    val average = (sum / numDays).toDouble()
    println()
    println("Average temp = $average")
}

//With array
fun avgArray() {
    val console = Scanner(System.`in`)
    println("How many day's temperatures?")
    val numDays: Int = console.nextInt()
    val temps = IntArray(numDays)
    //record temps and find average
    var sum = 0
    for (i in 1..numDays) {
        println("Day" + (i + 1) + "'s high temp: ")
        temps[i] = console.nextInt()
        sum += temps[i]
    }
    val average = (sum / numDays).toDouble()
    // count days above average
    var above = 0
    for (i in temps.indices) {
        if (temps[i] > average) {
            above++
        }
    }
    println()
    println("Average temp = $average")
    println("$above days above average")
}

/*
Question-1
Missing Number / Leetcode
Find the missing number in an integer array of 1 to 100.
arrayElementsSum -> n(n+1)/2
Example for 10 elements

int intArray[] = {1, 2, 3, 4, 5, 6, 8, 9, 10};
missingNumber(intArray); // 7
 */

fun missingNumber(intArray: IntArray) {
    var sum1 = 0
    var sum2 = 0
    for (i in intArray) {
        sum1 += i
    }
    sum2 = 100 * (100 + 1) / 2
    val difference = sum2 - sum1
    System.out.println("Missing number is -> $difference")
}

/*
Question-2
Two Sum / Leetcode
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1]

Input: nums = [3,2,4], target = 6
Output: [1,2]
 */


/*
    Write a program to find all pairs of integers whose sum is equal to a given number
    - does array contain only positive or negative numbers?
    - what if the same pair repeats twice? Should we print it every time?
    - if the reverse of the pair is acceptable, can we print both (4,1) and (1,4) if the given sum is 5
    - do we need to print only distinct pairs? does (3,3) is valid pair for given sum of 6
    - how big is the array?
     */

/*
    Write a program to find all pairs of integers whose sum is equal to a given number
    - does array contain only positive or negative numbers?
    - what if the same pair repeats twice? Should we print it every time?
    - if the reverse of the pair is acceptable, can we print both (4,1) and (1,4) if the given sum is 5
    - do we need to print only distinct pairs? does (3,3) is valid pair for given sum of 6
    - how big is the array?
     */
fun twoSum(nums: IntArray, target: Int): IntArray? {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    throw IllegalArgumentException("No solution found")
}

/*
Question-3
Finding a Number in an Array
Write a program to to check if an array contains a number in Java.

int[] intArray = {1,2,3,4,5,6};
searchInArray(intArray, 6); // 5
 */

fun linearSearch(intArray: IntArray, value: Int) {
    for (i in intArray.indices) {
        if (intArray[i] == value) {
            println("Value is found at the index of $i")
            return
        }
    }
    println("$value is not found")
}

/*
Question-4
Max Product of Two Integers
How to find maximum product of two integers in the array where all elements are positive.

Example
int[] intArray = {10,20,30,40,50};
maxProduct(intArray) // (40,50)
 */

fun maxProduct(intArray: IntArray): String {
    var maxProduct = 0
    var pairs = ""

    for (i in intArray.indices) {
        for (j in i+1 until intArray.size) {
            if (intArray[i].times(intArray[j]) > maxProduct) {
                maxProduct = intArray[i].times(intArray[j])
                pairs = "${intArray[i]} , ${intArray[j]}"
            }
        }
    }

    return pairs
}

/*
Question-5
IsUnique / Contains Duplicate
Write a program to check if an array is unique or not.

Example

int[] intArray = {1,2,3,4,5,6};
isUnique(intArray) // true
 */

fun isUnique(nums: IntArray): Boolean {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] == nums[j]) {
                return false
            }
        }
    }
    return true
}

/*
Qestion-6
Permutation
Your are given two integer arrays. Write a program to check if they are permutation of each other.

Example

int[] array1 = {1,2,3,4,5};
int[] array2 = {5,1,2,3,4};
permutation(array1, array2)
Output -> true
 */

fun permutation(array1: IntArray, array2: IntArray): Boolean {
    if (array1.size != array2.size) {
        return false
    }
    var sum1 = 0
    var sum2 = 0
    var mul1 = 1
    var mul2 = 1
    for (i in array1.indices) {
        sum1 += array1[i]
        sum2 += array2[i]
        mul1 *= array1[i]
        mul2 *= array2[i]
    }
    return sum1 == sum2 && mul1 == mul2
}


/*
Question-7
Rotate Matrix
Given an image represented by an NxN matrix write a method to rotate the image by 90 degrees.
 */

fun rotateMatrix(matrix: Array<IntArray>): Boolean {
    if (matrix.isEmpty() || matrix.size != matrix[0].size) return false
    val n = matrix.size
    for (layer in 0 until n / 2) {
        val last = n - 1 - layer
        for (i in layer until last) {
            val offset = i - layer
            val top = matrix[layer][i]
            matrix[layer][i] = matrix[last - offset][layer]
            matrix[last - offset][layer] = matrix[last][last - offset]
            matrix[last][last - offset] = matrix[i][last]
            matrix[i][last] = top
        }
    }
    return true
}

/*
Question-8
Middle Function
Write a function called middle that takes a list and returns a new list that contains all but the first and last elements.

myArray = [1, 2, 3, 4]
middle(myArray)  # [2,3]
 */
fun middle(arr: IntArray): IntArray {
    return arr.copyOfRange(1, arr.size - 1)
}

/*
Question-9
2D Arrays
Given 2D array calculate the sum of diagonal elements.

Example
myArray2D= {{1,2,3},{4,5,6},{7,8,9}};
sumDiagonal(myArray2D) # 15
 */
fun sumDiagonal(a: Array<IntArray>): Int {
    var sum = 0
    for (i in a.indices) {
        sum += a[i][i]
    }
    return sum
}

/*
Question-10
Best Score
Given an array, write a function to get first, second best scores from the array.
Array may contain duplicates.

Example
myArray = {84,85,86,87,85,90,85,83,23,45,84,1,2,0}
firstSecond(myArray) // 90 87
 */
fun firstSecond(myArray: Array<Int>): String {
    Arrays.sort(myArray, Collections.reverseOrder())
    val first = myArray[0]
    var second: Int? = null
    for (i in myArray.indices) {
        if (myArray[i] != first) {
            second = myArray[i]
            break
        }
    }
    return "$first $second"
}

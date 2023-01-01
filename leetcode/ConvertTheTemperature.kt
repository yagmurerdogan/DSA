class Solution {
    fun convertTemperature(celsius: Double): DoubleArray
            = doubleArrayOf((celsius + 273.15), (celsius.times(1.80) + 32.00))
}
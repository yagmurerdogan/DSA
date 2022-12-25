fun gradingStudents(grades: Array<Int>): Array<Int> {
    return grades.map {
        when {
            it < 38 -> it
            it % 5 == 3 -> it + 2
            it % 5 == 4 -> it + 1
            else -> it
        }
    }.toTypedArray()
}

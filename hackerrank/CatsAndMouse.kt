fun catsAndMouse(x: Int, y: Int, z: Int): String {
    val catADistance = abs(x - z)
    val catBDistance = abs(y - z)
    return if (catADistance < catBDistance) {
        "Cat A"
    } else if (catBDistance < catADistance) {
        "Cat B"
    } else {
        "Mouse C"
    }
}
fun diffArea(a: Figure, b: Figure): Int {
    return a.area() - b.area()
}

open class Figure(val width: Int, val height: Int) {
    fun area(): Int {
        return width * height
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Figure

        if (width != other.width) return false
        if (height != other.height) return false

        return true
    }

    override fun hashCode(): Int {
        var result = width
        result = 31 * result + height
        return result
    }
}
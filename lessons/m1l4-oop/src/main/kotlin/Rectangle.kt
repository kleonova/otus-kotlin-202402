class Rectangle(width: Int, height: Int): Figure(width, height) {
    override fun toString(): String {
        return "Rectangle(${width}x${height})"
    }
}
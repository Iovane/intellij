fun main() {

    val a = Point()
    val b = Point()

    b.abcisa = 2f
    b.ordinata = 5f

    println(a)
    println(b)
    println(a == b)

    a.simetria()
    b.simetria()
}

class Point {
    var abcisa = 2f
    var ordinata = 3f

    override fun toString(): String {
        return ("x = $abcisa y = $ordinata")
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            if (abcisa == other.abcisa && ordinata == other.ordinata) {
                return true
            }
        }
        return false
    }

    fun simetria() {
        abcisa = - abcisa
        println("y ღერძის მიმართ სიმეტრიით გადავა ($abcisa, $ordinata)")
    }
}

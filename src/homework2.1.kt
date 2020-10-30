import kotlin.math.max
import kotlin.math.min
import kotlin.math.roundToLong

fun main() {

    var f1 = Fraction(3F, 6F)
    var f2 = Fraction(2F, 5F)

    println(f1 == f2)
    println(f1)
    println(f2)

    println("pirveli wiladi shekvecili ${f1.Shekveca()}")
    println("meore wiladi shekvecili ${f2.Shekveca()}")
    println("namravli ${f1.gamravleba(f2)}")
    println("jami shekvecili gamartivebuli mshvenivrad ${f1.mimateba(f2)}")
}

class Fraction(n: Float, d: Float) {

    private var numerator: Float = n
    private var denominator: Float = d

    override fun equals(other: Any?): Boolean {
        if (other is Fraction) {
            if (numerator * other.denominator / denominator == other.numerator) {
                return true
            }
        }
        return false
    }

    override fun toString(): String {
        return "$numerator/$denominator"
    }

    override fun hashCode(): Int {
        var result = numerator.hashCode()
        result = 31 * result + denominator.hashCode()
        return result
    }
    fun Shekveca(): Fraction {
        fun usg (): Float{
            var maxusg = 1
            for(i in numerator.toInt() downTo 0)
                if (numerator.toInt() % i == 0 && denominator.toInt() % i ==0){
                    maxusg = i
                    break
                }
        return maxusg.toFloat()
        }
        val numerator1 = numerator / usg()
        val denominator1 = denominator / usg()
        val f3 = Fraction(numerator1,denominator1)
        return f3
    }
   fun gamravleba(other: Fraction): Fraction{
       val x = numerator * other.numerator
       val y = denominator * other.denominator
       val f3 = Fraction(0f,1f)

       f3.numerator = x
       f3.denominator = y
       return f3
   }
    fun mimateba(other: Fraction): Fraction{
        if(denominator == other.denominator){
            numerator += other.numerator
            val f3 = Fraction(numerator,denominator)
            return f3
        } else{
            val x = numerator * other.denominator
            val y = other.numerator * denominator
            val z = denominator * other.denominator
            val n1 = x + y
            val f3 = Fraction(n1,z)
            return f3.Shekveca()
        }
    }
}

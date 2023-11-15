package extensions

fun main(){
    printTheResult(2.calc(3))
    "You can change this string to test your fortuna".displayTypeInfo()
    DataType.DoubleType(1.4).displayDataTypeInfo()
    DataType.UnitType().displayDataTypeInfo()
}

//second Task (there was not any info bout what lambda should do, so, I just printed)
val printTheResult={x:Int-> println(x) }

//first Task
fun Int.calc(x:Int):Int{
    return when {
        x < 0 -> throw IllegalArgumentException("The pow value must be positive")
        x == 0 -> 1
        x % 2 == 0 -> {
            val check = this.calc(x / 2)
            check * check
        }
        else -> this * this.calc(x - 1)
    }
}

//third Task
fun <T> T.displayTypeInfo(){
    when (this) {
        is String -> println("Это String")
        is Int -> println("Это Int")
        else -> println("Тип $this неизвестен")
    }
}

//forth Task
sealed class DataType{
    abstract val value:Double?

    fun displayDataTypeInfo() {
        when (this) {
            is DoubleType -> println("This is DoubleType with the value $value")
            is UnitType -> println("This is UnitType")
        }
    }

    data class DoubleType(override val value: Double) : DataType()
    data class UnitType(override val value: Double? = null) : DataType()
}


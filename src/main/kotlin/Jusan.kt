open class Jusan(val name: String) {
    open val x = 5
    open fun func1() {
        println("From func1: $name")
    }
}

class Singularity(val secondName: String) : Jusan(secondName), Sample {
    override fun func1() {
        println("From Singularity: $secondName")
    }
    override val x = 10
    val y = 4

    override fun boo() {
        print("I am boo")
    }
}

interface Sample {
    fun bar(): Int {
        val x = 2
        val y = 3
        return x + y
    }

    fun boo()
}

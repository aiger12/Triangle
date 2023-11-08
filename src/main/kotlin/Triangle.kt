data class Point(private val x:Double, private val y:Double){
    fun getX(): Double {
        return x
    }

    fun getY(): Double {
        return y
    }
}

class Triangle(val a:Point, val b:Point, val c:Point){
    init {
        if (areCollinear(a,b,c)) {
            throw IllegalArgumentException("The vertices cannot be collinear.")
        }
    }
    private fun areCollinear(a: Point, b: Point, c: Point): Boolean {
        // Check if the cross product of vectors AB and AC is close to zero
        return Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY()) - (c.getX() - a.getX()) * (b.getY() - a.getY())) < 1e-6
    }

    fun showInfo(){
        println("Your triangle vertexes are: " +
                "(${a.getX()}, ${a.getY()}), " +
                "(${b.getX()}, ${b.getY()}), " +
                "(${c.getX()}, ${c.getY()})"
        )
    }

    fun calcDistance(point1:Point, point2: Point):Double{
        val x=point1.getX()-point2.getX()
        val y=point1.getY()-point2.getY()
        return Math.sqrt(x*x+y*y)
    }

    fun calcPerimetr():Double{
        return calcDistance(a,b)+calcDistance(b,c)+calcDistance(a,c)
    }

    fun calArea():Double{
        val s= calcPerimetr()/2
        return Math.sqrt(s*(s-calcDistance(a,b))*(s-calcDistance(b,c))*(s-calcDistance(a,c)))
    }
}

fun main(){
    println("Please enter the vertex coordinates for each points.")
    print("Enter x for A: ")
    val x1 = readLine()!!.toDouble()
    print("Enter y for A: ")
    val y1 = readLine()!!.toDouble()

    print("Enter x for B: ")
    val x2 = readLine()!!.toDouble()
    print("Enter y for B: ")
    val y2 = readLine()!!.toDouble()

    print("Enter x for C: ")
    val x3 = readLine()!!.toDouble()
    print("Enter y for C: ")
    val y3 = readLine()!!.toDouble()

    val v1=Point(x1,y1)
    val v2=Point(x2,y2)
    val v3=Point(x3,y3)

    val triangle=Triangle(v1,v2,v3)
    val perimetr=triangle.calcPerimetr()
    val area= triangle.calArea()

    triangle.showInfo()
    println("Perimetr of triangle is: $perimetr")
    println("Area of triangle is: $area")
}
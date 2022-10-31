import kotlin.IntArray


fun main() {
  val myArray = intArrayOf(1,2,3,4)
  val emptyArray = intArrayOf()

  println(assertEquals( solution(myArray), 10))
  println(assertEquals(solution(emptyArray), 0))
}

/** auxiliar funtion only for test */
fun assertEquals( expectedResult: Int, result: Int): String{
  return if(expectedResult == result) {
    "Test Passed"
  } else { "Test Failure" }
} 

/** end auxiliar funtion */

fun solution( vector : IntArray) : Int {
  if( vector.size == 0) return 0

  var mid = (vector.size /2)
  var left = recursiveSum( vector, 0, mid, 0 )
  var right = recursiveSum( vector, mid.plus(1), vector.size-1, 0 )

  return left + right;
}

fun recursiveSum(vector : IntArray, begin: Int, end: Int, sum :Int): Int  {
    if( begin <= end ) {
      /** bussiness logic here*/
      var mySum = sum.plus(vector[begin]) 
      return recursiveSum(vector, begin+1, end, mySum)
    } 
    
    return sum
}
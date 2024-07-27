

class Solution {
     // math: 
    // sum: init: 0 until -> pivot-1
    // sum: init: pivot until-> n-1 
    fun sumOf(arrayToSum: IntArray, initial: Int, end: Int) : Int{
        var sum= 0
        for( step in initial .. end) {
            sum += arrayToSum[step]
        }

        return sum;
    }

    fun replacedByK(nums: IntArray, k: Int): List<IntArray> {
        // k: can be choosed to change with one element of the array
        // for sample: [1,2,3]
        // k= -1
        // [-1,2,3], [1,-1,3] [1,2,-1]
        var response = mutableListOf<IntArray>()
        response.add(nums.copyOf())
        for( (index, value) in nums.withIndex()) {
            val copyArray = nums.copyOf()
            copyArray[index] = k
            response.add(copyArray)
        }

        return response
    }
    
    
    fun waysToPartition(nums: IntArray, k: Int): Int {
        // n = size of the array = 3
        val n = nums.size
        // test the function
        // val testArray = intArrayOf(1,2,3,4)
        // val sum = sumOf(testArray, 0, 2-1 ) // should return 3
        // println("$sum should be 3 ")

        // pivots 
        // each pivot split the array in a index position
        // for pivot 1 and array is [1,2,3,4]
        // whe will split the array as [1] [2,3,4]
        // for pivot equals to 2
        // [1,2] [3,4]
        var response = 0
        var counter = -1
        var counterList = mutableListOf<Int>()

        for( array in replacedByK(nums, k)) {
           counter++
           for( pivot in array.indices) {
                if( pivot >= 0 && pivot < nums.size -1) {
                    
                    val copy = array.copyOf()
                    val firstPart = copy.sliceArray(0 .. pivot)
                    val secondPart = copy.sliceArray(pivot+1 .. copy.size-1)

                    val sumOne = sumOf(firstPart, 0, firstPart.size-1)
                    val sumTow = sumOf(secondPart, 0, secondPart.size-1)

                    if(sumOne == sumTow) {
                        // println("works to $counter")
                        // println("First part: ${firstPart.joinToString(", ")}")
                        // println("Second part: ${secondPart.joinToString(", ")}")
                        // println()
                        response++
                    }
                    
                }
               
            }
            counterList.add(response)
            response = 0
        }

        var counterOriginal = counterList[0]
        var maxKCounter = counterList[1]
        for( c in 2..counterList.size-1) {
            // println("${counterOriginal}, ${counterList[c]}")
            maxKCounter = maxOf(maxKCounter, counterList[c])
        }
       

        return maxOf(maxKCounter, counterOriginal)
    }
    // nums = [2,-1,2]
 
    // >> The number of ways to partition <<
   
    // if the sum are equals it is the solution   

    


}
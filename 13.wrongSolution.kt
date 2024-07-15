class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
      // space complexity is O(N+M)
      val setMergedArray = mutableSetOf<Double>()

      for( n in nums1) {
          setMergedArray.add(n.toDouble())  
      }

      for( n in nums2) {
          setMergedArray.add(n.toDouble())  
      }


      val sizeOfArray = setMergedArray.size 
      val mergedArray = DoubleArray(sizeOfArray) { 0.toDouble() } 
      var counter = 0;  

      for( element in setMergedArray) {
        mergedArray[counter] = element
        println("element ${mergedArray[counter]} added!!")
        counter++
      }

      if(sizeOfArray == 1 ) {
        return mergedArray[0]
      }

      if( sizeOfArray % 2 == 0) {
         val left: Double = mergedArray[(sizeOfArray/2 -1)]
         val right: Double = mergedArray[(sizeOfArray/2)]
         println("$left + $right = ${((left+right)/2.toDouble()).toDouble()}")
        return ((left+right)/2).toDouble()
       
      } else {
        return mergedArray[(sizeOfArray/2)+1].toDouble()
      }   

    }
}
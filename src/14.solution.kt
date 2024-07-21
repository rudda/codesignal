class Solution {
    

    fun twoSum(nums: IntArray, target: Int): IntArray {
       var targetHash = hashMapOf<Int, Int>()

       for( (i, element) in nums.withIndex()) {
            targetHash.put(element, i)
       }

       for( (i, element) in nums.withIndex()) {
            val diff =  target - element
            if(targetHash.contains(diff) && targetHash.get(diff)!= i) {
                return intArrayOf(i, targetHash.get(diff)!!)
            }
       }
        return IntArray(2){0}
    }
}
// https://www.youtube.com/watch?v=5WZl3MMT0Eg

class Solution {
    fun maxSubArray(nums: IntArray): Int {
        var maxSub = nums[0]
        var curSum = 0
        var i = 0
        var j = 0
        for( (index, value) in nums.withIndex()) {
            if(curSum < 0) {
                curSum = 0
                i = index
                j = index
            }
            curSum += value
            val prevMax = maxSub
            maxSub = maxOf(maxSub, curSum)
        }

     return maxSub   
    }

}
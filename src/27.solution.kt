class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        // // brutal force solution
        // for( (i, num) in nums.withIndex()) {
        //     for( j in (i+1) until nums.size) {
        //         if( nums[i] == nums[j]) {
        //             return true
        //         }
        //     }
        // }

        // optimized Solution
        var map = mutableSetOf<Int>()
        for( value in nums) {
            if( map.contains(value) ) {
                return true
            } else {
                map.add(value)
            }
        }

        return false
    }
}
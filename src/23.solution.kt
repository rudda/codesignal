//https://leetcode.com/problems/merge-sorted-array/?envType=company&envId=google&favoriteSlug=google-thirty-days

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var i = m - 1
    var j = n - 1
    var k = m + n - 1

    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i]
            i--
        } else {
            nums1[k] = nums2[j]
            j--
        }
        k--
    }

    while (j >= 0) {
        nums1[k] = nums2[j]
        j--
        k--
    }
}

    // n1: [1,2,3,0,0,0]
    // n2: [2,5,6]
    // condition n2 < n1
    // merged= 1, 2, 2, 3, 5, 6
    // mI = 0, 1, 2, 3, 4, 5
    // n2I= 0,1,2,3 
    // n1I= 0,1,2,3
    // break when n2I is the size of n2
}
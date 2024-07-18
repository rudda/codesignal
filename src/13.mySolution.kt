class Solution {

    
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // Atribui os arrays A e B, garantindo que A seja o menor
        val A = if (nums1.size <= nums2.size) nums1 else nums2
        val B = if (nums1.size <= nums2.size) nums2 else nums1

        val totalSize = A.size + B.size
        var ALeft = 0
        var ARight = A.size

        while (ALeft <= ARight) {
            val middleAIndex = (ALeft + ARight) / 2
            val middleBIndex = (totalSize + 1) / 2 - middleAIndex

            val aLeft = if (middleAIndex > 0) A[middleAIndex - 1] else Int.MIN_VALUE
            val aRight = if (middleAIndex < A.size) A[middleAIndex] else Int.MAX_VALUE
            val bLeft = if (middleBIndex > 0) B[middleBIndex - 1] else Int.MIN_VALUE
            val bRight = if (middleBIndex < B.size) B[middleBIndex] else Int.MAX_VALUE

            if (aLeft <= bRight && bLeft <= aRight) {
                return if (totalSize % 2 == 0) {
                    (maxOf(aLeft, bLeft) + minOf(aRight, bRight)) / 2.0
                } else {
                    maxOf(aLeft, bLeft).toDouble()
                }
            } else if (aLeft > bRight) {
                ARight = middleAIndex - 1
            } else {
                ALeft = middleAIndex + 1
            }
        }

        throw IllegalArgumentException("Input arrays are not sorted")
    }
}
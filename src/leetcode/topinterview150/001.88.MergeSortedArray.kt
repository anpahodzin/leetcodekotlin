package leetcode.topinterview150

import org.testng.annotations.Test
import kotlin.test.assertContentEquals

/*Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.*/

class TestMerge {
    @Test
    fun testMerge1() {
        val m = 3
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val n = 3
        val nums2 = intArrayOf(2, 5, 6)
        val expect = intArrayOf(1, 2, 2, 3, 5, 6)
        merge(nums1, m, nums2, n)
        assertContentEquals(expect, nums1)
    }

    @Test
    fun testMerge2() {
        val m = 3
        val nums1 = intArrayOf(4, 5, 6, 0, 0, 0)
        val n = 3
        val nums2 = intArrayOf(1, 2, 3)
        val expect = intArrayOf(1, 2, 3, 4, 5, 6)
        merge(nums1, m, nums2, n)
        assertContentEquals(expect, nums1)
    }

    @Test
    fun testMerge3() {
        val m = 5
        val nums1 = intArrayOf(1, 2, 4, 5, 6, 0)
        val n = 1
        val nums2 = intArrayOf(3)
        val expect = intArrayOf(1, 2, 3, 4, 5, 6)
        merge(nums1, m, nums2, n)
        assertContentEquals(expect, nums1)
    }

    @Test
    fun testMerge4() {
        val m = 6
        val nums1 = intArrayOf(-1, 0, 0, 3, 3, 3, 0, 0, 0)
        val n = 3
        val nums2 = intArrayOf(1, 2, 2)
        val expect = intArrayOf(-1, 0, 0, 1, 2, 2, 3, 3, 3)
        merge(nums1, m, nums2, n)
        assertContentEquals(expect, nums1)
    }

    @Test
    fun testMerge5() {
        val m = 0
        val nums1 = intArrayOf(0)
        val n = 1
        val nums2 = intArrayOf(1)
        val expect = intArrayOf(1)
        merge(nums1, m, nums2, n)
        assertContentEquals(expect, nums1)
    }
}

private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    if (n == 0) return
    var a = m - 1
    var b = n - 1

    for (i in (m + n - 1) downTo 0) {

        when {
            b < 0 || (a >= 0 && nums1[a] > nums2[b]) -> {
                nums1[i] = nums1[a]
                a -= 1
            }

            else -> {
                nums1[i] = nums2[b]
                b -= 1
            }
        }
    }
}

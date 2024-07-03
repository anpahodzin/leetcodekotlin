package leetcode.topinterview150

import org.testng.annotations.Test
import utils.print
import kotlin.test.assertContentEquals

/*Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).*/

class TestRemoveDuplicate {
    @Test
    fun case1() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
        val k = removeDuplicates(nums)
        val expect = intArrayOf(0, 1, 2, 3, 4)
        assertContentEquals(expect, nums.copyOf(k))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(1, 1, 2)
        val k = removeDuplicates(nums)
        val expect = intArrayOf(1, 2)
        assertContentEquals(expect, nums.copyOf(k))
    }

    @Test
    fun case3() {
        val nums = intArrayOf(1)
        val k = removeDuplicates(nums)
        val expect = intArrayOf(1)
        assertContentEquals(expect, nums.copyOf(k))
    }
}

fun removeDuplicates(nums: IntArray): Int {
    var duplicateIndex = 1
    var prevUniqueValue = nums.first()
    for (i in 0 until nums.size) {
        if (prevUniqueValue != nums[i]) {
            prevUniqueValue = nums[i]
            nums[duplicateIndex] = nums[i]
            duplicateIndex += 1
        }
//        println("dublicate = $duplicateIndex prev = $prevUniqueValue")
//        nums.print()
    }

    return duplicateIndex
}
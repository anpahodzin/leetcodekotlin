package leetcode.topinterview150

import org.testng.annotations.Test
import utils.print
import kotlin.test.assertContentEquals

/*Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).*/

class TestRemoveDuplicate2 {
    @Test
    fun case1() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)
        val k = removeDuplicates(nums)
        val expect = intArrayOf(1, 1, 2, 2, 3)
        assertContentEquals(expect, nums.copyOf(k))
    }

    @Test
    fun case2() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        val k = removeDuplicates(nums)
        val expect = intArrayOf(0, 0, 1, 1, 2, 3, 3)
        assertContentEquals(expect, nums.copyOf(k))
    }
}

fun removeDuplicates2(nums: IntArray): Int {
    var duplicateCount = 0
    var duplicateIndex = 1
    var prevUniqueValue = nums.first()
    for (i in 0 until nums.size) {
        if (prevUniqueValue != nums[i]) {
            prevUniqueValue = nums[i]
            nums[duplicateIndex] = nums[i]
            duplicateIndex += 1
        } else {

        }
//        println("dublicate = $duplicateIndex prev = $prevUniqueValue")
//        nums.print()
    }

    return duplicateIndex
}
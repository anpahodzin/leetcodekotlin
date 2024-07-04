package leetcode.topinterview150

import org.testng.annotations.Test
import kotlin.test.assertEquals

class TestRemove {
    @Test
    fun case1() {
        val nums = intArrayOf(3, 2, 2, 3)
        val value = 3
        val k = removeElement(nums, value)
        assertEquals(2, k)
    }
}

private fun removeElement(nums: IntArray, `val`: Int): Int {
    var index = 0
    val newNums = IntArray(nums.size)
    for (i in nums.indices) {
        if (nums[i] != `val`) {
            newNums[index] = nums[i]
            index += 1
        }
    }

    newNums.forEachIndexed { i, v ->
        nums[i] = v
    }
    return index +1
}
package leetcode.problemlist

import org.testng.annotations.Test
import utils.nanoBenchmark
import kotlin.test.assertContentEquals

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:

2 <= nums.length <= 10^4
-10^9 <= nums[i] <= 10^9
-10^9 <= target <= 10^9
Only one valid answer exists.

private fun twoSum(nums: IntArray, target: Int): IntArray {

}
*/

private fun twoSum(nums: IntArray, target: Int): IntArray {
    println("brureforce")
    nanoBenchmark {
        twoSum2(nums, target)
    }
    println("hashmap")
    nanoBenchmark {
        twoSum3(nums, target)
    }
    println("hashmap mot mine")
    nanoBenchmark {
        twoSumNotMine(nums, target)
    }
    println(" ")
    return twoSumNotMine(nums, target)
}

/*Describe test cases*/
class Test001Sum {
    @Test
    fun testSum1() {
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val expect = intArrayOf(0, 1)
        val result = twoSum(nums, target)
        assertContentEquals(expect, result)
    }

    @Test
    fun testSum2() {
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val expect = intArrayOf(1, 2)
        val result = twoSum(nums, target)
        assertContentEquals(expect, result)
    }

    @Test
    fun testSum3() {
        val nums = intArrayOf(3, 3)
        val target = 6
        val expect = intArrayOf(0, 1)
        val result = twoSum(nums, target)
        assertContentEquals(expect, result)
    }

    @Test
    fun testSum4() {
        val nums = intArrayOf(0, 7, 4, 3, 2)
        val target = 6
        val expect = intArrayOf(2, 4)
        val result = twoSum(nums, target)
        assertContentEquals(expect, result)
    }
}

/*
Need to find solution.
We have array with integers and target integer.
Need to find the indices of the numbers that will sum up to the target number
Example1:

nums = [2,7,11,15]
target = 9
nums[0] + nums[1] = 9
result = [0,1]

Example2:

Input: nums = [3,2,4], target = 6
Output: [1,2]

Example3:

Input: nums = [3,3], target = 6
Output: [0,1]

What have we learned from the examples?
1. Array of numbers in random order (example 2 nums [3,2,4])
2. The answer may be from numbers not located one after another in the array( Output example two: [1,2])

First, how can this be done using brute force?
We can try taking the first number and adding it to all the others from the array.
2 + 7 = 9
2 + 11 = 13
2 + 15 = 17

7 + 11 = 18
7 + 15 = 22

11 + 15 = 26

first 2 + 7 == 9

Perhaps we need to come up with more examples.

Input: nums = [0,7,4,3,2], target = 6
Output: [2,4]
0 + 7 != 6
0 + 4 != 6
0 + 3 != 6
0 + 2 != 6

7 + 4 != 6
7 + 3 != 6
7 + 2 != 6

4 + 3 != 6
4 + 2 == 6

If we have this constraint 'Only one valid answer exists' it means that it is enough to find the first suitable answer.

This algorithm with complexity O(n^2). It is not good.
But so far I haven't come up with anything better, let's write this code
*/

private fun twoSum2(nums: IntArray, target: Int): IntArray {
    for (i in 0..nums.lastIndex) {
        for (j in (i + 1)..nums.lastIndex) {
//            println("${nums[i]} + ${nums[j]} = ${nums[i] + nums[j]}")
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}

/*
It is work solution. How can we improve the result? Need to improve the complexity of the algorithm.
What if we use a hash map to quickly get the value?
*/

private fun twoSum3(nums: IntArray, target: Int): IntArray {
    // Create map
    val map = HashMap<Int, Int>()
    nums.forEachIndexed { index, i ->
        map[i] = index
    }
    // Find sum
    for (i in 0..nums.lastIndex) {
        val complement: Int = target - nums[i]
        if (map.containsKey(complement) && map[complement] != i) {
            return intArrayOf(i, map[complement] ?: 0)
        }
    }
    return intArrayOf()
}

/*
It is not my solution
 */
fun twoSumNotMine(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.mapIndexed { index, num ->
        if (target - num in map) return intArrayOf(map.getValue(target - num), index)
        map.put(num, index)
    }
    return IntArray(0)
}

/*
Test 1
brureforce
Benchmark: completed in 16.2629 ms
hashmap
Benchmark: completed in 0.0397 ms
hashmap mot mine
Benchmark: completed in 2.6161 ms
*/


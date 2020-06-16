package shuai.yu;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @author shuai.yu
 * @version 2020/06/06
 */
public class TwoSum_1
{
    /**
     * 暴力法
     */
    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 两遍哈希表
     */
    public int[] twoSum1(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++)
        {
            int j = target - nums[i];
            if (map.containsKey(j) && map.get(j) != i)
            {
                return new int[]{i, (int) map.get(j)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     */
    public int[] twoSum2(int[] nums, int target)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            int j = target - nums[i];
            if (map.containsKey(j) && map.get(j) != i)
            {
                return new int[]{i, (int) map.get(j)};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

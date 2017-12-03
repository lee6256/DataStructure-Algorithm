import java.util.HashMap;
import java.util.Map;

public class Test01 {
	/**
	 * 求一个数组中是否有两个数字相加能得到一个target。如果存在，则输出这两个数字的下标。
	 * 使用HashMap的键对值，判断target - nums[i]的结果是否在HashMap中，如果不在，把num[i]放进HashMap再进行下一次判断
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)*/
	public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	int n = target - nums[i];
        	if (map.containsKey(n)) {
        		return new int[] {map.get(n), i};
        	}
        	map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

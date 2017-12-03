import java.util.HashMap;
import java.util.Map;

public class Test01 {
	/**
	 * ��һ���������Ƿ���������������ܵõ�һ��target��������ڣ���������������ֵ��±ꡣ
	 * ʹ��HashMap�ļ���ֵ���ж�target - nums[i]�Ľ���Ƿ���HashMap�У�������ڣ���num[i]�Ž�HashMap�ٽ�����һ���ж�
	 * ʱ�临�Ӷȣ�O(n)
	 * �ռ临�Ӷȣ�O(n)*/
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

import java.util.HashSet;
import java.util.Set;

public class Test03 {
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int i = 0, j = 0, r = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				r = Math.max(r, j - i);
			}
			else {
				set.remove(i++);
			}
		}
		return r;
	}
}

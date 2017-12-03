import java.util.HashMap;

import util.Quick;
import util.Utils;

public class TestClass {
	public static void main(String[] args) {
		Integer[] arr = {5,2,4,6,8,1,3};
		Quick.sort(arr);
		Utils.showArray(arr);
	}
	static int hash(Object var0) {
		int var1;
        return var0 == null?0:(var1 = var0.hashCode()) ^ var1 >>> 16;
	}
}	

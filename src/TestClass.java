import java.util.HashMap;

import util.BST;
import util.Quick;
import util.Utils;

public class TestClass {
	public static void main(String[] args) {
		BST<Integer, String> bst = new BST<Integer, String>();
		bst.put(2, "B");
		bst.put(5, "E");
		bst.put(3, "C");
		bst.put(1, "A");
		bst.put(4, "D");
		bst.print();
	}
	static int hash(Object var0) {
		int var1;
        return var0 == null?0:(var1 = var0.hashCode()) ^ var1 >>> 16;
	}
}	

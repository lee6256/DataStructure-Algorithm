package util;

public class Quick {
	public static void sort(Comparable[] arr) {
		sort(arr, 0, arr.length-1);
	}
	private static void sort(Comparable[] arr, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(arr, lo, hi);
		sort(arr, lo, j-1);
		sort(arr, j+1, hi);
		
		//三向切分
//		int lt = lo, i = lo+1, gt = hi;
//		Comparable v = arr[lo];
//		while (i <= gt) {
//			int cmp = arr[i].compareTo(v);
//			if (cmp < 0) Utils.exch(arr, lt++, i++);
//			else if (cmp > 0) Utils.exch(arr, i, gt--);
//			else i++;
//		}
//		sort(arr, lo, lt-1);
//		sort(arr, gt+1, hi);
	}
	private static int partition(Comparable[] arr, int lo, int hi) {
		int i = lo, j = hi + 1;
		Comparable v = arr[lo];
		while (true) {
			while (Utils.less(arr[++i], v)) if (i == hi) break;  //从右端开始扫描，找出比v大的值，arr[i]<v，则返回true，直到返回false
			while (Utils.less(v, arr[--j])) if (j == lo) break;  //从左端开始扫描，找出比v小的值，arr[j]>v，则返回true，直到返回false
			if (j <= i) break;
			Utils.exch(arr, i, j);  //交换位置
		}
		Utils.showArray(arr);
		Utils.exch(arr, lo, j);  //把切分值交换到左分区与右分区的中间
		return j;
	}
}

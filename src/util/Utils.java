package util;

import java.util.Random;

public class Utils {
	//打印矩阵
	public static void showMatrix(int[][] m) {
		int row = m.length;
		int col = m[0].length;
		for (int i = 0;i < row;i++) {
			for (int j = 0;j < col;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
	}
	//打印数组
	public static void showArray(Comparable[] arr) {
		for (int i = 0;i < arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	//数组内值交换
	public static void exch(Comparable[] arr, int i, int j) {
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	//比较大小
	public static boolean less(Comparable a, Comparable b) {
		return a.compareTo(b) < 0;
	}
	//计算hash值
	public static int hash(Object var0) {
		int var1;
        return var0 == null?0:(var1 = var0.hashCode()) ^ var1 >>> 16;
	}
}

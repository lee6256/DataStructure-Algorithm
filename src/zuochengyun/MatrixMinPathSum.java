package zuochengyun;

import util.Utils;

public class MatrixMinPathSum {
	/**
	 * 矩阵最小路径和（从左上角到右下角），矩阵m[M][N]
	 * 矩阵dp[M][N]记录从左上角(0,0)位置走到(i,j)位置的最小路径和
	 * 先求dp[0][j](j<N)的值，即左上角(0,0)到(0,j)位置的最小路径和
	 * 再求dp[i][0](i<M)的值，即即左上角(0,0)到(i,0)位置的最小路径和
	 * 从左上角到右下角必定经过(i-1,j)或(i,j-1)，所以dp[i][j]=min{dp[i-1][j],dp[i][j-1]}+m[i][j]
	 *  1  3  5  9
	 *  8  1  3  4
	 *  5  0  6  1
	 *  8  8  4  0
	 *  ---dp数组---
	 *  1  4  9 18
	 *  9  5  8 12
	 * 14  5 11 12
	 * 22 13 15 12 */ 
	//此方法没有经过空间压缩
	public static int minPathSum1(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
			return -1;
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];  //初始化左上角
		for (int j = 1;j < col;j++) {  //求dp[0][j](j<N)的值
			dp[0][j] = dp[0][j-1] + m[0][j];
		}
		for (int i = 1;i < row;i++) {  //求dp[i][0](i<M)的值
			dp[i][0] = dp[i-1][0] + m[i][0];
		}
		for (int i = 1;i < row;i++) {
			for (int j = 1;j < col;j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+m[i][j];
			}
		}
//		Utils.showMatrix(dp);
		return dp[row-1][col-1];
	}
	
	/**
	 * 空间压缩法
	 * 通过一个数组arr[min{M,N}]翻滚更新所走的最小路径和
	 * */
	//此方法使用空间压缩
	public static int minPathSum2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
			return -1;
		int more = Math.max(m.length, m[0].length);
		int less = Math.min(m.length, m[0].length);
		boolean rowmore = more == m.length;  //行是否大于列
		int[] arr = new int[less];
		arr[0] = m[0][0];
		for (int i = 1;i < less;i++) {
			arr[i] = arr[i-1] + (rowmore ? m[0][i] : m[i][0]);
		}
		for (int i = 1;i < more;i++) {
			arr[0] = arr[0] + (rowmore ? m[i][0] : m[0][i]);
			for (int j = 1;j < less;j++) {
				arr[j] = Math.min(arr[j], arr[j-1]) + (rowmore ? m[i][j] : m[j][i]);
			}
		}
//		Utils.showArray(arr);
		return arr[less-1];
	}
}

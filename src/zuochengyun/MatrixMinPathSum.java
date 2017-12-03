package zuochengyun;

import util.Utils;

public class MatrixMinPathSum {
	/**
	 * ������С·���ͣ������Ͻǵ����½ǣ�������m[M][N]
	 * ����dp[M][N]��¼�����Ͻ�(0,0)λ���ߵ�(i,j)λ�õ���С·����
	 * ����dp[0][j](j<N)��ֵ�������Ͻ�(0,0)��(0,j)λ�õ���С·����
	 * ����dp[i][0](i<M)��ֵ���������Ͻ�(0,0)��(i,0)λ�õ���С·����
	 * �����Ͻǵ����½Ǳض�����(i-1,j)��(i,j-1)������dp[i][j]=min{dp[i-1][j],dp[i][j-1]}+m[i][j]
	 *  1  3  5  9
	 *  8  1  3  4
	 *  5  0  6  1
	 *  8  8  4  0
	 *  ---dp����---
	 *  1  4  9 18
	 *  9  5  8 12
	 * 14  5 11 12
	 * 22 13 15 12 */ 
	//�˷���û�о����ռ�ѹ��
	public static int minPathSum1(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
			return -1;
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];  //��ʼ�����Ͻ�
		for (int j = 1;j < col;j++) {  //��dp[0][j](j<N)��ֵ
			dp[0][j] = dp[0][j-1] + m[0][j];
		}
		for (int i = 1;i < row;i++) {  //��dp[i][0](i<M)��ֵ
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
	 * �ռ�ѹ����
	 * ͨ��һ������arr[min{M,N}]�����������ߵ���С·����
	 * */
	//�˷���ʹ�ÿռ�ѹ��
	public static int minPathSum2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0)
			return -1;
		int more = Math.max(m.length, m[0].length);
		int less = Math.min(m.length, m[0].length);
		boolean rowmore = more == m.length;  //���Ƿ������
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

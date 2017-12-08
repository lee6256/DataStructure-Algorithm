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
		
		//�����з֣��������н϶���ظ�Ԫ��ʱ��ά��ָ��lt��gt��i��i��������˿�ʼ����һ�Σ�ʹa[0~lt]<a[lt+1~i]<a[gt~length-1],����a[i~gt-1]δȷ���������У�ֱ��i>gt��
		//��������ᱻ�зֳ��м��Ԫ��Ϊ�з�ֵ�����С���з�ֵ���ұߴ����з�ֵ�����´εݹ��ʱ����ߵݹ�a[0~lt]���ұߵݹ�a[gt~length]
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
			while (Utils.less(arr[++i], v)) if (i == hi) break;  //���Ҷ˿�ʼɨ�裬�ҳ���v���ֵ��arr[i]<v���򷵻�true��ֱ������false
			while (Utils.less(v, arr[--j])) if (j == lo) break;  //����˿�ʼɨ�裬�ҳ���vС��ֵ��arr[j]>v���򷵻�true��ֱ������false
			if (j <= i) break;
			Utils.exch(arr, i, j);  //����λ��
		}
		Utils.showArray(arr);
		Utils.exch(arr, lo, j);  //���з�ֵ��������������ҷ������м�
		return j;
	}
}

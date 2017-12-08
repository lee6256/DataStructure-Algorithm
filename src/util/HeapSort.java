package util;

@SuppressWarnings("unchecked")
public class HeapSort {
	
	//����
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] arr) {
		int length = arr.length;
		for (int i = length/2-1; i >=0; i--)  //����Ϊ����
			adjustHeap(arr, i, length);
		for (int i = length-1; i >=0; i--) {
			Utils.exch(arr, 0, i);
			adjustHeap(arr, 0, i-1);
		}
	}
	
	//�����ѣ�Ҫ������������������Ƕѣ����������Ǵ������ϣ����������Ǵ��ϵ���
	@SuppressWarnings("rawtypes")
	private static void adjustHeap(Comparable[] arr, int i, int length) {
		if (i < length/2) {
			int lChild = i*2+1;
			int rChild = i*2+2;
			int max = i;
			if (lChild < length && arr[max].compareTo(arr[lChild]) < 0)
				max = lChild;
			if (rChild < length && arr[max].compareTo(arr[rChild]) < 0)
				max = rChild;
			if (max!=i) {
				Utils.exch(arr, i, max);
				adjustHeap(arr, max, length);
			}
		}
	}
	
	private static void swap(Comparable a, Comparable b) {
		Comparable t = a;
		a = b;
		b = t;
	}
}


public class Main {
	public static void main(String[] args) {
		Test04 test04 = new Test04();
		int[] A = new int[]{1,2,4,5,6,8,12,34,45,55,57,78};
		int[] B = new int[]{4,5,6,7,8,9,14,15,16,18};
		int m = A.length;
		int n = B.length;
		double mid = test04.findMedianSortedArrays(A, B);
		System.out.println(mid);
	}
}

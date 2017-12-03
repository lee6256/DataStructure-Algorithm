
public class Test04 {
	/**
	 * ���������ź������򣩵��������λ����ʱ�临�Ӷ�Ҫ��ΪO(log(m+n))
	 * ���磺[1,3]��[2]����λ��Ϊ2.0��[1,2]��[3,4]����λ��Ϊ��2+3��/2=2.5
	 * ������ת��Ϊ���KСֵ*/
	double findMedianSortedArrays(int[] nums1, int[] nums2) {  
		int m = nums1.length;
		int n = nums2.length;
		if ((m+n)%2==1)
			return findKth(nums1, 0, m, nums2, 0, n, (m+n)/2+1);
		else {
			int left = findKth(nums1, 0, m, nums2, 0, n, (m+n)/2);
			int right = findKth(nums1, 0, m, nums2, 0, n, (m+n)/2+1);
			return (left + right) / 2.0;
		}
    }
	int findKth(int[] a, int i, int m, int[] b, int j, int n, int k) {
		if (m - i > n - j) {
            return findKth(b, j, n, a, i, m, k);
        }
		if (m==i) {
			return b[j+k-1];
		}
		if (k == 1) {
            return Math.min(a[i], b[j]);
        }
		int pa = Math.min(k/2, m - i);
		int pb = k - pa;
		if (a[i+pa-1] == b[j+pb-1]) {
			return a[i+pa-1];
		}
		else if (a[i+pa-1] < b[j+pb-1]) {
			return findKth(a, i+pa, m, b, j, n, k/2);
		}
		else {
			return findKth(a, i, m, b, j+pb, n, k/2);
		}
	}
}

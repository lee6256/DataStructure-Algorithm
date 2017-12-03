
public class Test05 {
	/**
	 * ����һ���ַ�������Ļ����Ӵ�*/
	
	char[] changeString(String str) {
		int len = str.length();
		char[] s = str.toCharArray();
		char[] T = new char[len*2+3];
		for (int i=1; i<len*2; i+=2) {
			T[i] = '#';
			T[i+1] = s[i/2];
		}
		T[0] = '$';
		T[len*2+1] = '#';
		T[len*2+2] = '&';
		return T;
	}
	/**
	 * Manacher�㷨
	 * ʱ�临�Ӷȣ�O(n)
	 * ��ԭ�ַ����Ļ����ϣ�ÿ���ַ�֮�����һ����������ͬ���ַ�*/
	int MANACHER(char[] T, int len) {
		int p=0, po=0, ans = 0;
		int[] Len = new int[T.length];
		for (int i=1; i<=len; i++) {
			if (i < p)
				Len[i] = Math.min(p-i, Len[2*po-i]);
			else
				Len[i]=1;
//			System.out.println(Len[i-Len[i]]);
			while (T[i-Len[i]] == T[i+Len[i]])
				Len[i]++;
			
			if (i+Len[i]>p) {
				po = i;
				p = i+Len[i];
			}
			ans = Math.max(ans, Len[i]);
		}
		return ans-1;
	}
	public static void main(String[] args) throws InterruptedException {
		Test05 t = new Test05();
		String str = "231134";
		char[] temp = t.changeString(str);
		for (int i=0; i<temp.length; i++)
			System.out.print(temp[i]);
//		t.wait(100l);
		System.out.println();
		System.out.println(t.MANACHER(temp, str.length()*2+1));
	}
}


public class Test02 {
	/**
	 * ��������������������Ӧ�������涨����ʽ�ϲ����磺LinkAΪ  1 -> 4 -> 6�� LinkB 2 -> 7 -> 3���涨�����������Ӧ
	 * λ���ϵ�������ӣ�1+2�� 4+7��6+3���������������Ӵ���10��������1�������Ϊ��3 -> 1 -> 0 -> 1
	 * ��Ҫ���������б�ĳ����Ƿ����*/
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode p = l1, q = l2, curr = result;
        int carry = 0;
        int sum = 0;
        while (p != null || q != null) {
        	int a = (p != null)? p.val : 0;
        	int b = (q != null)? q.val : 0;
        	sum = carry + a + b;
        	carry = sum / 10;
        	curr.next = new ListNode((sum % 10));
        	curr = curr.next;
        	if (p!=null) p = p.next;
        	if (q!=null) q = q.next;
        }
        if (carry > 0)
        	curr.next = new ListNode(carry);
        return result.next;
    }
}

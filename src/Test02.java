
public class Test02 {
	/**
	 * 给定两个链表，把两个对应的链表按规定的形式合并。如：LinkA为  1 -> 4 -> 6， LinkB 2 -> 7 -> 3，规定把两个链表对应
	 * 位置上的数字相加，1+2， 4+7，6+3，如果两个数字相加大于10，则向后进1。最后结果为：3 -> 1 -> 0 -> 1
	 * 需要考虑两个列表的长度是否相等*/
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

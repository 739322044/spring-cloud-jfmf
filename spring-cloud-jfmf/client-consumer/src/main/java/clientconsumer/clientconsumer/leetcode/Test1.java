package clientconsumer.clientconsumer.leetcode;

/**
 * @author zhbr
 * @title: Test1
 * @projectName spring-cloud-jfmf
 * @description: TODO
 * @date 2021/3/99:32
 */
public class Test1 {

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(5);
        ListNode l11 = new ListNode(4,l1);
        ListNode l111 = new ListNode(3,l11);


        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(4,l2);
        ListNode l222 = new ListNode(3,l22);
        addTwoNumbers(l111,l222);*/
        int[] nums = new int[]{3,2,3};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(ints);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null,tail =null;
        int carry = 0;
        while(l1!=null || l2!=null){
            int n1 = l1 == null?0:l1.val;
            int n2 = l2 == null?0:l2.val;
            int sum = n1 + n2 + carry;
            if (head==null){
                head = tail = new ListNode(sum%10);
            }else {
                tail.next = new ListNode(sum%10);
                tail = tail.next;
            }
            carry = sum/10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry>0){
            tail.next = new ListNode(1);
        }
        while (head!=null){
            System.out.print(head.val);
            head = head.next;
        }
        return head;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(target==nums[i]+nums[j]){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }

            }

        }
        return result;

    }
}
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


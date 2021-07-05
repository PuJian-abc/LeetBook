package reversePrint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> res = new ArrayList<>();
        if (head != null) {
            do {
                res.add(head.val);
            } while ((head = head.next) != null);
        }
        List<Integer> res2 = new ArrayList<>();
        if (res.size() > 0) {
            for (int i = res.size() - 1; i >= 0; i--) {
                res2.add(res.get(i));
            }
        }
        return res2.stream().mapToInt(Integer::intValue).toArray();
    }

    ArrayList<Integer> tmp = new ArrayList<>();

    public int[] reversePrint2(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = tmp.get(i);
        return res;
    }

    public void recur(ListNode head) {
        if (head == null) return;
        recur(head.next);
        tmp.add(head.val);
    }

    public int[] reversePrint3(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

    public int[] reversePrint4(ListNode head) {
        // 计数就完事=-=
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        int[] arr = new int[count];

        cur = head;
        count--;
        while (cur != null && count >= 0) {
            arr[count--] = cur.val;
            cur = cur.next;
        }
        return arr;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        listNode.next = listNode2;
        listNode2.next = listNode3;
        System.out.println(Arrays.toString(solution.reversePrint(listNode)));
        System.out.println(Arrays.toString(solution.reversePrint2(listNode)));
        System.out.println(Arrays.toString(solution.reversePrint3(listNode)));
        System.out.println(Arrays.toString(solution.reversePrint4(listNode)));
    }
}

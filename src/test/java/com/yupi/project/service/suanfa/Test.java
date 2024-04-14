package com.yupi.project.service.suanfa;

/**
 * @author 黄昊
 * @version 1.0
 **/
public class Test {
    public static void main(String[] args) {
        int []arr={1,2,2,1};
        ListNode listNode=createLinkedList(arr);
        if (isPalindrome(listNode)){
            System.out.println("是回文");
        }
        else {
            System.out.println("不是回文");
        }
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode p1=head;
        ListNode head1=reserveN(p1);
        while(head!=null&&head1!=null&&head.val==head1.val){
            head=head.next;
            head1=head1.next;
        }
        return head==head1;
    }
    public static ListNode reserveN(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode last=reserveN(head.next);
        head.next.next=head;
        head.next=null;
        return last;
    }
    private static ListNode createLinkedList(int[] arr) {// 将输入的数组输入到链表中
        if (arr.length == 0) {
            return null;
        }
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {// 过程
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

}

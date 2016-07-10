/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode res = head;
        while(head != null) {
            RandomListNode node = new RandomListNode(head.label);
            map.put(head, node);
        }
        head = res;
        while(head != null) {
            RandomListNode node = map.get(head);
            if(head.random != null) node.random = map.get(head.random);
            if(head.next != null) node.next = map.get(head.next);
        }
        return res;
    }
}
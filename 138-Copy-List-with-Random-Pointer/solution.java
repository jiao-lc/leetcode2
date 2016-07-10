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
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        map.put(head, new RandomListNode(head.label));
        map.put(null, null);
        while (node != null) {
            if (!map.containsKey(node.next)) {
                map.put(node.next, new RandomListNode(node.next.label));
            } 
            map.get(node).next = map.get(node.next);
            
            if (!map.containsKey(node.random)) {
                map.put(node.random, new RandomListNode(node.random.label));
            } 
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        Segment seg = new Segment();
        for (int[] input: buildings)
            seg.add(input[0], input[1], input[2]);
            
        ArrayList<int[]> list = new ArrayList<int[]>();
        Node node = seg.root;
        int lastHeight = -1;
        while (node != null) {
            int[] arr = new int[2];
            arr[0] = node.start;
            arr[1] = node.height;
            if ((arr[0] != 0 || arr[1] != 0) && arr[1]!=lastHeight)
                list.add(arr);
            lastHeight = arr[1];
            node = node.next;
        }
        return list;
    }
}

class Node {
    int start;
    int height;
    Node next;
    public Node(int s, int h) {
        this.start = s;
        this.height = h;
    }
}

class Segment {
    public Node root = null;
    Node last = null;
    public Segment() {
        root = new Node(0, 0);
        last = root;
    }
    
    public void add(int begin, int end, int h) {
        Node node = last;
        while (node.start < begin && node.next != null && node.next.start <= begin) {
            node = node.next;
        }
        
        last = node;
        int lastHeight = node.height;
        if (node.start == begin) {
            node.height = Math.max(node.height, h);
        } else {
            if (node.height < h) {
                Node tem = node.next;
                node.next = new Node(begin, h);
                node.next.next = tem;
                last = node.next;
            }
        }
        
        node = last;
        while (node.next != null && node.next.start < end) {
            lastHeight = node.next.height;
            if (node.height == node.next.height) {
                node.next = node.next.next;
            } else {
                if (node.next.height < h)
                    node.next.height = h;
                node = node.next;
            }
        }
        if ((node.next == null || node.next.start > end) && lastHeight < h) {
            Node tem = node.next;
            node.next = new Node(end, lastHeight);
            node.next.next = tem;
        }
    }
}
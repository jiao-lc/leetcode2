class MedianFinder {

    PriorityQueue<Integer> leftQ;
    PriorityQueue<Integer> rightQ;
    Double median = null;

    public MedianFinder(){
        leftQ = new PriorityQueue<>(Comparator.reverseOrder());
        rightQ = new PriorityQueue<>();
    }

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(median == null){
            leftQ.offer(num);
            median = num*1.0;
        } else if(num > median){
            rightQ.offer(num);
            median = findMedian(rightQ, leftQ);
            
        } else {
            leftQ.offer(num);
            median = findMedian(leftQ, rightQ);
        }
            
    }
    
    private double findMedian(PriorityQueue<Integer> leftQ, PriorityQueue<Integer> rightQ){
        double result = 0;
        if(leftQ.size() - rightQ.size() == 2)
            rightQ.offer(leftQ.poll());
            
        if(leftQ.size() - rightQ.size() == 1)
            result = leftQ.peek()*1.0;
        else
            result = (leftQ.peek() + rightQ.peek())*1.0 / 2;
        return result;
    }

    // Returns the median of current data stream
    public double findMedian() {
        return median;
    }
};

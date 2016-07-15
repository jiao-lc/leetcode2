public class MedianFinder {
    List<Integer> arr = new ArrayList<Integer>();
    MedianFinder() {
        arr = new ArrayList<Integer>();
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        int i = 0;
        for(; i < arr.size(); i++) {
            if(arr.get(i) > num) break;
        }
        if(i == arr.size()) arr.add(num);
        else {
            arr.add(i, num);
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        int size = arr.size();
        int mid = mid = size / 2;;
        double res = 0;
        if((size&1) == 1) {
            res = (double)arr.get(mid);
        }
        else {
            res += (double)arr.get(mid++);
            res += (double)arr.get(mid);
        }
        return res;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();
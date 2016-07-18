public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> res = new ArrayList<String>();
        if(tickets == null || tickets.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for(String[] ticket : tickets) {
            if(!map.containsKey(ticket[0])) {
                map.put(ticket[0], new ArrayList<String>());
            }
            List<String> tmp = map.get(ticket[0]);
            tmp.add(ticket[1]);
            map.put(ticket[0], tmp);
        }
        for(String key : map.keySet()) {
            List<String> tmp = map.get(key);
            Collections.sort(tmp);
            map.put(key, tmp);
        }
        String start = "JFK", end = "JFK";
        res.add(start);
        while(end != null) {
            List<String> tmp = map.get(start);
            if(tmp == null) break;
            end = tmp.get(0);
            tmp.remove(0);
            map.put(start, tmp);
            res.add(end);
            start = end;
        }
        return res;
    }
}
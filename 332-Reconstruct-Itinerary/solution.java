public class Solution {
    public List<String> findItinerary(String[][] tickets) {
            LinkedList<String> result = new LinkedList<>();
            HashMap<String,PriorityQueue<String>> graph = new HashMap<>();
            for(String[] edge : tickets){
                if(!graph.containsKey(edge[0]))
                    graph.put(edge[0],new PriorityQueue<>());
                graph.get(edge[0]).offer(edge[1]);
            }
            DFS("JFK",graph,result); // we need to do DFS/topological sort only from "JFK"
            return result;
        }
        /*DFS doing topological sort*/
        private void DFS(String node,HashMap<String,PriorityQueue<String>> graph,LinkedList<String> result ){
            PriorityQueue<String> nodes = graph.get(node);
            while(nodes!= null && !nodes.isEmpty())
                DFS(nodes.poll(),graph,result);
            result.addFirst(node); // this is the key, instead of reversing add to the head of linkelist.
        }
}
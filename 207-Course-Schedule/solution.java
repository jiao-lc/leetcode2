public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        boolean[] visited = new boolean[numCourses];
        for(int i=0; i<prerequisites.length;i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i=0; i<numCourses; i++){
            if(!dfs(graph,visited,i))
                return false;
        }
        return true;
    }
    
    public boolean dfs(ArrayList[] graph, boolean[] visited, int num) {
        if(visited[num]) return false;
        visited[num] = true;
        for(int i = 0; i < graph[num].size(); i++) {
            if(!dfs(graph,visited,(int)graph[num].get(i)))
                return false;
        }
        visited[num] = false;
        return true;
    }
}
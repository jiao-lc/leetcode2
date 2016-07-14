public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count = numCourses - 1;
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
        for(int[] prerequisit : prerequisites) {
            degree[prerequisit[1]]++;
            graph[prerequisit[0]].add(prerequisit[1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
            }
        }
        while(queue.size() != 0){
            int course = (int)queue.poll();
            res[count--] = course;
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                }
            }
        }
        return count == -1 ? res : new int[0];
    }
}
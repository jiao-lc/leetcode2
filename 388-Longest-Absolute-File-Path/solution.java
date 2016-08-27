public class Solution {
    public int lengthLongestPath(String input) {
		input = input + "\n";
        HashMap<Integer, String> map = new HashMap<>();
        int level = 0, max = 0, indx = 0, start = 0;
        boolean isFile = false;
        String tmp;
        while(indx < input.length()) {
            if(input.charAt(indx) == '\n') {
            	tmp = input.substring(start, indx);
            	map.put(level, tmp);
            	if(isFile) {
            		StringBuilder sb = new StringBuilder();
            		for(int i = 0; i < level; i++) {
            			sb.append(map.get(i));
            			sb.append('/');
            		}
            		sb.append(tmp);
            		max = Math.max(max, sb.length());
            		System.out.println(sb.toString());
            		System.out.println();
            	}
                level = 0;
                isFile = false;
                start = indx + 1;
            } else if(input.charAt(indx) == '\t') {
                level++;
                start = indx + 1;
            } else if(input.charAt(indx) == '.') {
            	isFile = true;
            } 
            indx++;
        }
        return max;
    }
}
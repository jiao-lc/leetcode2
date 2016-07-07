public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0 || maxWidth == 0) {res.add(""); return res;}
        int cnt = 0, len = 0, i = 0, start = 0;
        int[] length = new int[words.length];
        for(String word : words) {
            length[i] = word.length();
            i++;
        }
        i = 0;
        while(i < words.length) {
            len += length[i];
            cnt++;
            if(len + cnt - 1 > maxWidth) {
                len -= length[i];
                cnt--;
                StringBuilder sb = new StringBuilder();
                sb.append(words[start]);
                int j = 1;
                int d = 0,s = 0;
                if(cnt > 1){
                	d = (maxWidth - len) % (cnt - 1);
                	s = (maxWidth - len) / (cnt - 1);
                }
                while(j < cnt){
                    if(d != 0) {
                        sb.append(' ');
                        d--;
                    }
                    for(int k = 0; k < s; k++)
                        sb.append(' ');
                    sb.append(words[start + j]);
                    j++;
                }
                len = 0; cnt = 0; start = i; i--;
                while(sb.length() < maxWidth) {
                	sb.append(' ');
                }
                res.add(sb.toString());
            }
            else if(i == words.length - 1) {
            	StringBuilder sb = new StringBuilder();
                sb.append(words[start]);
                int j = 1;
                while(j < cnt){
                    sb.append(' ');
                    sb.append(words[start + j]);
                    j++;
                }
                while(sb.length() < maxWidth) {
                	sb.append(' ');
                }
                res.add(sb.toString());
            }
            i++;
        }
        
        return res;
    }
}
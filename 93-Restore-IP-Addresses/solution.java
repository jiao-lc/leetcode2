public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res  = new ArrayList();
        if(s == null || s.length() == 0|| s.length()<4|| s.length()>12){
            return res;
        }
    
        helper(res,s,new StringBuilder(), 0, 4);
        return res;
    }

    private void helper(List<String> res, String s ,StringBuilder sb, int pos, int left){
        if(pos == s.length() || left == 0){
            if(pos == s.length() && left == 0){
                res.add(sb.toString());
            }
            return;
        }
        if(left != 4){
            sb.append(".");
        }
    
        int len = sb.length();
        for(int i = pos + 1 ; i <= Math.min(pos+3,s.length());i++){
            if(i != pos+1 && s.charAt(pos) =='0'){
                break;
            } 
            int num = Integer.parseInt(s.substring(pos,i));
            if(num>=0 && num<=255){
                sb.append(num);
                helper(res,s,sb,i,left-1);
                sb.setLength(len);
            }
        }
    }
}
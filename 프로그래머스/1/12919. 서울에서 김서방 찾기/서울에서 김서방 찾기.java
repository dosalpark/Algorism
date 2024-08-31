class Solution {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ");
        
        int index;
        for(index = 0; index < seoul.length; index++){
            if("Kim".equals(seoul[index])){
                sb.append(index);
                break;
            }
        }
        sb.append("에 있다");
        
        return sb.toString();
    }
}
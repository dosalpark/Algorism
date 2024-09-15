class Solution {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                index = 0;
                sb.append(" ");
                continue;
            }
            if (index % 2 == 0) {
                sb.append(String.valueOf(s.charAt(i)).toUpperCase());
            } else if (index % 2 == 1) {
                sb.append(String.valueOf(s.charAt(i)).toLowerCase());
            }
            index++;
        }


        return sb.toString();
    }
}

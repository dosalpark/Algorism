class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strings = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String string : strings) {
            int cur = Integer.parseInt(string);
            min = Math.min(min,cur);
            max = Math.max(max,cur);
        }
        return min + " " + max;
    }
}

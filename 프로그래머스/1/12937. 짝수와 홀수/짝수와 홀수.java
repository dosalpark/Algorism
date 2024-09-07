class Solution {
    public String solution(int num) {
        num = Math.abs(num);
        return num % 2 == 1 ? "Odd" : "Even";
    }
}
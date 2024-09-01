class Solution {
    public int solution(int n) {

        String three = Integer.toString(n, 3);
        String threeReverse = new StringBuilder(three).reverse().toString();
        int answer = Integer.parseInt(threeReverse,3);

        return answer;
    }
}

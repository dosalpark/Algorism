class Solution {

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            String arrOr = Integer.toBinaryString(arr1[i] | arr2[i]);
            answer[i] = converter(arrOr, n);
        }
        return answer;
    }

    private String converter(String arrOr, int n) {
        arrOr = " ".repeat(n - arrOr.length()) + arrOr;
        return arrOr.replaceAll("1", "#").replaceAll("0", " ");
    }
}

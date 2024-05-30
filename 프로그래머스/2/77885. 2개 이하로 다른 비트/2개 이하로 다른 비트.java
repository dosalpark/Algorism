class Solution {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                String bin = Long.toBinaryString(numbers[i]);
                int lastZero = bin.lastIndexOf('0');
                String ans = "";
                if (lastZero == -1) {
                    ans = "10" + bin.substring(1);
                } else {
                    ans = bin.substring(0, lastZero) + "10" + bin.substring(lastZero + 2);
                }
                answer[i] = Long.parseLong(ans, 2);

            }
        }

        return answer;
    }
}

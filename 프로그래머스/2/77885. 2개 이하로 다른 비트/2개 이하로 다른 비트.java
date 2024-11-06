class Solution {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binaryNum = "0" + Long.toBinaryString(numbers[i]);
            if (binaryNum.charAt(binaryNum.length() - 1) == '0') {
                answer[i] = numbers[i] + 1;
            } else {
                int now = binaryNum.length() - 2;
                for (; now >= 0; now--) {
                    if (binaryNum.charAt(now) == '0') {
                        break;
                    }
                }
                StringBuilder sb = new StringBuilder(binaryNum.substring(0, now));
                for (int j = 0; j < binaryNum.length() - now; j++) {
                    if(j == 1){
                        sb.append(0);
                    } else {
                        sb.append(1);
                    }
                }
                answer[i] = Long.parseLong(sb.toString(),2);
            }
        }
        return answer;
    }
}

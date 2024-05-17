class Solution {

    public int solution(String dartResult) {
        int[] shoot = new int[3];
        int oneShoot = 0;
        int shootCount = 0;

        for (int i = 0; i < dartResult.length(); i++) {
            //점수 저장
            if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {
                oneShoot = oneShoot * 10 + dartResult.charAt(i) - '0';
            }

            if (dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D'
                || dartResult.charAt(i) == 'T') {
                if (dartResult.charAt(i) == 'D') {
                    oneShoot = oneShoot * oneShoot;
                } else if (dartResult.charAt(i) == 'T') {
                    oneShoot = oneShoot * oneShoot * oneShoot;
                }
                shoot[shootCount] = oneShoot;
                oneShoot = 0;
                shootCount++;
            }

            if (dartResult.charAt(i) == '*') {
                if (shootCount > 1) {
                    shoot[shootCount - 2] *= 2;
                }
                shoot[shootCount - 1] *= 2;
            } else if (dartResult.charAt(i) == '#') {
                shoot[shootCount - 1] *= -1;
            }

        }

        return shoot[0] + shoot[1] + shoot[2];
    }
}

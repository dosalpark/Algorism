import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<Integer> numberSet = new HashSet<>();
    int max = 0;

    public int solution(String numbers) {
        int answer = 0;
        recursive(numbers, "");
        boolean[] isPrimes = eratosthenes();

        for (Integer integer : numberSet) {
            if(!isPrimes[integer]){
                answer++;
            }
        }


        return answer;
    }

    private boolean[] eratosthenes() {
        boolean[] isPrimes = new boolean[max+1];
        isPrimes[0] = true;
        isPrimes[1] = true;
        for (int i = 2; i * i <= max; i++) {
            if (!isPrimes[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrimes[j] = true;
                }
            }
        }
        return isPrimes;
    }

    private void recursive(String numbers, String pass) {
        if (!pass.isEmpty()) {
            numberSet.add(Integer.parseInt(pass));
            max = Math.max(max, Integer.parseInt(pass));
        }
        for (int i = 0; i < numbers.length(); i++) {
            recursive(numbers.substring(i + 1) + numbers.substring(0, i), pass + numbers.charAt(i));
        }
    }
}
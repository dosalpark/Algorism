import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int gcbA = arrayA[0];
        int gcbB = arrayB[0];
        List<Integer> gcbAllA = gcbAll(gcbA);
        List<Integer> gcbAllB = gcbAll(gcbB);

        for (int i = 0; i < Math.max(gcbAllA.size(), gcbAllB.size()); i++) {
            if (i < gcbAllA.size()) {
                if (canDivision(arrayA, gcbAllA.get(i)) && cantDivision(arrayB, gcbAllA.get(i))) {
                    answer = Math.max(gcbAllA.get(i), answer);
                }

            }
            if (i < gcbAllB.size()) {
                if (canDivision(arrayB, gcbAllB.get(i)) && cantDivision(arrayA, gcbAllB.get(i))) {
                    answer = Math.max(gcbAllB.get(i), answer);
                }
            }
        }

        return answer;
    }

    private List<Integer> gcbAll(int gcb) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(gcb); i++) {
            if (gcb % i == 0) {
                list.add(i);
                list.add(gcb / i);
            }
        }
        return list;
    }

    private boolean cantDivision(int[] array, int gcb) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % gcb == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean canDivision(int[] array, int gcb) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % gcb != 0) {
                return false;
            }
        }
        return true;
    }

}

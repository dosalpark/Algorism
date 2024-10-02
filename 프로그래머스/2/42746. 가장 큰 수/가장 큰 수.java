import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public String solution(int[] numbers) {
        Integer[] num = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        String[] numStr = Arrays.stream(num).map(String::valueOf).toArray(String[]::new);
        Arrays.sort(numStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                while (true) {
                    if (o1.length() == o2.length()) {
                        return o2.compareTo(o1);
                    } else if (o1.length() < o2.length()) {
                        for (int i = 0; i < o1.length(); i++) {
                            if (o1.charAt(i) != o2.charAt(i)) {
                                return o2.substring(i, i + 1).compareTo(o1.substring(i, i + 1));
                            }
                        }
                        o2 = o2.substring(o1.length());
                    } else {
                        for (int i = 0; i < o2.length(); i++) {
                            if (o1.charAt(i) != o2.charAt(i)) {
                                return o2.substring(i, i + 1).compareTo(o1.substring(i, i + 1));
                            }
                        }
                        o1 = o1.substring(o2.length());
                    }
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : numStr) {
            sb.append(str);
        }
        int zeroCount = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                zeroCount++;
            }
        }

        return sb.length() != zeroCount ? sb.toString() : "0";
    }
}
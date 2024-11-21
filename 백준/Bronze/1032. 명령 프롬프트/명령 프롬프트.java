import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] arr = new String[testCase];
        for(int i = 0; i < testCase; i++){
            arr[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();

        if (arr.length == 1) {
            System.out.println(arr[0]);
        } else {
            for (int i = 0; i < arr[0].length(); i++) {
                Set<Character> set = new HashSet<>();
                boolean isDuplicate = false;
                set.add(arr[0].charAt(i));
                for (int j = 0; j < arr.length; j++) {
                    set.add(arr[j].charAt(i));
                    if (set.size() != 1) {
                        isDuplicate = true;
                        break;
                    }
                }
                if (isDuplicate) {
                    sb.append("?");
                } else {
                    sb.append(arr[0].charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}

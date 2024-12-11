import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static class Trial {

        Map<String, Trial> child = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Trial root = new Trial();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            String[] arr = new String[M];
            for (int j = 0; j < M; j++) {
                arr[j] = st.nextToken();
            }
            insert(arr, root);
        }
        print(root, "");

    }

    private static void print(Trial root, String s) {
        Trial cur = root;
        for (String string : cur.child.keySet()) {
            System.out.println(s + string);
            print(root.child.get(string), s + "--");
        }
    }

    private static void insert(String[] arr, Trial root) {
        Trial cur = root;
        for (int i = 0; i < arr.length; i++) {
            cur = cur.child.computeIfAbsent(arr[i], v -> new Trial());
        }
    }

}

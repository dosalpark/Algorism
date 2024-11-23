import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String cur = br.readLine();
            if (cur.length() >= M) {
                words.put(cur, words.getOrDefault(cur, 0) + 1);
            }
        }

        List<String> wordList = new ArrayList<>(words.keySet());
        wordList.sort((o1, o2) -> {
            if (words.get(o1).equals(words.get(o2))) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o2.length() - o1.length();
            }
            return words.get(o2) - words.get(o1);
        });

        for (int i = 0; i < wordList.size(); i++) {
            if (i == wordList.size() - 1) {
                bw.write(wordList.get(i));
            } else {
                bw.write(wordList.get(i) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}

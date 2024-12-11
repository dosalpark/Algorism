import java.io.*;
import java.util.*;

public class Main {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            int N = Integer.parseInt(line.trim());
            TrieNode root = new TrieNode();
            String[] phoneNumbers = new String[N];
            
            for (int i = 0; i < N; i++) {
                phoneNumbers[i] = br.readLine().trim();
                insert(root, phoneNumbers[i]);
            }
            
            double totalTypingCount = 0;
            for (String phone : phoneNumbers) {
                totalTypingCount += calculateTypingCount(root, phone);
            }

            sb.append(String.format("%.2f\n", totalTypingCount / N));
        }

        System.out.print(sb.toString());
    }

    // 트라이에 문자열 삽입
    private static void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.children.computeIfAbsent(c, k -> new TrieNode());
        }
        current.isEndOfWord = true;
    }

    // 타이핑 횟수 계산
    private static int calculateTypingCount(TrieNode root, String word) {
        TrieNode current = root;
        int typingCount = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            current = current.children.get(c);

            // 입력이 필요한 경우
            if (current.children.size() > 1 || current.isEndOfWord || i == word.length() - 1) {
                typingCount++;
            }
        }

        return typingCount;
    }
}

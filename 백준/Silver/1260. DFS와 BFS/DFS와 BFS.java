import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dfsArr;
    static int[] bfsArr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String NMS = br.readLine();
        int N = Integer.parseInt(NMS.split(" ")[0]);
        int M = Integer.parseInt(NMS.split(" ")[1]);
        int S = Integer.parseInt(NMS.split(" ")[2]);
        int[][] node = setNode(N, M, br);
        Arrays.sort(node, (o1, o2) -> {
            if (Math.min(o1[0], o1[1]) == Math.min(o2[0], o2[1])) {
                return Math.max(o1[0], o1[1]) - Math.max(o2[0], o2[1]);
            }
            return Math.min(o1[0], o1[1]) - Math.min(o2[0], o2[1]);
        });
        dfsArr = new int[N + 1];
        bfsArr = new int[N + 1];

        sb = new StringBuilder();
        dfs(S, node, sb);
        System.out.println(sb);

        sb = new StringBuilder();
        bfs(S, node, sb);
        System.out.println(sb);
    }

    private static void bfs(int s, int[][] node, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        bfsArr[s] = 1;
        sb.append(s).append(" ");
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < node.length; i++) {
                int NS = node[i][0];
                int NE = node[i][1];
                if (NS == cur && bfsArr[NE] == 0) {
                    queue.add(NE);
                    bfsArr[NE] = 1;
                    sb.append(NE).append(" ");
                } else if (NE == cur && bfsArr[NS] == 0) {
                    queue.add(NS);
                    bfsArr[NS] = 1;
                    sb.append(NS).append(" ");
                }
            }
        }
    }

    private static void dfs(int s, int[][] node, StringBuilder sb) {
        if (dfsArr[s] == 0) {
            sb.append(s).append(" ");
            dfsArr[s] = 1;
        }

        for (int i = 0; i < node.length; i++) {
            int NS = node[i][0];
            int NE = node[i][1];
            if (NS == s && dfsArr[NE] == 0) {
                dfs(NE, node, sb);
            } else if (NE == s && dfsArr[NS] == 0) {
                dfs(NS, node, sb);
            }
        }

    }

    private static int[][] setNode(int N, int M, BufferedReader br) throws IOException {
        int[][] node = new int[M][2];
        for (int i = 0; i < M; i++) {
            String[] cur = br.readLine().split(" ");
            node[i][0] = Integer.parseInt(cur[0]);
            node[i][1] = Integer.parseInt(cur[1]);
        }
        return node;
    }

}

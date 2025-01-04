import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static int T, N, result;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int[] students;
    static boolean[] visit;
    static Set<Integer> set ;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            students = new int[N + 1];
            visit = new boolean[N + 1];
            result = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                students[i] = Integer.parseInt(st.nextToken());
                if (students[i] == i) {
                    visit[i] = true;
                    result++;
                }
            }
            List<Integer> group;
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    set = new HashSet<>();
                    group = new ArrayList<>();
                    visit[i] = true;
                    dfs(i, group);
                }
            }
            bw.write(N - result + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static boolean dfs(int now, List<Integer> group) {
        //나를 그룹에 포함
        group.add(now);
        set.add(now);
        //다음행선지 찾음
        int next = students[now];
        //다음 행선지가 나네? 그럼 그룹에 들어있는거 끝냄
        if (set.contains(next)) {
            for(int i = group.size()-1; i >= 0; i--){
                result++;
                if(group.get(i) == next){
                    break;
                }
            }
            return true;
        }
        //다음 행선지가 방문이 안되있으면 방문 처리 후 이동
        if (visit[next]) {
            return false;
        }
        visit[next] = true;
        if(!dfs(next, group)){
            visit[next] = false;
        }

        return true;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] tree = new List[N+1];
        for(int i = 1; i <= N; i++){
           tree[i] = new ArrayList<>();
        }
        for(int i = 0; i < N-1; i++){
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            tree[A].add(B);
            tree[B].add(A);
        }

        int[] parentNode = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        parentNode[1] = -1;
        while (!queue.isEmpty()){
            int cur = queue.poll();

            for (Integer node : tree[cur]) {
                if(parentNode[node] == 0){
                    parentNode[node] = cur;
                    queue.add(node);
                }
            }
        }

        for(int i = 2; i <=N; i++){
            System.out.println(parentNode[i]);
        }
    }
}

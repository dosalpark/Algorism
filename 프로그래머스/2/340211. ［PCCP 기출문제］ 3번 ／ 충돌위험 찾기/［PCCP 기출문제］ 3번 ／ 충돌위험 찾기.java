import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;

class Solution {

    Map<Integer, Loc> positionMap = new HashMap<>();
    int max = 0;

    public int solution(int[][] points, int[][] routes) {
        positionSetting(points);
        Queue<Loc>[] queues = new Queue[routes.length];

        for (int i = 0; i < routes.length; i++) {
            queues[i] = move(queues[i], routes[i]);
            max = Math.max(queues[i].size(), max);
        }

        return crushCheck(queues, max);
    }

    private Queue<Loc> move(Queue<Loc> queue, int[] route) {
        queue = new LinkedList<>();
        for (int i = 1; i < route.length; i++) {
            Loc start = positionMap.get(route[i - 1]);
            Loc next = positionMap.get(route[i]);

            int startY = start.r;
            int startX = start.c;

            if (queue.isEmpty()) {
                queue.add(new Loc(startY, startX));
            }
            while (startY != next.r) {
                startY = next.r < startY ? startY - 1 : startY + 1;
                queue.add(new Loc(startY, startX));
            }
            while (startX != next.c) {
                startX = next.c < startX ? startX - 1 : startX + 1;
                queue.add(new Loc(startY, startX));
            }

        }
        return queue;
    }

    private int crushCheck(Queue<Loc>[] queues, int max) {
        int collusionCount = 0;
        for (int i = 0; i < max; i++) {
            Map<Loc, Integer> collusion = new HashMap<>();
            for (int j = 0; j < queues.length; j++) {
                if (!queues[j].isEmpty()) {
                    Loc cur = queues[j].poll();
                    collusion.put(cur, collusion.getOrDefault(cur, 0) + 1);
                }
            }

            for (Integer value : collusion.values()) {
                if (value > 1) {
                    collusionCount++;
                }
            }
        }
        return collusionCount;
    }

    private void positionSetting(int[][] points) {
        for (int i = 0; i < points.length; i++) {
            positionMap.put(i + 1, new Loc(points[i][0], points[i][1]));
        }

    }

    public class Loc {

        int r;
        int c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Loc(int r, int c, int nextPoint) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }
            Loc o = (Loc) obj;
            return (this.r == o.r && this.c == o.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

    }
}

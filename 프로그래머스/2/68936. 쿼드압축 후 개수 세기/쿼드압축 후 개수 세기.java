import java.util.Arrays;

class Solution {

    int[] answer = new int[2];

    public int[] solution(int[][] arr) {

        quad(arr, 0, 0, arr.length, arr[0][0]);

        return answer;
    }

    private void quad(int[][] arr, int y, int x, int max, int point) {
        if (check(arr, y, x, max, point)) {
            answer[point]++;
            return;
        }
        max = max / 2;
        if (max == 0) {
            return;
        }

        quad(arr, y, x, max, arr[y][x]);
        quad(arr, y, x + max, max, arr[y][x+max]);
        quad(arr, y + max, x, max, arr[y+max][x]);
        quad(arr, y + max, x + max, max, arr[y+max][x+max]);
    }

    private boolean check(int[][] arr, int y, int x, int max, int point) {
        for (int i = y; i < y + max; i++) {
            for (int j = x; j < x + max; j++) {
                if (arr[i][j] != point) {
                    return false;
                }
            }
        }
        return true;
    }
}

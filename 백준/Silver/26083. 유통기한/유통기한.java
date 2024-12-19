import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static int year;
    static int month;
    static int day;
    static LocalDate today;
    static int one;
    static int two;
    static int three;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        year = Integer.parseInt(st.nextToken());
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        today = LocalDate.of(year + 2000, month, day);

        N = Integer.parseInt(br.readLine());
        int[][] T;
        String status;
        for (int i = 0; i < N; i++) {
            status = "invalid";
            T = new int[3][4];
            st = new StringTokenizer(br.readLine());
            one = Integer.parseInt(st.nextToken()); // 10
            two = Integer.parseInt(st.nextToken()); // 12
            three = Integer.parseInt(st.nextToken()); // 32
            int[][] dateType = new int[][]{{one, two, three}, {three, two, one}, {three, one, two}};
            for (int j = 0; j < dateType.length; j++) {
                if (check(dateType[j])) {
                    status = deadLineCheck(dateType[j]);
                    if (status.equals("unsafe")) {
                        break;
                    }
                }
            }
            bw.write(status + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static String deadLineCheck(int[] YMD) {
        if (YMD[0] < year) {
            return "unsafe";
        } else if (YMD[0] == year) {
            if (YMD[1] < month) {
                return "unsafe";
            } else if (YMD[1] == month) {
                if (YMD[2] < day) {
                    return "unsafe";
                } else {
                    return "safe";
                }
            } else {
                return "safe";
            }
        } else {
            return "safe";
        }
    }

    private static boolean check(int[] YMD) {
        if (1 <= YMD[1] && YMD[1] <= 12) {
            if (YMD[1] == 1 || YMD[1] == 3 || YMD[1] == 5 || YMD[1] == 7 || YMD[1] == 8
                || YMD[1] == 10 || YMD[1] == 12) {
                return 1 <= YMD[2] && YMD[2] <= 31;
            } else if (YMD[1] == 2) {
                int yun = YMD[0] % 4 == 0 ? 29 : 28;
                return 1 <= YMD[2] && YMD[2] <= yun;
            } else {
                return 1 <= YMD[2] && YMD[2] <= 30;
            }
        }
        return false;
    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int N;
    static BufferedReader br;
    static BufferedWriter bw;
    static char[][] pan;
    static int index;
    static int line;
    static StringBuilder sb;
    static String[] numbers;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        line = N / 5;
        pan = new char[5][line];
        numberSetting();

        String signal = br.readLine();
        index = 0;
        for (int i = 0; i < N; i += line) {
            pan[index++] = signal.substring(i, i + line).toCharArray();
        }

        index = 0;
        while (index < line) {
            if (pan[0][index] == '.') {
                index++;
                continue;
            }
            if (index + 2 < line && pan[0][index + 1] == '#' && pan[0][index + 2] == '#') {
                sb = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    for (int j = index; j < index + 3; j++) {
                        sb.append(pan[i][j]);
                    }
                }
                for (int i = 0; i < numbers.length; i++) {
                    if (i == 1 || i == 4) {
                        continue;
                    }
                    if (numbers[i].equals(sb.toString())) {
                        bw.write(String.valueOf(i));
                        break;
                    }
                }
                index += 3;
                continue;
            }
            if (pan[3][index] == '#') {
                bw.write("1");
                index++;
            } else {
                bw.write("4");
                index += 3;
            }
        }

        bw.flush();
        bw.close();
    }

    private static void numberSetting() {
        numbers = new String[10];
        numbers[0] = "####.##.##.####";
        numbers[2] = "###..#####..###";
        numbers[3] = "###..####..####";
        numbers[5] = "####..###..####";
        numbers[6] = "####..####.####";
        numbers[7] = "###..#..#..#..#";
        numbers[8] = "####.#####.####";
        numbers[9] = "####.####..####";
    }
}

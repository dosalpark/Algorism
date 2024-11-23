import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.lines().forEach(Main::converter);

    }
    private static void converter(String str){
        String dashs = "-".repeat((int) Math.pow(3, Integer.parseInt(str)));
        StringBuilder result = new StringBuilder();
        dfs(result, dashs);
        System.out.println(result);
    }

    private static void dfs(StringBuilder result, String dashs) {
        if (dashs.length() == 1) {
            result.append("-");
            return;
        }
        int division = dashs.length() / 3;
        dfs(result, dashs.substring(0, division));
        for (int i = 0; i < division; i++) {
            result.append(" ");
        }
        dfs(result, dashs.substring(division * 2));
    }

}
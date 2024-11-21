import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] AB = br.readLine().split(" ");

        System.out.println(Integer.parseInt(AB[0]) + Integer.parseInt(AB[1]));
    }
}

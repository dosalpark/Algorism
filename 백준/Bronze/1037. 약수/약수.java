import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String[] nums = br.readLine().split(" ");
        Arrays.sort(nums, (o1, o2) -> Integer.parseInt(o1) - Integer.parseInt(o2));
        int result = Integer.parseInt(nums[0]) * Integer.parseInt(nums[nums.length - 1]);
        System.out.println(result);
    }
}

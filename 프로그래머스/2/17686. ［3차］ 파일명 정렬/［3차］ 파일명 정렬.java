import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files,(o1, o2) -> {
            String[] o1substring = substring(o1);
            String[] o2substring = substring(o2);
            if(o1substring[0].equals(o2substring[0])){
                int o1Num = Integer.parseInt(o1substring[1]);
                int o2Num = Integer.parseInt(o2substring[1]);
                if(o1Num == o2Num){
                    return 0;
                }
                return o1Num - o2Num;
            }
            return o1substring[0].compareTo(o2substring[0]);

        });
        return files;
    }

    private String[] substring(String str) {
        String[] substr = new String[3];
        Pattern pattern = Pattern.compile("([a-zA-Z\\-\\. ]+)(\\d{1,5})(.*)");
        Matcher matcher = pattern.matcher(str);
        if(matcher.matches()){
            substr[0] = matcher.group(1).toUpperCase();
            substr[1] = matcher.group(2);
            substr[2] = matcher.group(3);
        }
        return substr;
    }
}

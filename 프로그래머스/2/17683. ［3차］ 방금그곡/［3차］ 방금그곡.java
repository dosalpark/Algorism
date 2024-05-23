import java.util.*;
class Solution {

    public String sharpChange(String sheet) {
        sheet = sheet.replaceAll("A#","a");
        sheet = sheet.replaceAll("B#","b");
        sheet = sheet.replaceAll("C#","c");
        sheet = sheet.replaceAll("D#","d");
        sheet = sheet.replaceAll("E#","e");
        sheet = sheet.replaceAll("F#","f");
        sheet = sheet.replaceAll("G#","g");
        sheet = sheet.replaceAll("H#","h");
        return sheet;
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max = 0;
        m = sharpChange(m);

        for (String music : musicinfos) {
            String[] part = music.split(",");
            String[] start = part[0].split(":");
            String[] end = part[1].split(":");
            String name = part[2];
            String sheet = sharpChange(part[3]);

            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            int runningTime = endTime - startTime;
            if (runningTime == 0) {
                continue;
            }

            if (runningTime > sheet.length()) {
                String copySheet = sheet;
                while (runningTime > sheet.length()) {
                    sheet += copySheet;
                }
            }

            sheet = sheet.substring(0,runningTime);

            if (sheet.contains(m)){
                if(max < runningTime){
                    max = runningTime;
                    answer = name;
                }
            }
        }
        return answer;
    }
}

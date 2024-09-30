class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int topPlayTime = 0;
        m = conversion(m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] musicInfo = musicinfos[i].split(",");
            String[] start = musicInfo[0].split(":");
            String[] end = musicInfo[1].split(":");
            String title = musicInfo[2];
            String melody = conversion(musicInfo[3]);
            int playTime = (Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1])) -
                (Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]));

            while (playTime > melody.length()) {
                melody += melody;
            }
            melody = melody.substring(0, playTime);

            if (melody.contains(m) && playTime > topPlayTime) {
                topPlayTime = playTime;
                answer = title;
            }
        }

        return answer;
    }

    private String conversion(String m) {
        StringBuilder sb = new StringBuilder();
        boolean sharp = false;
        for (int i = m.length() - 1; i >= 0; i--) {
            if (m.charAt(i) == '#') {
                sharp = true;
                continue;
            }

            if (sharp) {
                sb.append(String.valueOf(m.charAt(i)).toLowerCase());
                sharp = false;
            } else {
                sb.append(m.charAt(i));
            }
        }
        return sb.reverse().toString();
    }
}

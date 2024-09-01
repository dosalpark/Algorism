class Solution {

    public int solution(String dartResult) {
        int answer = 0;
        String[] round = new String[3];
        int[] roundScore = new int[3];

        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            sb.append(ch);
            if (i == dartResult.length() - 1) {
                round[index] = sb.toString();
                continue;
            }

            if (ch == 'S' || ch == 'T' || ch == 'D') {
                if (dartResult.charAt(i + 1) == '*' || dartResult.charAt(i + 1) == '#') {
                    continue;
                }
                round[index] = sb.toString();
                sb.setLength(0);
                index++;
            }

            if (ch == '*' || ch == '#') {
                round[index] = sb.toString();
                sb.setLength(0);
                index++;
            }
        }

        for (int i = 0; i < 3; i++) {
            StringBuilder scoreStr = new StringBuilder();
            for (int j = 0; j < round[i].length(); j++) {
                char ch = round[i].charAt(j);
                if ('0' <= ch && ch <= '9') {
                    scoreStr.append(ch);
                    continue;
                }

                if (ch == 'S') {
                    int score = Integer.parseInt(scoreStr.toString());
                    roundScore[i] = score;
                    continue;
                } else if (ch == 'D') {
                    int score = Integer.parseInt(scoreStr.toString());
                    roundScore[i] = score * score;
                    continue;
                } else if (ch == 'T') {
                    int score = Integer.parseInt(scoreStr.toString());
                    roundScore[i] = score * score * score;
                    continue;
                }

                if (ch == '#') {
                    roundScore[i] *= -1;
                }
                if (ch == '*') {
                    roundScore[i] *= 2;
                    if (i != 0) {
                        roundScore[i - 1] *= 2;
                    }
                }

            }

        }

        for (int i = 0; i < 3; i++) {
            answer += roundScore[i];
        }
        return answer;
    }
}

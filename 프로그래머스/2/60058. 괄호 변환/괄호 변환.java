class Solution {

    public String solution(String p) {
        return dfs(p);
    }

    private String dfs(String p) {
        if (p.isEmpty()) {
            return "";
        }
        String[] UV = getUV(p);

        if (isCorrect(UV[0])) {
            return UV[0] + dfs(UV[1]);
        } else {
            StringBuilder sb = new StringBuilder("(");
            sb.append(dfs(UV[1]));
            sb.append(")");

            for (int i = 1; i < UV[0].length() - 1; i++) {
                if (UV[0].charAt(i) == '(') {
                    sb.append(')');
                    continue;
                }
                sb.append('(');
            }
            return sb.toString();
        }
    }

    private boolean isCorrect(String u) {
        int check = 0;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                check++;
            } else {
                check--;
            }
            if (check < 0) {
                return false;
            }
        }
        return true;
    }

    private String[] getUV(String p) {
        int index;
        int zeroIsSame = 0;
        for (index = 0; index < p.length(); index++) {
            if (p.charAt(index) == '(') {
                zeroIsSame++;
            } else {
                zeroIsSame--;
            }

            if (zeroIsSame == 0) {
                break;
            }
        }
        return new String[]{p.substring(0, index + 1), p.substring(index + 1)};
    }
}

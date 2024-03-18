class Solution {
    public String solution(String s) {
        StringBuilder sBuilder = new StringBuilder();
        String[] sSplit = s.split(" ");
        for (int i = 0; i < sSplit.length; i++) {
            String addStr = sSplit[i].toLowerCase();
            if (addStr.isEmpty()) {

            } else if ('a' <= addStr.charAt(0) && addStr.charAt(0) <= 'z') {
                sBuilder.append(addStr.substring(0,1).toUpperCase());
                sBuilder.append(addStr.substring(1));
            } else if ('0' <= addStr.charAt(0) && addStr.charAt(0) <= '9') {
                sBuilder.append(addStr);
            }
            if (i < sSplit.length - 1) {
                sBuilder.append(" ");
            }
        }
        for(int i = s.length() - sBuilder.length(); i > 0; i--){
            sBuilder.append(" ");
        }
        return sBuilder.toString();
    }
}
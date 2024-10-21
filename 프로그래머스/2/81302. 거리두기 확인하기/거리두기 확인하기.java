class Solution {

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = check(places[i]) ? 1 : 0;
        }
        return answer;
    }

    private boolean check(String[] place) {
        int[] dy = {0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0};
        for (int y = 0; y < place.length; y++) {
            for (int x = 0; x < place[y].length(); x++) {
                char ch = place[y].charAt(x);
                if (ch == 'P') {
                    for (int i = 0; i < 4; i++) {
                        int ny = y + dy[i];
                        int nx = x + dx[i];
                        if (lengthCheck(ny, nx)) {
                            if (place[ny].charAt(nx) == 'P') {
                                return false;
                            }
                            if (place[ny].charAt(nx) == 'O') {
                                if (lengthCheck(ny + dy[i], nx + dx[i])) {
                                    if (place[ny + dy[i]].charAt(nx + dx[i]) == 'P') {
                                        return false;
                                    }
                                }
                                if (Math.abs(dy[i]) == 1) {
                                    if (lengthCheck(ny, nx - 1)) {
                                        if (place[ny].charAt(nx - 1) == 'P') {
                                            return false;
                                        }
                                    }
                                    if (lengthCheck(ny, nx + 1)) {
                                        if (place[ny].charAt(nx + 1) == 'P') {
                                            return false;
                                        }
                                    }
                                } else {
                                    if (lengthCheck(ny - 1, nx)) {
                                        if (place[ny - 1].charAt(nx) == 'p') {
                                            return false;
                                        }
                                    }
                                    if (lengthCheck(ny + 1, nx)) {
                                        if (place[ny + 1].charAt(nx) == 'p') {
                                            return false;
                                        }
                                    }
                                }

                            }
                        }

                    }
                }
            }
        }
        return true;
    }

    private boolean lengthCheck(int y, int x) {
        return 0 <= y && 0 <= x && y < 5 && x < 5;
    }

}

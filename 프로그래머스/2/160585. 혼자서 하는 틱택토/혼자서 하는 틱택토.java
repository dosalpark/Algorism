class Solution {

    public int solution(String[] board) {
        int answer = 0;
        int[] OXCheck = check(board);
        boolean OSuccess = false;
        boolean XSuccess = false;
        for (int i = 0; i < board.length; i++) {
            if (board[i].charAt(0) == board[i].charAt(1)
                && board[i].charAt(1) == board[i].charAt(2)) {
                if (board[i].charAt(0) == 'O') {
                    OSuccess = true;
                } else if (board[i].charAt(0) == 'X') {
                    XSuccess = true;
                }
            }
        }
        for (int i = 0; i < board[0].length(); i++) {
            if (board[0].charAt(i) == board[1].charAt(i)
                && board[1].charAt(i) == board[2].charAt(i)) {
                if (board[0].charAt(i) == 'O') {
                    OSuccess = true;
                } else if (board[0].charAt(i) == 'X') {
                    XSuccess = true;
                }
            }
        }

        if (board[0].charAt(0) == board[1].charAt(1)
            && board[1].charAt(1) == board[2].charAt(2)) {
            if (board[0].charAt(0) == 'O') {
                OSuccess = true;
            } else if (board[0].charAt(0) == 'X') {
                XSuccess = true;
            }
        }
        if (board[2].charAt(0) == board[1].charAt(1)
            && board[1].charAt(1) == board[0].charAt(2)) {
            if (board[2].charAt(0) == 'O') {
                OSuccess = true;
            } else if (board[2].charAt(0) == 'X') {
                XSuccess = true;
            }
        }
        System.out.println("OSuccess = " + OSuccess);
        System.out.println("XSuccess = " + XSuccess);
        if (OXCheck[0] == 0 && OXCheck[1] == 0) {
            return 1;
        } else {
            if (!OSuccess && !XSuccess) {
                return (OXCheck[0] - OXCheck[1] == 1 || OXCheck[0] == OXCheck[1]) ? 1 : 0;
            } else if (OSuccess && XSuccess) {
                return 0;
            } else if (!OSuccess) {
                return OXCheck[0] == OXCheck[1] ? 1 : 0;
            } else {
                return OXCheck[0] - OXCheck[1] == 1 ? 1 : 0;
            }
        }

    }

    private int[] check(String[] board) {
        int[] check = {0, 0, 0};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'O') {
                    check[0]++;
                } else if (board[i].charAt(j) == 'X') {
                    check[1]++;
                } else {
                    check[2]++;
                }
            }
        }
        return check;
    }
}

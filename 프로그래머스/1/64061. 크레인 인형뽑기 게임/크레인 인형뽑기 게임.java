//[1,5,3,5,1,2,1,4]	4
// [0,0,0,0,0], 11/33
// [0,0,1,0,3],
// [0,2,5,0,1],
// [4,2,4,4,2],
// [3,5,1,3,1]

import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < moves.length; i++){
            int line = moves[i];
            System.out.println("[라운드]------------" + i);
            for(int j = 0; j < board.length; j++){
                if(board[j][line-1] != 0){
                    int toy = board[j][line-1];
                    if(stack.isEmpty()){
                        System.out.println("박은돌" + toy);
                        stack.push(toy);
                    } else {
                        if(stack.peek() == toy){
                            System.out.println("박혀있던돌" + stack.peek());
                            System.out.println("굴러온돌" + toy);
                            answer += 2;
                            stack.pop();
                        } else {
                            stack.push(toy);
                            System.out.println("박은돌" + toy);
                        }
                    }
                    board[j][line-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
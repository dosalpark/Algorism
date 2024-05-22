import java.util.*;
class Solution {
    public int bfs(int storey){
        int answer = 0;

        Queue<Elevator> que = new LinkedList<>();
        que.add(new Elevator(storey,0));

        int floor = 1;
        while(!que.isEmpty()){
            Elevator elevator = que.poll();
            int now = elevator.getNow();
            int count = elevator.getCount();
            System.out.println("now: " + now + "/ count: " + count);

            if(now == 0){
                return count;
            }
            if(now%10 == 0){
                while(true){
                    now /= 10;
                    if(now%10 != 0) break;
                    System.out.println("now: " + now + "/ count: " + count);
                }
            }
            if(now%10 > 5){
                que.add(new Elevator(now + floor, count + 1));
            }else{
                que.add(new Elevator(now - floor, count + 1));
            }
        }
        return answer;
    }


    public int solution(int storey) {
        return bfs(storey);
    }
}

class Elevator {
    public int now;
    public int count;

    public Elevator(int now, int count){
        this.now = now;
        this.count = count;
    }

    public int getNow(){
        return this.now;
    }
    public int getCount(){
        return this.count;
    }
}

import java.util.*;
class Solution {
    Map<String,Integer> map = new HashMap<>();

    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int num = 0;
        int index = 27;
        defaultSetting();

        while(msg.length()!=0){
            sb.append(msg.charAt(num));
            num++;

            while(map.containsKey(sb.toString())){
                if(num >= msg.length()){
                    sb.append("#");
                    break;
                }
                sb.append(msg.charAt(num));
                num++;
            }

            map.put(sb.toString(), index); //index = 27
            index++; //index = 28

            String now = sb.toString().substring(0,sb.length()-1);
            list.add(map.get(now));
            msg = msg.substring(now.length());
            num = 0;
            sb.setLength(0);
        }

        answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    public void defaultSetting(){
        map.put("A",1);
        map.put("B",2);
        map.put("C",3);
        map.put("D",4);
        map.put("E",5);
        map.put("F",6);
        map.put("G",7);
        map.put("H",8);
        map.put("I",9);
        map.put("J",10);
        map.put("K",11);
        map.put("L",12);
        map.put("M",13);
        map.put("N",14);
        map.put("O",15);
        map.put("P",16);
        map.put("Q",17);
        map.put("R",18);
        map.put("S",19);
        map.put("T",20);
        map.put("U",21);
        map.put("V",22);
        map.put("W",23);
        map.put("X",24);
        map.put("Y",25);
        map.put("Z",26);
    }


}

import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int[] 둥이 = new int[2];
        List<String> xlist = new ArrayList<>();
        //i: 세로, j: 가로        
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S'){
                    둥이[0] = i;
                    둥이[1] = j;
                } 
                if(park[i].charAt(j) == 'X') xlist.add(i+" "+j);
            }
        }
        
        
        for(String route : routes){
            int[] 미리가보는둥이 = 둥이.clone();
            boolean flag = true;
            int[] 이동방향 = 이동방향찾기(route.split(" ")[0]);
            int 이동거리 = Integer.parseInt(route.split(" ")[1]); 
            
            for(int i = 0; i < 이동거리; i++){
                int 위아래 = 미리가보는둥이[0] + 이동방향[0];
                int 좌우 = 미리가보는둥이[1] + 이동방향[1];
                if(위아래 < 0 || 좌우 < 0 || 위아래 >= park.length || 좌우 >= park[0].length() || 
                  xlist.contains(위아래+" "+좌우)){
                    flag = false;
                    break;
                } else {
                    미리가보는둥이[0] = 위아래;
                    미리가보는둥이[1] = 좌우;
                }
            }
            if(flag){
                둥이 = 미리가보는둥이;
            }
        }
        return 둥이;
    }
    
    private int[] 이동방향찾기(String str){
        int[][] 방향 = {{0,1},{0,-1},{1,0},{-1,0}};
        switch(str){
            case "E" :
                    return 방향[0];
            case "W" :
                    return 방향[1];
            case "S" :
                    return 방향[2];
            case "N" :
                    return 방향[3];
        }
        return null;
    }
}
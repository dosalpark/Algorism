import java.util.*;
class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        map.put("code",0);
        map.put("date",1);
        map.put("maximum",2);
        map.put("remain",3);
        
        int extType = map.get(ext);
        int sortType = map.get(sort_by);
        
        for(int[] oneData : data){
            if(oneData[extType] < val_ext){
                list.add(oneData);
            }
        }
        
        int[][] answer = new int[list.size()][map.size()];
        list.sort(Comparator.comparingInt(i -> i[sortType]));
        list.toArray(answer);

        return answer;
    }
}
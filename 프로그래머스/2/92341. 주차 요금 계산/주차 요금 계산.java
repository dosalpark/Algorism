import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int checkAmount(int sumTime, int[] fees){
        int defaultTime = fees[0];
        int defaultPrice = fees[1];
        int unitTime = fees[2];
        int unitTimeCost = fees[3];


        if(sumTime <= defaultTime) return defaultPrice;
        else {
            int overTime = sumTime - defaultTime;
            if(overTime%unitTime != 0) overTime += unitTime;


            return defaultPrice + (overTime/unitTime) * unitTimeCost;
        }
    }

    public int[] solution(int[] fees, String[] records) {
        List<String> indexList = new ArrayList<>();
        Map<String, Info> numberMap = new HashMap<>();
        int maxTime = 23 * 60 + 59;

        for(int i = 0; i < records.length; i++){
            String[] record = records[i].split(" ");
            String time = record[0];
            int convertTime = Integer.parseInt(time.split(":")[0]) * 60 + Integer.parseInt(time.split(":")[1]);
            String number = record[1];
            String inout = record[2];

            if(inout.equals("IN")){
                if(!indexList.contains(number)){
                    indexList.add(number);
                    Info newInfo = new Info(number);
                    numberMap.put(number,newInfo);
                }
                Info oldInfo = numberMap.get(number);
                oldInfo.updateIn(convertTime);
                numberMap.put(number,oldInfo);
            } else {
                Info outInfo = numberMap.get(number);
                outInfo.updateOut(convertTime);
                numberMap.put(number,outInfo);
            }
        }

        Collections.sort(indexList);
        int[] answer = new int[indexList.size()];

        for(int i = 0; i < indexList.size(); i++){
            Info info = numberMap.get(indexList.get(i));
            if(info.getIsIn()){
                info.updateOut(maxTime);
            }
            answer[i] = checkAmount(info.getSumTime(), fees);
        }

        return answer;
    }
}

class Info{
    String number;
    boolean isIn;
    int inTime;
    int sumTime;

    Info(String number){
        this.number = number;
        this.isIn = false;
        this.inTime = 0;
        this.sumTime = 0;
    }

    boolean getIsIn(){
        return this.isIn;
    }

    int getSumTime(){
        return this.sumTime;
    }

    void updateIn(int inTime){
        this.isIn = true;
        this.inTime = inTime;
    }
    void updateOut(int outTime){
        this.sumTime = sumTime + (outTime - this.inTime);
        this.isIn = false;
        this.inTime = 0;
    }
}

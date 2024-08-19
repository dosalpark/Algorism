import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        List<String> numbers = new ArrayList<>();
        Map<String, String> inMap = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();
        
        for(String record : records){
            String number = record.split(" ")[1];
            String time = record.split(" ")[0];
            String what = record.split(" ")[2];
            
            if(!numbers.contains(number)){
                numbers.add(number);
            }
            
            if(what.equals("IN")){
                inMap.put(number,time);
            } else {
                String beforeTime = inMap.get(number);
                int minusTime = timeCalculator(beforeTime, time);
                
                sumMap.put(number, sumMap.getOrDefault(number,0) + minusTime);
                inMap.put(number,"0");
            }
        }
        Collections.sort(numbers);
        answer = new int[numbers.size()];
        
        for(int i = 0; i < numbers.size(); i++){
            //출차 안된 차량 확인
            String cur = inMap.get(numbers.get(i));
            if(!cur.equals("0")){
                int minusTime = timeCalculator(cur, "23:59");
                sumMap.put(numbers.get(i), sumMap.getOrDefault(numbers.get(i),0) + minusTime);
                inMap.put(numbers.get(i),"0");
            }
            int parkingTime = sumMap.get(numbers.get(i));
            System.out.println("parkingTime: " + parkingTime + " / number: " + numbers.get(i));
            answer[i] = priceCalculator(fees, parkingTime);
            
        }
        return answer;
    }
    
    private int priceCalculator(int[] fees, int parkingTime){
        int basicTime = fees[0];
        int basicPrice = fees[1];
        int overTime = fees[2];
        int overTimePrice = fees[3];
        
        if(basicTime >= parkingTime){
            return basicPrice;
        }
        
        int roundParkingTime = (parkingTime - basicTime) % overTime;
        if(roundParkingTime != 0){
            parkingTime += overTime;
        }
        
        return basicPrice + ((parkingTime - basicTime) / overTime) * overTimePrice;
    }
    
    private int timeCalculator(String before, String now){
        int nowTimeScore = (Integer.parseInt(now.split(":")[0]) * 60) + 
            Integer.parseInt(now.split(":")[1]);
        int beforeTimeScore = (Integer.parseInt(before.split(":")[0]) * 60) + 
            Integer.parseInt(before.split(":")[1]);
        return nowTimeScore - beforeTimeScore;
    }
}
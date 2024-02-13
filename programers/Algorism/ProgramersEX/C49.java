//정수 배열 numbers가 주어집니다.
//numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.
//
////start
//import java.util.*;
//import java.util.stream.*;
//class Solution {
//    public int[] solution(int[] numbers) {
//        //입력받은 배열 리스트로 전환
//        List<Integer> nums = Arrays.stream(numbers).map(i -> i).boxed().collect(Collectors.toList());
//        //더한값 받을 List
//        List<Integer> sum = new ArrayList<>();
//
//        //i와 i+1 이중for문으로 값 더함
//        for(int i = 0; i < nums.size(); i++ ){
//            for(int j = i+1; j < nums.size(); j++){
//                sum.add(nums.get(i) + nums.get(j));
//            }
//        }
//        //정렬 및 중복제거해서 배열로 전달
//        return sum.stream().sorted().distinct().mapToInt(i->i).toArray();
//    }
//}
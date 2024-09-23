class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        // 1. pos를 숫자로 변환
        // 2. 숫자로 변환한 pos를 commands에 따라서 시간을 수정
        // 3. 완료된 숫자가 오프닝보다 이전일 경우는 오프닝을 반환하고 아닐경우 시간을 반환
        
        int int_os = conveter(pos);
        int int_op_start = conveter(op_start);
        int int_op_end = conveter(op_end);
        int int_video_end = conveter(video_len);
        
        for(int i = 0; i < commands.length; i++){
            if(int_op_start <= int_os && int_os <= int_op_end){
                int_os = int_op_end;
            }
            
            if(commands[i].equals("prev")){
                int_os -= 10;
            } else {
                int_os += 10;
            }
            
            if(int_os < 0){
                int_os = 0;
            }
            if(int_os > int_video_end){
                int_os = int_video_end;
            }
        }
        
        if(int_op_start <= int_os && int_os <= int_op_end){
            answer = op_end;
        } else if(int_os > int_video_end){
            answer = video_len;
        } else {
            String h = String.valueOf(int_os / 60);
            String m = String.valueOf(int_os % 60);
            System.out.println("h: " + h + " / m: " + m);
            if(h.length() == 1){
                h = 0 + h;
            }
            if(m.length() == 1){
                m = 0 + m;
            }
            answer = h + ":" + m;
            
        }
        
        return answer;
    }
    
    private int conveter(String str){
        String[] HM = str.split(":");
        int hour = Integer.parseInt(HM[0]) * 60;
        int min = Integer.parseInt(HM[1]);
        
        return hour + min;
    }
}
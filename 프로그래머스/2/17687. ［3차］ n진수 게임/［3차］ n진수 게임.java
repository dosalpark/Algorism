class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < t*m; i++){
            result.append(Integer.toString(i,n));
        }
        String[] arr = result.toString().split("");
        result.setLength(0);

        for(int i = p-1; i < arr.length; i=i+m){
            result.append(arr[i]);
            if(result.length()==t){
                break;
            }
        }

        return result.toString().toUpperCase();
    }
}

class Solution {
    public String solution(String number, int k) {
        int n = number.length() - k;
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            int max = 0;
            for(int j = index; j <= number.length() - n + i; j++){
                if(number.charAt(j) - '0' > max){
                    max = (number.charAt(j) - '0');
                    index = j + 1;
                } 
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
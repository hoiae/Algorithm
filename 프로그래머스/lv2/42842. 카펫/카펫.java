class Solution {
    public int[] solution(int brown, int yellow) {
        //카펫의 가로 세로는 최소 3이다.
        //브라운 + 옐로우의 개수를 만족하는지 경우만 찾아야함
        //sum이라는 변수를 통해서 brown + yellow


        int sum = brown + yellow;
        
        for(int row = 3; ;row++){
            int col = sum / row;
            if(col < row){
                continue;
            }
            if((col - 2) * (row -2) == yellow)
                return new int[]{col, row};
        }

}
}
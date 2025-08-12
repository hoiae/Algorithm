class Solution {
    private static final int LIMIT = 10_000_000;

    public int[] solution(long begin, long end) {
        int size = (int) (end - begin + 1);
        int[] answer = new int[size];
        int idx = 0;

        for (long n = begin; n <= end; n++) {
            if (n == 1) {              
                answer[idx++] = 0;
                continue;
            }

            int best = 1;             
            long root = (long) Math.sqrt(n);

            for (long j = 2; j <= root; j++) {
                if (n % j != 0) continue;

                long pair = n / j;     
                if (pair <= LIMIT){
                    best = (int) pair;
                    break;
                }
                if (j <= LIMIT) {      
                    best = (int) j;
                }
            }

            answer[idx++] = best;    
        }

        return answer;
    }
}

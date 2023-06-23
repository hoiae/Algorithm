
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Jewel implements Comparable<Jewel>{
        int weight;
        int price;
        public Jewel(int weight, int price){
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewel j){ //무게를 기준으로 정렬하기 위한 메서드
            return Integer.compare(this.weight, j.weight);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        int weight = 0;
        int price = 0;
        //가격별로 정렬함.
        //보석을 무게순으로 오름차순 정렬함
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            weight = Integer.parseInt(st.nextToken());
            price = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(weight, price)) ;
        }

        Collections.sort(jewels);//무게를 기준으로 오름차순 정렬


        //가방들의 무게를 담을 배열이 필요함. 오름차순 정렬.
        int[] bags = new int[k];
        for(int i = 0; i < k; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //최대힙, 가장 큰 가격을 반환함.
        int index = 0;
        for(int i = 0; i < bags.length; i++){
            int nowWeight = bags[i];
            for(int j = index; j < jewels.size(); j++){
                if(jewels.get(j).weight <= nowWeight){
                    pq.offer(jewels.get(j).price);
                    index = j + 1; 
                }
                else{
                    break;
                }
            }
            if(pq.isEmpty())
                continue;
            answer += pq.poll();
        }

        System.out.println(answer);
    }
}



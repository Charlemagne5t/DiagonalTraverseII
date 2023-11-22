import java.util.*;

public class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size = 0;
        Map<Integer, PriorityQueue<Integer[]>> map = new TreeMap<>();
        for(int i = 0; i < nums.size(); i++){
            size += nums.get(i).size();
            for(int j = 0; j < nums.get(i).size(); j++){
                int sum = i + j;
                if(!map.containsKey(sum)){
                    map.put(sum, new PriorityQueue<>(Comparator.comparingInt(a-> a[1])));
                }
                PriorityQueue<Integer[]> q = map.get(sum);
                q.add(new Integer[]{nums.get(i).get(j), j});
                map.put(sum, q);
            }
        }

        int[] result = new int[size];
        int index = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer[]> > entry : map.entrySet()) {
            PriorityQueue<Integer[]> diagonal = entry.getValue();
            while (!diagonal.isEmpty()){
                result[index++] = diagonal.poll()[0];
            }
        }

        return result;
    }

}

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> que = new LinkedList<>();
        for (int i=0;i<priorities.length;i++){
            que.add(new int[]{i,priorities[i]});
        }
        int cnt=0;
        while (true){
            int[] current=que.poll();
            int loc=current[0];
            int priority=current[1];
            boolean check=true;
            for (int[] ele:que){
                if (ele[1]>priority){
                    que.add(current);
                    check=false;
                    break;
                }
            }
            if (check){
                cnt++;
                if (loc==location){
                    return cnt;
                }
            }

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{2, 1, 3, 2},2));

    }
}

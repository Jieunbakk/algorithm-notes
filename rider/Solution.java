import java.util.*;

class Solution {
    
    public int calucateHour(int N, List<int[]>[] Graph, int K){
        int[] dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        
        PriorityQueue<int[]> pq=new PriorityQueue<> ((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,1});
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int curDist=cur[0];
            int curNode=cur[1];
            
            if(curDist>dist[curNode]) continue;
            for(int[] adj:Graph[curNode]){
                int nextNode=adj[0];
                int nextDist=curDist+adj[1];
                if(nextDist<dist[nextNode]){
                    dist[nextNode]=nextDist;
                    pq.offer(new int[]{nextDist,nextNode});
                }
            }
        }
       int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        return answer;
    }
    
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        List<int[]>[] Graph= new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            Graph[i]=new ArrayList<>();
        }
        for (int[] node:road){
            int a=node[0];int b=node[1];
            int c=node[2];
            Graph[a].add(new int[]{b,c});
            Graph[b].add(new int[]{a,c});
        }
        

        return calucateHour( N, Graph, K);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.solution(5,new int[][]{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},3));
    }
}
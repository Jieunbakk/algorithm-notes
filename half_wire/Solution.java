import java.util.*;

class Solution{
    

    public int tracking(boolean[][] tree,boolean[] visited,int n,int node){
        Deque<Integer> que=new ArrayDeque<>();
        int cnt=1;
        que.offerLast(node);
        visited[node]=true;
        while(!que.isEmpty()){
            int currentNode=que.pollFirst();
            for(int i=1;i<=n;i++){
                if(tree[currentNode][i] && !visited[i]){
                    visited[i]=true;
                    que.offerLast(i);
                    cnt++;
                }
            }
        }
        return cnt;
    }



    public int solution(int n, int[][] wires){
        boolean[][] tree=new boolean[n+1][n+1];
        for (int[] wire:wires){
            int v1=wire[0],v2=wire[1];
            tree[v1][v2]=true;
            tree[v2][v1]=true;
        }
        int minValue=100000000;
        for (int[] wire:wires){
            boolean[] visited=new boolean[n+1];
            int v1=wire[0],v2=wire[1];
            tree[v1][v2]=false;
            tree[v2][v1]=false;
            int cnt1=tracking(tree, visited, n, v1);
            int cnt2=n-cnt1;
            if (Math.abs(cnt1-cnt2)<minValue){
                minValue=Math.abs(cnt1-cnt2);
            }
            tree[v1][v2]=true;
            tree[v2][v1]=true;
        }

        return minValue;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n=9;
        int[][] wires= new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(sol.solution(n, wires));
    }
}
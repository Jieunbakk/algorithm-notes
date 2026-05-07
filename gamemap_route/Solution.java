import java.util.*;

class Solution {
    
    public void bfs(int[][] maps, Node[][] nodeArray,int n, int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nodeArray[i][j] = new Node(false, new int[]{-1,-1});
            }
        }
        int[][] dirs=new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
        Deque<int[]> que = new ArrayDeque<>();
        nodeArray[0][0].visited=true;
        que.offerLast(new int[]{0,0});
        while (!que.isEmpty()){
            // for (int[] element:que){
            //     System.out.print("("+element[0]+" "+element[1]+") ");
            // }
            // System.out.println();
            int[] predecessor=que.pollFirst();
            for(int[] dir : dirs){
                int adjRow=predecessor[0]+dir[0];
                int adjCol=predecessor[1]+dir[1];
                if (0<=adjRow&& adjRow<n && 0<=adjCol && adjCol<m){
                    if (!nodeArray[adjRow][adjCol].visited && maps[adjRow][adjCol]==1){
                        nodeArray[adjRow][adjCol]=new Node(true,predecessor);
                        que.offerLast(new int[]{adjRow,adjCol});
                    }
                }
                
            }
        }
        
    }
    public void printNodeArray(Node[][] nodeArray){
        for(int i=0;i<nodeArray.length;i++){
            for (int j=0;j<nodeArray[0].length;j++){
                System.out.print("("+nodeArray[i][j].visited+" "+nodeArray[i][j].predecessor[0]+" "+nodeArray[i][j].predecessor[1]+") ");
            }
            System.out.println();
        }
    }
    
    public int backtracking(Node[][] nodeArray,int n,int m){
        int cnt=1;
        int[] predecessor=nodeArray[n][m].predecessor;
        int currentRow=n;
        int currentCol=m;
        while (predecessor[0]!=-1){
            currentRow=predecessor[0];
            currentCol=predecessor[1];
            predecessor = nodeArray[predecessor[0]][predecessor[1]].predecessor;
            cnt+=1;
        }
        if (currentCol!=0 && currentRow!=0){
            return -1;
        }
        else{
            return cnt;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        int n=maps.length;
        int m=maps[0].length;
        
        Node[][] nodeArray=new Node[n][m];
        bfs(maps,nodeArray,n,m);
        answer=backtracking(nodeArray,n-1,m-1);
        
        return answer;
    }
    
    class Node {
        boolean visited;
        int[] predecessor;
        public Node(boolean visited,int[] predecessor){
            this.visited=visited;
            this.predecessor=predecessor;
        }
    }
}
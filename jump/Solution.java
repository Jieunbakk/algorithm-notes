class Solution{

    static int[] memo;
    
    public int Memoization(int n){
        memo=new int[n+1];

        memo[0]=1;
        memo[1]=1;

       for (int i=2;i<=n;i++){
        memo[i]=((memo[i-1]%1234567)+(memo[i-2]%1234567))%1234567;
       }
       return memo[n];
    }


    public int solution(int n) {
        return Memoization(n);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4));
    }
}
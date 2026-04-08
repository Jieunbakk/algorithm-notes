class Solution {
    
    public int fibo(int n){
        if (n<2){
            return n;
        }
        int result=0;
        int f1=0;
        int f2=1;
        int mod=1234567;
        for (int i=2;i<n+1;i++){
            result=((f1%mod)+(f2%mod))%mod;
            f1=f2;
            f2=result;
        }
        return result;
    }
    
    public int solution(int n) {
        int answer = fibo(n);
        return answer;
    }


    public static void main(String[] args) {
        Solution sol=new Solution();
        System.out.println(sol.solution(1));
        System.out.println(sol.solution(5));
    }
}
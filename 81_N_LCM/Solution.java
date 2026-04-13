class Solution {
    
    public static int gcd(int a, int b){
        int tmp;
        while (b>0){
            tmp=a%b;
            a=b;
            b=tmp;
        }
        return a;
    }
    
    
    public int solution(int[] arr) {
        int answer = 0;
        int env_num=arr[0];
        for (int i=1;i<arr.length;i++){
            int now_gcd=Solution.gcd(env_num,arr[i]);
            answer=(env_num * arr[i])/now_gcd;
            env_num=answer;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr=new int[]{2, 6, 8, 14};
        System.out.println(sol.solution(arr));
    }
}

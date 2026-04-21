class Solution {
    
    public int solution(int num) {
        long answer = num;
        int maxfor=500;
        if (num==1){
            return 0;
        }
        for (int i=1;i<maxfor+1;i++){
            if (answer%2==0){
                answer=answer/2;
            }
            else{
                answer=answer*3 + 1;
            }
            if (answer==1){
                return i;
            }
        }
        
        return -1;
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        System.out.println(sol.solution(1));
    }
}
public class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n / 2; i++) {
            answer.append("수박");
        }
        if (n % 2 != 0) {
            answer.append("수");
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3)); 
        System.out.println(sol.solution(4)); 
    }
}
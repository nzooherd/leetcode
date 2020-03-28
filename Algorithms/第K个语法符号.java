class Solution {
    public int kthGrammar(int N, int K) {
        if(N == 1 && K == 1) return 0;
        int num = (int)Math.pow(2, N - 2);
        if(K <= num) {
            return kthGrammar(N - 1, K);
        } else {
            return 1 - kthGrammar(N - 1, K - num);
        }
    }
}
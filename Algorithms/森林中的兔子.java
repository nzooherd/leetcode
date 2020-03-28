class Solution {
    public int numRabbits(int[] answers){
        if(answers == null || answers.length < 1) return 0;
        Arrays.sort(answers);
        int count = 1, ret = 0;
        for(int i = 1; i < answers.length; i++){
            if(answers[i] == answers[i-1]){
                count++;
                if(count > answers[i-1] + 1){
                    ret += answers[i-1] + 1;
                    count = 1;
                }
            } else {
                ret += answers[i-1];
                ret++;
                count = 1;
            }
        }
        ret += answers[answers.length - 1];
        ret++;
        return ret;
    }
}
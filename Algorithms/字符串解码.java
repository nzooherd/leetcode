class Solution {
    public String decodeString(String s){
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ret = processMul(s.toCharArray(), 0, s.length() - 1);
        return ret.toString();
    }
    public StringBuilder processMul(char[] cs, int start, int end){
        StringBuilder ret = new StringBuilder();
        if(end < start) return ret;
        for(int i = start; i <= end; i++){
            if(!(cs[i] >= '0' && cs[i] <= '9' || cs[i] == '[' || cs[i] == ']')){
                ret.append(cs[i]);
            } else {
                int left = i, right = i, flag = 0, numStart = i, numEnd = i;
                for(int j = left; j <= end; j++){
                    if(cs[j] == '['){
                        numEnd = j;
                        flag++;
                        j++;
                        while (flag != 0) {
                            if(cs[j] == '[') flag++;
                            if(cs[j] == ']') flag--;
                            j++;
                        }
                        right = j - 1;
                        break;
                    }
                }
                int tempMul = Integer.parseInt(new String(cs, numStart, numEnd - numStart));
                StringBuilder tempString =  processMul(cs, numEnd + 1, right - 1);
                for(int j = 0; j < tempMul; j++){
                    ret.append(tempString);
                }
                i = right;
            }
        }
        return ret;
    }
}
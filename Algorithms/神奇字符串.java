class Solution {
    public int magicalString(int n) {
        char[] cs = new char[n];
        if(n <= 0) return 0;
        if(n <= 3) return 1;
        int index = 2, size = 3, ret = 1;
        cs[0] = '1';
        cs[1] = '2';
        cs[2] = '2';
        for(int i = 2; i < n && size < n; i++){
            if(cs[index] == '2'){
                cs[size] = (char)('3' - cs[size - 1] + '0');
                ret += cs[size] == '1' ? 1 : 0;
                size++;
                if(size < n) cs[size] = cs[size-1];
                else break;
                ret += cs[size] == '1' ? 1 : 0;
                size++;
            } else {
                cs[size] = (char)('3' - cs[size - 1] + '0');
                ret += cs[size] == '1' ? 1 : 0;
                size++;
            }
            index++;
        }

        return ret; 
    }
}
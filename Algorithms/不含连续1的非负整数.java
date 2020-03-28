class Solution {
    ArrayList<Integer> integers = null;

    public int findIntegers(int num){
        if(num <= 2) return num + 1;
        if(num == 3) return 3;

        int flag, ret;
        if(integers == null) {
            integers = new ArrayList<>();
            integers.add(2);
            integers.add(3);
            int i = 3, pre = 2, pos = 3;
            while (num >= (i + 1) * 2 - 1) {
                if(num == (i + 1) * 2 -1) return pre + pos;
                integers.add(pre + pos);
                int temp = pre;
                pre = pos;
                pos = pos + temp;
                i = 2 * i + 1;
            }
            flag = i;
            ret = integers.get(integers.size() - 1);
        } else {
           int i = 1, j = 0;
           while(num > (i + 1) * 2 - 1){
               i = 2 * i + 1;
               j++;
           }
           flag = i;
           ret = integers.get(j);
        }
        int newNum = Math.min(num - flag - 1, (flag + 1) / 2 - 1);
        return ret + findIntegers(newNum);
    }
}
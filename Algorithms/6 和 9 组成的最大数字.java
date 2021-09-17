class Solution {
    public int maximum69Number (int num) {
        String num_str = String.valueOf(num);
        StringBuilder res_str = new StringBuilder();
        boolean hasChange = false;
        for(int i = 0; i < num_str.length(); i++){
            if(num_str.charAt(i) == '6' && !hasChange) {
                res_str.append('9');
                hasChange = !hasChange;
            }else{
                res_str.append(num_str.charAt(i));
            }
        }
        return Integer.parseInt(res_str.toString());

    }
}
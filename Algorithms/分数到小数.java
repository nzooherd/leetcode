public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
		String ans = new String();
		if(numerator == 0) return "0";
		boolean flag = judge(numerator, denominator);
		long num = numerator, den = denominator;
		if(numerator < 0) num = num *(-1);
		if(denominator < 0) den = den *(-1);
		long temp = num / den;
		int index = 0;
		List<String> res =new LinkedList<String>();
		Map<Long,Integer> map =new HashMap<Long,Integer>();
		res.add(Long.toString(temp));
		if(num == den*temp){
		    if(!flag) res.add(0,"-");
			for(String i : res)
				ans = ans.concat(i);
			return ans;
		}
		index += 2;
		res.add(".");
		num %= den;
		while(num!= 0 && !map.containsKey(num) ) {
			map.put(num,index++);
			num *= 10;
			res.add(Long.toString(num / den));
			System.out.println(Long.toString(num/den));
			num %= den;
		}
		if(num == 0) ;
		else{
			res.add(map.get(num),"(");
			res.add(")");
		}
		if(!flag) res.add(0,"-");
		for(String i : res)
			ans = ans.concat(i);
		return ans;	
	}
	public boolean judge(int x, int y) {
		boolean flag = false;
		if(x > 0 && y > 0 || x <0 && y < 0 ) flag = true;
		return flag;	
	}
}
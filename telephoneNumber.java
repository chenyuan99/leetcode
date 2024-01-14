import java.util.*;
/*
 * Print all valid phone numbers of length n subject to following constraints: 
 * 1.If a number contains a 4, it should start with 4 
 * 2.No two consecutive digits can be same 
 * 3.Three digits (e.g. 7,2,9) will be entirely disallowed, take as input
 */

public class telephoneNumber{
	//recursive method
	public static void main(String[] args){
		generate(4);
	}

	public static void generate(int num){
		List<String> res = new ArrayList<String>();
		String digits = "0134568";
		generate(res,num,"",digits);
		for(String s:res){
			System.out.print(s+",");
		}
	}

	public static void generate(List<String> res, int num, String pre,String digits){
		if(num==0){
			res.add(pre);
			return;
		}
		for(int i=0;i<7;i++){
			if(pre.length()>0){
				if(pre.charAt(pre.length()-1) == digits.charAt(i)){
					continue;
				}
				if(digits.charAt(i) == '4' && pre.charAt(0) != '4'){
					continue;
				}
			}
			generate(res, num-1, pre + digits.charAt(i), digits);
		}
	}
}
package hao;

import java.util.HashMap;
import java.util.Map;

public class test {

	
	public static void main(String[] args) {

		Map<String, Integer> a=new HashMap<>();
		String arg="1";
		int arg0;
		arg0 = arg.hashCode();
//		arg0 ^ arg0 >>> 16;
		int aaa=hash("1");
		System.out.println(aaa);
		int arg2=arg0 >>> 16;
		System.out.println(arg2);
	}
	
	static final int hash(Object arg) {
		int arg0;
		return arg == null ? 0 : (arg0 = arg.hashCode()) ^ arg0 >>> 16;
	}
}

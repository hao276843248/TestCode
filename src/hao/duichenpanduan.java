package hao;

import java.util.HashMap;
import java.util.Map;

public class duichenpanduan {

	public static String a = "<>{}(<<>><>)";
	public static Map<String, String> map = new HashMap<>();

	public static void main(String[] args) {
		map.put("<", ">");
		map.put("{", "}");
		map.put("[", "]");
		map.put("(", ")");
		System.out.println(test(a, a));
	}

	public static boolean test(String a1, String a2) {
		for (int i = 0; i < a1.length() - 1; i++) {
			String c = a1.charAt(i + 1) + "";
			String b = map.get(a1.charAt(i) + "");
			if (c.equals(b)) {
				String a = a1.replaceFirst("\\" + a1.charAt(i) + "\\" + a1.charAt(i + 1), "");
				System.out.println("去对称前=" + a1);
				System.out.println("去对称后=" + a);
				if(a.equals("")){
					return  true;
				}else if ( !a.equals(a1) || a.length() % 2 != 0) {
					return test(a, a1);
				} 
			}
		}
		return false;
	}
}

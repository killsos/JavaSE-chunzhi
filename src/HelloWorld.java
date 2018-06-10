
public class HelloWorld {
	public static void main(String[] args) throws Exception {
		FinallyClass fc = new FinallyClass();
		fc.action();
		
		TestPackage01SubClass tpsc = new TestPackage01SubClass();
		
		tpsc.name();
		
		String s1 = "123";
		
		String s2 = new String("123");
		
		System.out.println(s1.equals(s2));
		
		System.out.println(s1 == s2);
	}
	
}

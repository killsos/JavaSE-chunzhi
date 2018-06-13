import java.util.ArrayList;

public class HelloWorld {
	public static void main(String[] args) throws Exception {
		FinallyClass fc = new FinallyClass();
		fc.action();
		
		TestPackage01SubClass tpsc = new TestPackage01SubClass();
		
		ArrayList l1 = new ArrayList();
		
		l1.add("123");
		
		l1.add(fc);
		
		System.out.println(l1);
	}
	
}

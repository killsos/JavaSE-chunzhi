
public class HelloWorld {
	public static void main(String[] args) {
		Extend3 e3 = new Extend3();
		System.out.println(e3.getClass());
		System.out.println(e3.getClass().getName());
		e3.say();
		
		InnerClass n1 = new InnerClass();
		
		n1.say();
	}
	
}

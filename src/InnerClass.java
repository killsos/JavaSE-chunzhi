
public class InnerClass {
	public void say() {
		new InterClassInterface() {
			
			@Override
			public void show() {
				System.out.println("匿名类");
				
			}
		}.show();
	}
}


public class SingletonPattern2 {

	private SingletonPattern2() {
	}
	
	private static SingletonPattern2 s = null;
	
	public static  SingletonPattern2 getInstance() {
		if (s == null) {
			synchronized (SingletonPattern2.class) {
				if (s == null) {
					s = new SingletonPattern2();
				}
			}
		}
		
		return s ;
			
	}
	
}

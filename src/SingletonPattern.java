
public class SingletonPattern {

	private SingletonPattern() {

	}
	
	private static SingletonPattern s = new SingletonPattern();
	
	public static SingletonPattern getInstance() {

		return s;
	}
	
}

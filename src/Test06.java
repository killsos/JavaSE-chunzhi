
public class Test06 {
	public void test () {
		int y = 6;
		
		while(y > 0) {
			for (int i = 0; i < 3; i++) {
				System.out.println(i);
				if (i == 3) {
					break;
				}
			}
			y--;
		}

	}
}

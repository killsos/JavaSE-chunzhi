
public class FinallyClass {
	public void action() throws Exception {
		try {
			throw new Exception("act");
		} catch (Exception e) {
			// throw e;
			return;
		} finally {
			System.out.println("finally");
		}
	}
}

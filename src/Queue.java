import java.util.LinkedList;

public class Queue {
	private LinkedList link;

	private Queue() {
		link = new LinkedList();
	}
	
	private void myadd(Object obj) {
		link.add(obj);
	}
	
	private Object myremove(Object obj) {
		return link.removeLast();
	}
	
	private boolean isNull() {
		return link.isEmpty();

	}
}

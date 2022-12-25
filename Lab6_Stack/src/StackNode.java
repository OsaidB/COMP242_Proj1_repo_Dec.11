
public class StackNode {

	Object key;
	StackNode next;

	public StackNode(Object key) {
		this.key = key;
	}

	public Object getKey() {
		return key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

//	@Override
//	public String toString() {
//		return "[" + name + "," + id + "]";
//	}

	@Override
	public String toString() {
		return "\t\t[" + key + "]";
	}

}

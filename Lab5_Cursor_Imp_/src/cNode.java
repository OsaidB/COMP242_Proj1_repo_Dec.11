
public class cNode {
	
	Object key;
	int next;
	
	public cNode(Object key,int next){
		this.key=key;
		this.next=next;
	}

	@Override
	public String toString() {
		return "\t\t["+key+"]";
	}
	
	
	
	
	
}






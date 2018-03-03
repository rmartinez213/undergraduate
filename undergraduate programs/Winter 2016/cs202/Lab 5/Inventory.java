
public class Inventory implements Comparable<Inventory> {

	@Override
	
	public int compareTo(Inventory o) {
		
		if(this.toString().compareTo(o.toString()) < 0){
			return -1;
		}
		else if(this.toString().compareTo(o.toString()) == 0){
			return 0;
		}
		else if(this.toString().compareTo(o.toString()) > 0){
			return 1;
		}
		return 0;

	}
	
}
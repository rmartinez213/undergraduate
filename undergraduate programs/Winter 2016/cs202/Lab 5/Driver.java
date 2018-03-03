import java.util.ArrayList;
import java.util.Collections;

public class Driver{
		public static void main(String[] args){
			ArrayList<Inventory> ar1=new ArrayList<Inventory>();
			ar1.add(new CD());
			ar1.add(new CA());
			ar1.add(new CD());
			ar1.add(new CA());
			ar1.add(new CD());
			ar1.add(new CA());
			Collections.sort(ar1);
			
			for(Inventory i:ar1){
				System.out.println(i);
			}
			
		}
	}


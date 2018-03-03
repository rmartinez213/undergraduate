
import java.util.ArrayList;

//This class does the sorting for heap sort
public class Heap <E extends Comparable<E>>{
	ArrayList<E> list = new ArrayList<>();
	
	public Heap(){

	}

	public Heap(E[] obj){
		for(int i= 0; i < obj.length ; i++){
			add(obj[i]);
		}
	}
	
	public void add (E newObj){
		list.add(newObj);
		int CIndex = list.size() - 1;
		
		//Swaps if the current number is greater than parent...
		while(CIndex > 0){
			int PIndex = (CIndex - 1) / 2;
			if(list.get(CIndex).compareTo(list.get(PIndex)) > 0){
				E temp = list.get(CIndex);
				list.set(CIndex, list.get(PIndex));
				list.set(PIndex, temp);
			}
			else{
				break;
			}
			
			CIndex = PIndex;
		}
	}
	
	public E remove(){
		if(list.size() == 0)
			return null;
		
		E RemObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int CIndex = 0;
		while(CIndex < list.size()){
			
			int LChildIndex = 2 * CIndex + 1;
			int RChildIndex = 2 * CIndex + 2;
			if(LChildIndex >= list.size())
				break;
			int MIndex = LChildIndex;
			if(list.get(MIndex).compareTo(list.get(MIndex)) < 0){
				E temp = list.get(MIndex);
				list.set(MIndex, list.get(CIndex));
				list.set(CIndex, temp);
			}
			else{
				break;
			}
		}
		return RemObject;
	}
}

package RR;

import java.util.ArrayList;
import java.util.LinkedHashMap;

class Stack<T1, T2, T3> implements StackInterface<T1, T2, T3> {
	private LinkedHashMap<T1, T2> date = new LinkedHashMap<>();
	private ArrayList<T3> results = new ArrayList<>();
	private int maxRunners;
	int counter = 0;
	
	Stack(LinkedHashMap<T1, T2> d, int aR, ArrayList<T3> r){
		date = d;
		maxRunners = aR;
		results = r;
	}

	public void push(T1 obj1, T2 obj2) throws StackFullException {
		if(date.size() == maxRunners)
			throw new StackFullException(maxRunners);
		date.put(obj1, obj2);
		counter++;
	}

	public T3 pop() throws StackEmptyException {
		if(results.isEmpty())
			throw new StackEmptyException();
		counter--;
		return results.get(counter);
	}

}

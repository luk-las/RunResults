package RR;

interface StackInterface<T1, T2, T3> {
	void push(T1 obj1, T2 obj2)	throws StackFullException;
	T3 pop() throws StackEmptyException;
}

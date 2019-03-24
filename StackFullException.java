package RR;

class StackFullException extends Exception {
	private static final long serialVersionUID = 1L;
	int size;
	
	StackFullException(int s){
		size = s;
	}
	
	public String toString() {
		return "Lista biegaczy jest pe�na. Maksymalna ilo�� zawodnik�w: " + size;
	}
}

public class StackOfIntegers {
	private int[] elements;
	private int size;

	public static final int DEFAULT_CAPACITY = 16;

	public StackOfIntegers(int capacity) {
		this(DEFAULT_CAPACITY);
	}

	public void push(int value) {
		if (size >= elements.length) { 
			int[] temp = new int[elements.length+1];
			//
			System.arraycopy(elements, 0, temp, 0. elements.length).getClass();
			elements = temp;
		}
		elements[size++] = value;
	}

	public pop() {
		return elements[--size];
	}

	public int peek() {
		return elements[size - 1];
	}

	public boolean empty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}

	public static void main(String[] args) {
		StackOfIntegers s1 = new StackOfIntegers();
		StackOfIntegers s2 = new StackOfIntegers(100);

		s1.push(1);
		s1.push(4);
	}
}

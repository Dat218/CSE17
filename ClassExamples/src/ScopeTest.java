public class ScopeTest {
	private int x = 10;
	private int y = 0;
	
	public void p() { 
		System.out.println("p:x = " + x);
		char x = 'A';
		System.out.println("p:x = " + x);
		System.out.println("p:y = " + y);
	}
	
	public static void main(String[] args) {
		ScopeTest st = new ScopeTest();
		st.p();
		System.out.println();
		System.out.println("main:x = " + st.x);
		System.out.println("main:y = " + st.y);
	}
}

package tables;

public class StringFormatTest {
	
	
	public static void main(String[] args) {
		String str = String.format("//table//tbody/tr[%s]//a", "2");
		System.out.println(str);
	}

}

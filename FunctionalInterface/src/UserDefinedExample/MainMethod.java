package UserDefinedExample;

public class MainMethod {

	public static void main(String[] args) {
		Greetings greet = (str) -> {
			String s = str.toLowerCase().concat(" Welcome");
			System.out.println(s);
			int length = s.length();
			System.out.println(length);
		};
		Greetings.hello();
		greet.hi("Hello");
		greet.welcome();
	}
}

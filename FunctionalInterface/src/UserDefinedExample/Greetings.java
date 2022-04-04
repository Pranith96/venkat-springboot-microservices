package UserDefinedExample;

@FunctionalInterface
public interface Greetings {
	public void hi(String message);
	
	public static void hello() {
		System.out.println("hello");
	}
	
	default void welcome() {
		System.out.println("welcome");
	}
}

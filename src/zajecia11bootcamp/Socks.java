package zajecia11bootcamp;

public class Socks implements Wear {
	
	@Override
	public void put() {
		System.out.println("on feet");
	}
	
//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("Nick: " + nick + "\n");
//		sb.append("\tTag: " + tag + "\n");
//		sb.append("\tGry: " + Arrays.toString(gry));
//		return sb.toString();
//	}
}

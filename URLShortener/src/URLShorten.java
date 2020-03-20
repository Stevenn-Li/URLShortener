import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class URLShorten {
	HashMap<String, String> hs;
	private final String ALPHA_NUMERIC_String = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	public URLShorten() {
		hs = new HashMap<String, String>();
	}
	
	public boolean shorten(String original, String result) {
		
		if (hs.containsKey(result)) {
			return false;
		}
		else {
			hs.put(result, original);
			return true;
		}
	}
	
	public String getURL(String result) {
		if (!hs.containsKey(result)) {
			return "This is not a valid shortened URL!";
		}
		else {
			return hs.get(result);
		}
	}
	
	public String generateURL() {
		StringBuilder sb = new StringBuilder();
		sb.append("steven.cc/");
		Random rand = new Random();
		for (int i = 0; i < 6; i++) {
			int r = rand.nextInt(ALPHA_NUMERIC_String.length());
			sb.append(Character.toString(ALPHA_NUMERIC_String.charAt(r)));
		}
		return sb.toString();
	}
	
	public void shortenURL() {
		URLShorten urlDB = new URLShorten(); 
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the URL you wish to shorten: ");
		String original = sc.nextLine();		
		System.out.println("Please enter the shortened link. i.e steven.cc/ or type generate for a random link : ");
		String result = sc.nextLine();
		while (!result.startsWith("steven.cc/") || !result.matches("[A-Za-z0-9./]*")) {
			if (result.equals("generate")) {
				result = urlDB.generateURL();
				break;
			}
			System.out.println("Please enter the shortened link starting with steven.cc/ : ");
			result = sc.nextLine();
		}
		boolean b = urlDB.shorten(original, result);
		if (b) {
			System.out.println("URL: (" + original + ") has been shortened to: (" + result + ").");
		}
		else {
			System.out.println("Attempted URL to be shortened to has already been used");
		} 
		System.out.println(urlDB.getURL(result));
		sc.close();
	}
	
	public static void main(String[] args) {
		URLShorten urlDB = new URLShorten(); 
		urlDB.shortenURL();
	}
}

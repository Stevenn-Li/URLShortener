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
		while (!(original.matches("[A-Za-z0-9./]*"))) {
			System.out.println("Please type only alphanumeric letters.");
			original = sc.nextLine();
		}
		System.out.println("Please enter the shortened link. i.e steven.cc/ or type generate for a random link : ");
		String result = sc.nextLine(); /*
		while ((!result.startsWith("steven.cc/"))) {
			if (result.equals("generate")) {
				result = urlDB.generateURL();
				break;
			}
			System.out.println("Please enter the shortened link starting with steven.cc/ : ");
			result = sc.nextLine();
			while (!result.substring(10).matches("[A-Za-z0-9./]*")) {
				System.out.println("Please type only alphanumeric letters after steven.cc/");
				result = sc.nextLine();
			}
		} */
		/*
		 * 3 possible cases:
		 * -starts with steven.cc/
		 * -string is generate
		 * -string after steven.cc doesn't contain just alphanumeric characters
		 */
		
		while ( (!result.startsWith("steven.cc/") && !result.equals("generate")) || !result.matches("[A-Za-z0-9./]*") ) {
			System.out.println("Please enter the shortened link starting with steven.cc/, type generate for a random link and or use only alphanumeric characters along with (. and / ). ");
			result = sc.nextLine();
		}		
		if (result.equals("generate")) {
			result = urlDB.generateURL();
		} /*
		if (result.startsWith("steven.cc/") && result.matches("[A-Za-z0-9./]*")) {
			result = urlDB.generateURL();
		} */
		boolean b = urlDB.shorten(original, result);
		
		if (b) {
			System.out.println("URL: (" + original + ") has been shortened to: (" + result + ").");
		}
		else {
			System.out.println("Attempted URL to be shortened to has already been used");
		} 
		//System.out.println(urlDB.getURL(result));
		sc.close();
	}
	
	public static void main(String[] args) {
		URLShorten urlDB = new URLShorten(); 
		urlDB.shortenURL();
	}
}

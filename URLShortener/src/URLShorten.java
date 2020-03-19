import java.util.HashMap;
import java.util.Scanner;

public class URLShorten {
	HashMap<String, String> hs;
	
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
	
	public void shortenURL() {
		URLShorten urlDB = new URLShorten(); 
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the URL you wish to shorten: ");
		String original = sc.nextLine();		
		System.out.println("Please enter the shortened link. i.e steven.cc/ : ");
		String result = sc.nextLine();
		while (!result.startsWith("steven.cc/")) {
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
		sc.close();
	}
	
	public static void main(String[] args) {
		URLShorten urlDB = new URLShorten(); 
		urlDB.shortenURL();
	}
}

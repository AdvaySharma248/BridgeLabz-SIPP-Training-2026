import java.util.Scanner;
import java.util.HashMap;

class TinyURL {
    HashMap<String, String> urlMap;
    int counter;

    TinyURL() {
        urlMap = new HashMap<>();
        counter = 0;
    }

    String encode(String longUrl) {
        counter++;
        String shortUrl = "http://tinyurl.com/" + counter;
        urlMap.put(shortUrl, longUrl);
        return shortUrl;
    }

    String decode(String shortUrl) {
        return urlMap.get(shortUrl);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TinyURL tiny = new TinyURL();

        String url1 = "https://www.google.com/search?q=java";
        String url2 = "https://leetcode.com/problems/design-tinyurl";
        String url3 = "https://github.com/explore";

        String short1 = tiny.encode(url1);
        String short2 = tiny.encode(url2);
        String short3 = tiny.encode(url3);

        System.out.println("Encoded: " + short1);
        System.out.println("Decoded: " + tiny.decode(short1));

        System.out.println("Encoded: " + short2);
        System.out.println("Decoded: " + tiny.decode(short2));

        System.out.println("Encoded: " + short3);
        System.out.println("Decoded: " + tiny.decode(short3));

        sc.close();
    }
}

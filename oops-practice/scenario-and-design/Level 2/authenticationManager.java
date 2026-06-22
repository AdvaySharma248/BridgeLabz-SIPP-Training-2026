import java.util.Scanner;
import java.util.HashMap;

class AuthenticationManager {
    int timeToLive;
    HashMap<String, Integer> tokens;

    AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        tokens = new HashMap<>();
    }

    void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + timeToLive);
        System.out.println("Token " + tokenId + " generated, expires at " + (currentTime + timeToLive));
    }

    void renew(String tokenId, int currentTime) {
        if (tokens.containsKey(tokenId) && tokens.get(tokenId) > currentTime) {
            tokens.put(tokenId, currentTime + timeToLive);
            System.out.println("Token " + tokenId + " renewed, new expiry " + (currentTime + timeToLive));
        } else {
            System.out.println("Token " + tokenId + " cannot be renewed");
        }
    }

    int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (String key : tokens.keySet()) {
            if (tokens.get(key) > currentTime) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        AuthenticationManager am = new AuthenticationManager(5);

        am.generate("token1", 1);
        am.generate("token2", 2);
        am.generate("token3", 3);

        System.out.println("Unexpired at 4: " + am.countUnexpiredTokens(4));

        am.renew("token1", 4);
        am.renew("token2", 8);

        System.out.println("Unexpired at 7: " + am.countUnexpiredTokens(7));
        System.out.println("Unexpired at 9: " + am.countUnexpiredTokens(9));

        sc.close();
    }
}

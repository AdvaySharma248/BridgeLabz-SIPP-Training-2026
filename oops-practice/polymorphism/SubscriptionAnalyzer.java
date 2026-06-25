package polymorphism;

class Subscription {
    String subscriberName;
    String subscriptionId;

    public Subscription(String subscriberName, String subscriptionId) {
        this.subscriberName = subscriberName;
        this.subscriptionId = subscriptionId;
    }

    public double calculateMonthlyCharge() {
        return 0.0;
    }

    public void display() {
        System.out.println("ID: " + subscriptionId + " | Name: " + subscriberName);
    }
}

class BasicPlan extends Subscription {
    public BasicPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 9.99;
    }
}

class PremiumPlan extends Subscription {
    public PremiumPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 15.99;
    }
}

class FamilyPlan extends Subscription {
    public FamilyPlan(String subscriberName, String subscriptionId) {
        super(subscriberName, subscriptionId);
    }

    @Override
    public double calculateMonthlyCharge() {
        return 19.99;
    }
}

public class SubscriptionAnalyzer {

    // Requirement 2: search by subscription ID
    public static void searchById(Subscription[] subs, String id) {
        boolean found = false;
        for (Subscription s : subs) {
            if (s.subscriptionId.equalsIgnoreCase(id)) {
                System.out.print("Subscription Found: ");
                s.display();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Subscription ID " + id + " not found.");
    }

    // Requirement 2: display all subscribers whose names start with a particular letter
    public static void displayByPrefix(Subscription[] subs, char letter) {
        System.out.println("--- Subscribers starting with '" + letter + "' ---");
        boolean found = false;
        for (Subscription s : subs) {
            if (s.subscriberName.toUpperCase().startsWith(String.valueOf(letter).toUpperCase())) {
                s.display();
                found = true;
            }
        }
        if (!found) System.out.println("No subscribers found starting with " + letter);
    }

    // Requirement 2: calculate total monthly revenue
    public static double calculateTotalRevenue(Subscription[] subs) {
        double total = 0;
        for (Subscription s : subs) {
            total += s.calculateMonthlyCharge();
        }
        return total;
    }

    public static void main(String[] args) {
        // Requirement 1: Store subscriptions in a Subscription[] array
        Subscription[] subscriptions = new Subscription[4];
        subscriptions[0] = new BasicPlan("Alice", "SUB001");
        subscriptions[1] = new PremiumPlan("Bob", "SUB002");
        subscriptions[2] = new FamilyPlan("Charlie", "SUB003");
        subscriptions[3] = new PremiumPlan("David", "SUB004");

        // Requirement 3: Use polymorphism for billing
        System.out.println("--- Monthly Billing Details ---");
        for (Subscription s : subscriptions) {
            System.out.println(s.subscriberName + " (" + s.subscriptionId + ") Charge: $" + s.calculateMonthlyCharge());
        }

        // Search by ID
        System.out.println("\n--- Searching for ID: SUB003 ---");
        searchById(subscriptions, "SUB003");

        // Display by prefix
        System.out.println();
        displayByPrefix(subscriptions, 'A');

        // Total Revenue
        System.out.println("\nTotal Monthly Revenue: $" + calculateTotalRevenue(subscriptions));

        // Requirement 4: Identify the most expensive subscription
        Subscription maxSub = subscriptions[0];
        for (Subscription s : subscriptions) {
            if (s.calculateMonthlyCharge() > maxSub.calculateMonthlyCharge()) {
                maxSub = s;
            }
        }
        System.out.println("\n--- Most Expensive Subscription ---");
        maxSub.display();
        System.out.println("Monthly Cost: $" + maxSub.calculateMonthlyCharge());
    }
}

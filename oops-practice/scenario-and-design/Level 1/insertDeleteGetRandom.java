import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    Random rand;

    RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        map.put(lastElement, index);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }

    void display() {
        System.out.print("Set: [");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        RandomizedSet rs = new RandomizedSet();

        System.out.println("Insert 1: " + rs.insert(1));
        System.out.println("Insert 2: " + rs.insert(2));
        System.out.println("Insert 3: " + rs.insert(3));
        rs.display();

        System.out.println("Remove 2: " + rs.remove(2));
        rs.display();

        System.out.println("Insert 2: " + rs.insert(2));
        rs.display();

        System.out.println("Random: " + rs.getRandom());
        System.out.println("Random: " + rs.getRandom());
        System.out.println("Random: " + rs.getRandom());

        sc.close();
    }
}

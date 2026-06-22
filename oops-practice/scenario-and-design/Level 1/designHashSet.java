import java.util.Scanner;
import java.util.ArrayList;

class MyHashSet {
    ArrayList<Integer> set;

    MyHashSet() {
        set = new ArrayList<>();
    }

    void add(int key) {
        if (!set.contains(key)) {
            set.add(key);
        }
    }

    void remove(int key) {
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) == key) {
                set.remove(i);
                break;
            }
        }
    }

    boolean contains(int key) {
        for (int i = 0; i < set.size(); i++) {
            if (set.get(i) == key) {
                return true;
            }
        }
        return false;
    }

    void display() {
        System.out.print("HashSet: [");
        for (int i = 0; i < set.size(); i++) {
            System.out.print(set.get(i));
            if (i < set.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyHashSet hs = new MyHashSet();

        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.display();

        System.out.println("Contains 2: " + hs.contains(2));
        System.out.println("Contains 5: " + hs.contains(5));

        hs.remove(2);
        hs.display();
        System.out.println("Contains 2 after remove: " + hs.contains(2));

        hs.add(2);
        hs.add(2);
        hs.display();

        sc.close();
    }
}

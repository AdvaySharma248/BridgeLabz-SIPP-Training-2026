import java.util.Scanner;
import java.util.ArrayList;

class MyHashMap {
    ArrayList<Integer> keys;
    ArrayList<Integer> values;

    MyHashMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    void put(int key, int value) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) == key) {
                values.set(i, value);
                return;
            }
        }
        keys.add(key);
        values.add(value);
    }

    int get(int key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) == key) {
                return values.get(i);
            }
        }
        return -1;
    }

    void remove(int key) {
        for (int i = 0; i < keys.size(); i++) {
            if (keys.get(i) == key) {
                keys.remove(i);
                values.remove(i);
                return;
            }
        }
    }

    void display() {
        System.out.print("HashMap: {");
        for (int i = 0; i < keys.size(); i++) {
            System.out.print(keys.get(i) + "=" + values.get(i));
            if (i < keys.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyHashMap map = new MyHashMap();

        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);
        map.display();

        System.out.println("Get key 2: " + map.get(2));
        System.out.println("Get key 5: " + map.get(5));

        map.put(2, 250);
        map.display();

        map.remove(2);
        map.display();
        System.out.println("Get key 2 after remove: " + map.get(2));

        sc.close();
    }
}

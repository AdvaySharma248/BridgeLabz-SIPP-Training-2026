import java.util.Scanner;

class OrderedStream {
    String[] stream;
    boolean[] filled;
    int ptr;
    int size;

    OrderedStream(int n) {
        stream = new String[n + 1];
        filled = new boolean[n + 1];
        ptr = 1;
        size = n;
    }

    String[] insert(int idKey, String value) {
        stream[idKey] = value;
        filled[idKey] = true;

        int count = 0;
        int start = ptr;
        while (ptr <= size && filled[ptr]) {
            ptr++;
            count++;
        }

        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            result[i] = stream[start + i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        OrderedStream os = new OrderedStream(5);

        String[] r1 = os.insert(3, "ccc");
        System.out.print("Insert 3: [");
        for (int i = 0; i < r1.length; i++) {
            System.out.print(r1[i]);
        }
        System.out.println("]");

        String[] r2 = os.insert(1, "aaa");
        System.out.print("Insert 1: [");
        for (int i = 0; i < r2.length; i++) {
            System.out.print(r2[i] + " ");
        }
        System.out.println("]");

        String[] r3 = os.insert(2, "bbb");
        System.out.print("Insert 2: [");
        for (int i = 0; i < r3.length; i++) {
            System.out.print(r3[i] + " ");
        }
        System.out.println("]");

        String[] r4 = os.insert(5, "eee");
        System.out.print("Insert 5: [");
        for (int i = 0; i < r4.length; i++) {
            System.out.print(r4[i]);
        }
        System.out.println("]");

        String[] r5 = os.insert(4, "ddd");
        System.out.print("Insert 4: [");
        for (int i = 0; i < r5.length; i++) {
            System.out.print(r5[i] + " ");
        }
        System.out.println("]");

        sc.close();
    }
}

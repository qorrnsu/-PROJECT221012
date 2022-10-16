import java.util.*;

public class Customer {
    HashMap<String, Integer> map = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Customer man = new Customer();
        man.run();
    }

    public Customer() { }

    public void run() {
        System.out.println("** 포인트 관리 프로그램입니다 **");

        while(true) {
            System.out.print("이름과 포인트 입력>> ");
            String name = scanner.next();
            if(name.equals("그만"))
                break;
            int point = scanner.nextInt();

            Integer n = map.get(name);
            if(n != null) {
                point += n;
            }

            map.put(name, point);
            printAll();
        }
    }

    void printAll() {
        Set<String> keys = map.keySet();

        for (String name : keys) {
            int point = map.get(name);
            System.out.print("(" + name + "," + point + ")");
        }
        System.out.println();
    }

}


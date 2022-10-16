import java.util.Scanner;
import java.util.Vector;

public class GraphicEditor {
    private final String editorName;
    private final Scanner scanner = new Scanner(System.in);
    private final Vector<Shape> v = new Vector<>();

    public static void main(String [] args) {
        GraphicEditor ge = new GraphicEditor("beauty");
        ge.run();
    }

    public GraphicEditor(String editorName) {
        this.editorName = editorName;
    }

    public void run() {
        System.out.println("그래픽 에디터 " + editorName + "를 실행합니다.");
        int choice = 0;

        while (choice != 4) {
            int type, index;
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3)>>");
                    type = scanner.nextInt();
                    if (type < 1 || type > 3) {
                        System.out.println("잘못 선택하셨습니다.");
                        break;
                    }
                    insert(type);
                    break;
                case 2:
                    System.out.print("삭제할 도형의 위치>>");
                    index = scanner.nextInt();
                    if (!delete(index)) {
                        System.out.println("삭제할 수 없습니다.");
                    }
                    break;
                case 3:
                    view();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
        System.out.println(editorName + "을 종료합니다.");
    }

    private void view() {
        for (Shape shape : v) shape.draw();
    }

    private boolean delete(int index) {
        if (v.size() == 0 || index >= v.size())
            return false;
        v.remove(index);
        return true;
    }

    private void insert(int choice) {
        Shape shape = switch (choice) {
            case 1 -> // Line
                    new Line();
            case 2 -> // Rect
                    new Rect();
            case 3 -> // Circle
                    new Circle();
            default -> null;
        };
        v.add(shape);
    }
}



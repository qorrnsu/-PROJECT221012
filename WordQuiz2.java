import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

class Word2 {
    private final String english;
    private final String korean;

    public String getEnglish() { return english; }
    public String getKorean() { return korean; }
    public Word2(String english, String korean) {
        this.english = english;
        this.korean = korean;
    }
}

public class WordQuiz2 {
    private final String name;
    private final Scanner scanner = new Scanner(System.in);
    private final Vector<Word2> v;

    public static void main(String[] args) {
        WordQuiz2 quiz = new WordQuiz2("명품영어");
        quiz.run();
    }

    public WordQuiz2(String name) {
        this.name = name;
        v = new Vector<>();
        v.add(new Word2("love", "사랑"));
        v.add(new Word2("animal", "동물"));
        v.add(new Word2("emotion", "감정"));
        v.add(new Word2("human", "인간"));
        v.add(new Word2("stock", "주식"));
        v.add(new Word2("trade", "거래"));
        v.add(new Word2("society", "사회"));
        v.add(new Word2("baby", "아기"));
        v.add(new Word2("honey", "애인"));
        v.add(new Word2("doll", "인형"));
        v.add(new Word2("bear", "곰"));
        v.add(new Word2("picture", "사진"));
        v.add(new Word2("painting", "그림"));
        v.add(new Word2("error", "오류"));
        v.add(new Word2("example", "보기"));
        v.add(new Word2("eye", "눈"));
        v.add(new Word2("statue", "조각상"));
    }

    private int makeExample(int[] ex, int answerIndex) {
        int[] n = {-1, -1, -1, -1};
        int index;
        for(int i=0; i<n.length; i++) {
            do {
                index = (int)(Math.random()*v.size());
            } while(index == answerIndex || exists(n, index)); // 다시 시도
            n[i] = index;
        }

        System.arraycopy(n, 0, ex, 0, n.length);
        return (int)(Math.random()*n.length);
    }

    private boolean exists(int[] n, int index) {
        for (int j : n) {
            if (j == index)
                return true;
        }
        return false;
    }

    public void run() {
        System.out.println("**** 영어 단어 테스트 프로그램 \"" + name + "\" 입니다. ****");
        while(true) {
            System.out.print("단어 테스트:1, 단어 삽입:2. 종료:3>> ");
            try {
                int menu = scanner.nextInt();
                switch (menu) {
                    case 1 -> wordQuiz();
                    case 2 -> insertWords();
                    case 3 -> {
                        finish();
                        return;
                    }
                    default -> System.out.println("잘못 입력하였습니다.");
                }
            }
            catch(InputMismatchException e) {
                scanner.next();
                System.out.println("숫자를 입력하세요 !!");
            }
            System.out.println();
        }
    }

    private void insertWords() {
        System.out.println("영어 단어에 그만을 입력하면 입력을 종료합니다.");
        while(true) {
            System.out.print("영어 한글 입력 >> ");

            String engWord = scanner.next();
            if(engWord.equals("그만"))
                break;

            String korWord = scanner.next();
            v.add(new Word2(engWord, korWord));
        }
    }

    private void finish() {
        System.out.println("\"" + name + "\"를 종료합니다.");
        scanner.close();
    }

    private void wordQuiz() {
        System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다. -1을 입력하면 테스트를 종료합니다.");
        while(true) {
            int answerIndex = (int)(Math.random()*v.size());
            String eng = v.get(answerIndex).getEnglish();

            int[] example = new int [4];

            int answerLoc = makeExample(example, answerIndex);
            example[answerLoc] = answerIndex;

            System.out.println(eng + "?");

            for(int i=0; i<example.length; i++)
                System.out.print("(" + (i+1) + ")" + v.get(example[i]).getKorean() + " ");

            System.out.print(":>");
            try {
                int in = scanner.nextInt();
                if(in == -1)
                    break;
                in--;
                if(in == answerLoc)
                    System.out.println("Excellent !!");
                else
                    System.out.println("No. !!");
            }
            catch(InputMismatchException e) {
                scanner.next();
                System.out.println("숫자를 입력하세요 !!");
            }
        }
    }
}


import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class Word {
    private String eng;
    private String kor;

    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }
    public String getEng() { return eng; }
    public String getKor() { return kor; }
}

public class WordQuiz {
    Scanner scan = new Scanner(System.in);
    Vector<Word> v = new Vector<>();
    Random rand = new Random();
    final int MAX_CHOICE = 4;
    int[] question = new int[MAX_CHOICE];

    public static void main(String[] args) {
        new WordQuiz();
    }

    public WordQuiz() {
        setVector();
        System.out.println("Java 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");
        game();
    }

    public void game() {
        while(true) {
            setChoice();
            int answerNum = rand.nextInt(4);
            int answerIndex = question[answerNum];

            System.out.println(v.get(answerIndex).getEng() + "?");

            for(int i=0; i<question.length; i++) {
                System.out.print("(" + (i+1) + ")");
                System.out.print(v.get(question[i]).getKor() + " ");
            }
            System.out.print(">> ");

            int choice = scan.nextInt();
            if(choice == -1) {
                System.out.println("명품영어를 종료합니다...");
                break;
            }
            else if(choice-1 == answerNum) {
                System.out.println("Excellent !!");
            } else {
                System.out.println("No. !!");
            }
        }
    }

    public void setChoice() {
        for(int i=0; i<MAX_CHOICE; i++) {
            question[i] = rand.nextInt(v.size());
            for(int j=0; j<i; j++) {
                if(question[i] == question[j]) {
                    i--;
                    continue;
                }
            }
        }
    }

    public void setVector() {
        v.add(new Word("love", "사랑"));
        v.add(new Word("animal", "동물"));
        v.add(new Word("picture", "그림"));
        v.add(new Word("emotion", "감정"));
        v.add(new Word("baby", "아기"));
        v.add(new Word("error", "오류"));
        v.add(new Word("society", "사회"));
        v.add(new Word("doll", "인형"));
        v.add(new Word("bear", "곰"));
        v.add(new Word("example", "보기"));
        v.add(new Word("deal", "거래"));
        v.add(new Word("photo", "사진"));
        v.add(new Word("human", "인간"));
        v.add(new Word("statue", "조각상"));
        v.add(new Word("eye", "눈"));
        v.add(new Word("hand", "손"));
        v.add(new Word("ant", "개미"));
    }
}




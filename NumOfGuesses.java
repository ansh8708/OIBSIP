import java.util.Scanner;
/*
Name -Ansh Agrawal
Task 2 - Number Guessing Game
*/
import java.util.Random;
import java.util.Scanner;

class Game {
    Random rand = new Random();
    private int compNo, inp;
    private int noOf = 10;

    public Game() {
        compNo = rand.nextInt(100);
    }

    public void takeUserInput(int inpu) {
        this.inp = inpu;
    }

    public String isCorrectNumber() {
        return "your choice is correct";
    }

    public void noOfGuesses() {

        if (inp == compNo) {
            System.out.println(isCorrectNumber());
            System.out.println("Your Final Score is: "+noOf+"/10");
        } else if (inp > compNo) {
            System.out.println("The number you have guessed is smaller than expected Number");
            System.out.println("remaining Chances left: " +(noOf - 1));
            noOf--;
        } else {
            System.out.println("The number you have guessed is greater than expected Number");
            System.out.println("remaining Chances left: "+ (noOf - 1));
            noOf--;
        }

    }

}

public class NumOfGuesses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game g = new Game();
        System.out.println("Now we will a fun game Guess the Number");
        System.out.println("you will get 10 chances to guess the number ");
        for (int i = 0; i < 10; i++) {
            int choice = sc.nextInt();
            g.takeUserInput(choice);
            g.noOfGuesses();
        }

    }
}
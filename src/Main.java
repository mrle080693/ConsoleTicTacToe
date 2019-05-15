import java.util.Scanner;

public class Main {
    // Array for our cells
    private String[] fieldArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    // Entry point for the program
    public static void main(String[] args) {
        // User greeting
        System.out.println("Hello my friend!");
        System.out.println("Enter the number of the move and press the Enter key");
        // Create object of class Main for start and draw field
        Main main = new Main();
        main.drawField();
        // Get data from user
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; main.endOfGame() == false; i++) {
            String userMove = scanner.next();
            main.move(userMove);
        }
    }

    private void drawField() {
        // Draw 1st row
        System.out.println();
        for (int i = 0; i <= 2; i++) {
            System.out.print(fieldArr[i] + " ");
        }
        // Draw 2nd row
        System.out.println();
        for (int i = 3; i <= 5; i++) {
            System.out.print(fieldArr[i] + " ");
        }
        // Draw 3d row
        System.out.println();
        for (int i = 6; i <= 8; i++) {
            System.out.print(fieldArr[i] + " ");
        }
        // To have a place for drawing next changes on our field
        System.out.println();
    }


    private boolean endOfGame(){
        boolean end = false;
        // All combinations to win
        if (fieldArr[0].equals("X") && fieldArr[1].equals("X") && fieldArr[2].equals("X") ||
                fieldArr[3].equals("X") && fieldArr[4].equals("X") && fieldArr[5].equals("X") ||
                fieldArr[6].equals("X") && fieldArr[7].equals("X") && fieldArr[8].equals("X") ||
                fieldArr[0].equals("X") && fieldArr[3].equals("X") && fieldArr[6].equals("X") ||
                fieldArr[1].equals("X") && fieldArr[4].equals("X") && fieldArr[7].equals("X") ||
                fieldArr[2].equals("X") && fieldArr[5].equals("X") && fieldArr[8].equals("X") ||
                fieldArr[0].equals("X") && fieldArr[4].equals("X") && fieldArr[8].equals("X") ||
                fieldArr[2].equals("X") && fieldArr[4].equals("X") && fieldArr[6].equals("X") ) {
            System.out.println("You are the champion! ;)");
            end = true;
        }

        // All combinations to lose
        if (fieldArr[0].equals("O") && fieldArr[1].equals("O") && fieldArr[2].equals("O") ||
                fieldArr[3].equals("O") && fieldArr[4].equals("O") && fieldArr[5].equals("O") ||
                fieldArr[6].equals("O") && fieldArr[7].equals("O") && fieldArr[8].equals("O") ||
                fieldArr[0].equals("O") && fieldArr[3].equals("O") && fieldArr[6].equals("O") ||
                fieldArr[1].equals("O") && fieldArr[4].equals("O") && fieldArr[7].equals("O") ||
                fieldArr[2].equals("O") && fieldArr[5].equals("O") && fieldArr[8].equals("O") ||
                fieldArr[0].equals("O") && fieldArr[4].equals("O") && fieldArr[8].equals("O") ||
                fieldArr[2].equals("O") && fieldArr[4].equals("O") && fieldArr[6].equals("O") ) {
            System.out.println("You lost. I thought it is not possible");
            end = true;
            // If nobody won
        } else {
            if(end == false && (fieldArr[0].equals("X") || fieldArr[0].equals("O") ) &&
                    (fieldArr[1].equals("X") || fieldArr[1].equals("O") ) &&
                    (fieldArr[2].equals("X") || fieldArr[2].equals("O") ) &&
                    (fieldArr[3].equals("X") || fieldArr[3].equals("O") ) &&
                    (fieldArr[4].equals("X") || fieldArr[4].equals("O") ) &&
                    (fieldArr[5].equals("X") || fieldArr[5].equals("O") ) &&
                    (fieldArr[6].equals("X") || fieldArr[6].equals("O") ) &&
                    (fieldArr[7].equals("X") || fieldArr[7].equals("O") ) &&
                    (fieldArr[8].equals("X") || fieldArr[8].equals("O") )) {
                System.out.println("Nobody won!!!");
            }
        }
        return end;
    }

    private void move(String a){
        // Human move
        for(int i = 0; i < fieldArr.length; i++){
            if(a.equals(fieldArr[i]) && (fieldArr[i].equals("X")) || (fieldArr[i].equals("O"))) {
                System.out.println("The slot is taken!!!");
                drawField();

            }
            if(a.equals(fieldArr[i]) && !(fieldArr[i].equals("X")) && !(fieldArr[i].equals("O"))) {
                fieldArr[i] = "X";
                // Computer move
                for ( i = 0; i < fieldArr.length; i++){
                    String computerMove = (String.valueOf(i +1));
                    if(fieldArr[i].equals(computerMove) && !(fieldArr[i].equals("X")) && !(fieldArr[i].equals("O"))){
                        fieldArr[i] = "O";
                        drawField();
                        break;
                    }
                }
            }
        }
    }
}





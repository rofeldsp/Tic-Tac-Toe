package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String str = "_________";
        printField(str);
        int switcher = 0;
        while (true) {
            switch (switcher % 2) {
                case 0:
                    str = makeMove(str, 'X');
                    printField(str);
                    break;
                case 1:
                    str = makeMove(str, 'O');
                    printField(str);
                    break;
            }
            switcher++;
            int x = 0;
            int o = 0;
            int count_empty = 0;
            for (int i = 0; i < 9; i++) {
                if (str.charAt(i) == 'X')
                    x++;
                else if (str.charAt(i) == 'O')
                    o++;
                else
                    count_empty++;
            }
//        if (x - o >= 2 || o - x >= 2) {
//            System.out.println("Impossible");
//            return;
//        }
//
            int check_3_X = 0;
            int check_3_O = 0;
            check_3_O = CheckThree('O', str);
            check_3_X = CheckThree('X', str);
//        if (check_3_O + check_3_X == 2) {
//            System.out.println("Impossible");
//            return;
//        }
//        if (check_3_O + check_3_X == 0 && count_empty != 0) {
//            System.out.println("Game not finished");
//            return;
//        }
            if (check_3_O + check_3_X == 0 && count_empty == 0) {
                System.out.println("Draw");
                return;
            }
            if (check_3_O == 1 && check_3_X == 0) {
                System.out.println("O wins");
                return;
            }
            if (check_3_O == 0 && check_3_X == 1) {
                System.out.println("X wins");
                return;
            }
        }
    }

    public static String makeMove(String str, char player) {
//        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the coordinates: ");
        int a = 0;
        int b = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            while (true) {
                String st = sc.nextLine();
                String arr[] = st.split("\\s+");
                if (arr[0].charAt(0) >= 48 && arr[0].charAt(0) <= 57) {
                    a = arr[0].charAt(0) - 48;
                    if (arr[1].charAt(0) >= 48 && arr[1].charAt(0) <= 57) {
                        b = arr[1].charAt(0) - 48;
                        if (a > 3 || b > 3 || a < 1 || b < 1) {
                            System.out.println("Coordinates should be from 1 to 3!");
                            System.out.print("Enter the coordinates: ");
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("You should enter numbers!");
                        System.out.print("Enter the coordinates: ");
                    }
                } else {
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates: ");
                }
//                sc.close();
            }
            if (str.charAt(6 - 3 * (b - 1) + a - 1) != '_') {
                System.out.println("This cell is occupied! Choose another one!");
                System.out.print("Enter the coordinates: ");
                continue;
            }
            StringBuilder str2 = new StringBuilder(str);
            str2.setCharAt((6 - 3 * (b - 1) + a - 1), player);
            return str2.toString();
        }
    }

    public static void printField(String str) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.println("|" + " " + str.charAt(3 * i + 0) + " " + str.charAt(3 * i + 1)
                    + " " + str.charAt(3 * i + 2) + " " + "|");
        }
        System.out.println("---------");
    }

    public static int CheckThree(char c, String str) {
        for (int i = 0; i < 9; i++) {
            if (str.charAt(i) != c)
                continue;
            if (i == 0 || i == 3 || i == 6) {
                if (str.charAt(i + 1) == c && str.charAt(i + 2) == c) {
                    return 1;
                }
            }
            if (i == 0) {
                if (str.charAt(i + 4) == c && str.charAt(i + 8) == c) {
                    return 1;
                }
            }
            if (i == 2) {
                if (str.charAt(i + 2) == c && str.charAt(i + 4) == c) {
                    return 1;
                }
            }
            if (i <= 2) {
                if (str.charAt(i + 3) == c && str.charAt(i + 6) == c) {
                    return 1;
                }
            }
        }
        return 0;
    }

}

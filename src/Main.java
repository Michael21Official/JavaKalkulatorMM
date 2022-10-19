import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int num1 = getInt();
        int num2 = getInt();
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        System.out.println("Wynik operacji: " + result);
    }

    public static int getInt() {
        System.out.println("Wpiszcie liczbe:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Byl znaleziony blad przy wpisaniu liczby. Sprobujcie jeszcze raz.");
            scanner.next();//рекурсия
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Wpiszcie operacje");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Byl znaleziony blad w operacji. Sprobujcie jeszcze raz.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Nie ujawniono operacji. Powtorzcie operacje.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }
}
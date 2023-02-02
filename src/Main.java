import java.util.Arrays;
import java.util.Scanner;


public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int i;
        Scanner input = new Scanner(System.in);
        System.out.println("Wpisz Operacje: Kalkulator=1 SortowanieBąbelkowe=2 ObliczeniePolaKoła=3 ");
        i = input.nextInt();

        if (i == 1) {
            int num1 = getInt();
            int num2 = getInt();
            char operation = getOperation();
            int result = calc(num1, num2, operation);
            System.out.println("Wynik operacji: " + result);
        }
        else if (i == 2)
        {
            int counter, num, array[];
            System.out.println("Wpisz ilość elementów do sortowania: ");
            num = input.nextInt();
            array = new int[num];
            System.out.println("Wpisz " + num + " liczb");
            for (counter = 0; counter < num; counter++) {
                array[counter] = input.nextInt();
            }
            System.out.println("liczby przed sortowaniemBąbelkowym : " + Arrays.toString(array));
            bubbleSort(array);
            System.out.println("liczby po sortowaniuBąbelkowym : " + Arrays.toString(array));
        }
        else if (i == 3){
            System.out.print("Wpisz promień koła: ");
            int promien = input.nextInt();
            long area = Math.round(Math.PI * Math.pow(promien, 2));
            System.out.printf("Pole okręgu równa się= ", area);
        }

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



    public static void bubbleSort(int[] num) {
        int j;
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (j = 0; j < num.length - 1; j++) {
                if (num[j] < num[j + 1]) {
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }
}



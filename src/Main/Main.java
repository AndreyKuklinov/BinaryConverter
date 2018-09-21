package Main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declarations
        Scanner in = new Scanner(System.in);
        long input;
        int size;
        int[] output;

        //Main cycle
        while (true) {
            System.out.print("Введите число: ");
            input = in.nextLong();

            //Checking all value types
            if (input > Byte.MIN_VALUE && input < Byte.MAX_VALUE) {
                size = 8;
                System.out.println("Ваше число - byte");
            } else if (input > Short.MIN_VALUE && input < Short.MAX_VALUE) {
                size = 16;
                System.out.println("Ваше число - short");
            } else if (input > Integer.MIN_VALUE && input < Integer.MAX_VALUE) {
                size = 32;
                System.out.println("Ваше число - int");
            } else {
                size = 64;
                System.out.println("Ваше число - long");
            }

            //Converting to binary
            output = convertToBinary(input, size);
            System.out.println("Ваше число в двоичном виде: ");
            for (int value : output) {
                System.out.print(value);
            }
            System.out.println();
        }

    }

    //Converts Byte/Short/Int/Long to a binary array
    static int[] convertToBinary(long num, int size) {
        int[] arr = new int[size];
        if (num < 0) {
            arr[0] = 1;
            num *= -1;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[arr.length - i] = (int) (num % 2);
            if (num > 0) {
                num = num / 2;
            }
        }
        return arr;
    }
}

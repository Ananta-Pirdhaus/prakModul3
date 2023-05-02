import java.util.Scanner;

public class kegiatan1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan string: ");
        String inputStr = input.nextLine();

        String outputStr = reverseString(inputStr);
        System.out.println("Hasil pembalikan string: " + outputStr);
    }

    public static String reverseString(String inputStr) {
        // membuat stack baru
        char[] stack = new char[inputStr.length()];

        // memasukkan setiap karakter string ke dalam stack
        for (int i = 0; i < inputStr.length(); i++) {
            stack[i] = inputStr.charAt(i);
        }

        // membuat string baru dari karakter-karakter stack
        String outputStr = "";
        for (int i = inputStr.length() - 1; i >= 0; i--) {
            outputStr += stack[i];
        }

        return outputStr;
    }
}

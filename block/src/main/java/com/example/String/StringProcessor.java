package com.example.String;

import java.util.Scanner;

public class StringProcessor {
    public static void main(String[] args) {
        convertHexToDec();
        reverseWords();
        repetition();
        lineOccurs();
        replacingNum();
        deleteEveryOtherCharacter();
    }

    //repetition
    public static void repetition() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напиши слово");
        String slovo = scanner.nextLine();
        System.out.println("Введи число");
        String num = scanner.nextLine();
        try {
        String result = repetitionMethod(slovo, Integer.parseInt(num));
        System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String repetitionMethod(String slovo, int num) {
        if (num == 0) {
            return "Нихт не выведено";
        }
        if (num < 0) {
            throw new IllegalArgumentException("Число не может быть отриц");
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num; i++) {
            sb.append(slovo).append(" ");
        }

        sb.trimToSize();
    
        return sb.toString();
    }
    //repetition

    //lineOccurs
    public static void lineOccurs() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = scanner.nextLine();
        System.out.println("Введите слово которое должно встречаться: ");
        String word = scanner.nextLine();
        try {
            int result = lineOccursMethod(line, word);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static int lineOccursMethod(String line, String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Слово должно быть заполнено.");
        }
        return line.split(word, -1).length - 1;
    }
    //lineOccurs

    //replacingNum
    public static void replacingNum() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String line = scanner.nextLine();
        String result = replacingNumMethod(line);
        System.out.println(result);
    }

    public static String replacingNumMethod(String line) {
        StringBuilder sb = new StringBuilder();
        for(char c : line.toCharArray()) {
            switch (c) {
            case '1':
                sb.append("один");
                break;
            case '2':
                sb.append("два");
                break;
            case '3':
                sb.append("три");
                break;
                default:
                sb.append(c);
                break;
            }

        }
        return sb.toString();
    }
    //replacingNum

    //deleteEveryOtherCharacter
    public static void deleteEveryOtherCharacter() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String line = scanner.nextLine();
        try {
            String result = deleteEveryOtherCharacterMetod(line);
            System.out.println("Результат: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String deleteEveryOtherCharacterMetod(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Строка должна быть заполнена");
        }
        StringBuilder sb = new StringBuilder(line);
        for(int i = 1; i < sb.length(); i += 1) {
            sb.deleteCharAt(i);
        }
        return sb.toString();
    }
    //deleteEveryOtherCharacter

    //reverseWords
    public static void reverseWords() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String line = scanner.nextLine();
        try {
            String result = reverseWordsmMetod(line);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String reverseWordsmMetod(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Строка должна быть заполнена");
        }
        StringBuilder sb = new StringBuilder();
        String[] words = line.split("(?<=\\s)");
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i]; 
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i == 0) {
                sb.append(" "); 
            }
        }
        return sb.toString();
    }
    //reverseWords
    
    //HexToDecConverter
    public static void convertHexToDec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String line = scanner.nextLine();
        try {
            String result = convertHexToDecMetod(line);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String convertHexToDecMetod(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Строка должна быть заполнена");
        }
        StringBuilder sb = new StringBuilder();
        String[] words = line.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isValidHex(word)) {
                try {
                    word = word.substring(2); 
                    long decimal = Long.parseLong(word, 16); 
                    sb.append(decimal).append(" "); 
                } catch (NumberFormatException e) {
                    sb.append(word).append(" ");
                }
            } else {
                sb.append(word).append(" "); 
            }
        }
        return sb.toString().trim();
    }
    
    public static boolean isValidHex(String word) {
        if (word.startsWith("0x")) {
            word = word.substring(2);
        }
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c) && !(c >= 'A' && c <= 'F')) {
                return false;
            }
        }
        return true;
    }
    //HexToDecConverter
}

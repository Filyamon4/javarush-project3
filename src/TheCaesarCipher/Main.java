package TheCaesarCipher;

import java.io.*;
import java.nio.file.Path;
import java.util.*;


public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static final ArrayList<Character> ALPHABET = new ArrayList<>();
    public static final ArrayList<Character> CAPITAL_ALPHABET = new ArrayList<>();
    public static final ArrayList<Character> ENCRYPTED_ALPHABET = new ArrayList<>();
    public static final ArrayList<Character> ENCRYPTED_CAPITAL_ALPHABET = new ArrayList<>();

    public static void main(String[] args) {

        start();

    }

    public static void start() {

        for (char i = 'а'; i <= 'я'; i++) {
            ALPHABET.add(i);
        }

        for (char i = 'А'; i <= 'Я'; i++) {
            CAPITAL_ALPHABET.add(i);
        }

        CAPITAL_ALPHABET.add(6, 'Ё');
        ALPHABET.add(6, 'ё');

        ALPHABET.add('.');
        ALPHABET.add(',');
        ALPHABET.add('"');
        ALPHABET.add(':');
        ALPHABET.add('-');
        ALPHABET.add('!');
        ALPHABET.add('?');
        ALPHABET.add(' ');

        CAPITAL_ALPHABET.add('.');
        CAPITAL_ALPHABET.add(',');
        CAPITAL_ALPHABET.add('"');
        CAPITAL_ALPHABET.add(':');
        CAPITAL_ALPHABET.add('-');
        CAPITAL_ALPHABET.add('!');
        CAPITAL_ALPHABET.add('?');
        CAPITAL_ALPHABET.add(' ');

        ENCRYPTED_ALPHABET.addAll(ALPHABET);
        ENCRYPTED_CAPITAL_ALPHABET.addAll(CAPITAL_ALPHABET);

        consoleMenu();

    }

    public static void consoleMenu() { // УЖСССССС УЖАААААСНЫЙ

        boolean exitMenu = false, exitMenu1, exitMenu11, exitMenu2, exitMenu21, exitMenu22; //ужс ужасный
        boolean exitMenuKey11;                                                              //ужс ужасный
        boolean exitMenuPath11;                                                             //ужс ужасный
        boolean exitMenuKey21, exitMenuPath21;                                              //ужс ужасный
        String inputFile11 = "", inputFile21 = "", inputFile22;                             //ужс ужасный
        String incorrectMenuKey11, incorrectMenuKey21;                                      //ужс ужасный
        int menu, menu1, menu11 = -1, menu22 = -1;                                          //ужс ужасный
        int menu2, menu21 = -1;                                                             //ужс ужасный
        int key11 = 0, key21 = 0;                                                           //ужс ужасный

        clearConsole();
        System.out.println("\nКриптоанализатор \"Цезарь\"");
        while (!exitMenu) {

            System.out.print("""
                    
                    1. Шифрование
                    2. Расшифрование
                    
                    0. Завершить программу
                    
                    Введите выбранный пункт:\s""");

            menu = checkNumberMenu(1, 2, 0);

            switch (menu) {

                case 1 -> {

                    clearConsole();
                    exitMenu1 = false;

                    while (!exitMenu1) {

                        System.out.print("""
                                1. Импортировать из файла
                                
                                9. Назад
                                0. Завершить программу
                                
                                Введите выбранный пункт:\s""");

                        menu1 = checkNumberMenu(1, 9, 0);

                        switch (menu1) {

                            case 1 -> {

                                exitMenu11 = false;

                                while (!exitMenu11) {

                                    exitMenuPath11 = false;
                                    exitMenuKey11 = false;

                                    while (!exitMenuPath11) {
                                        System.out.print("""
                                                
                                                Для отмены введите 0.
                                                Введите полный путь к файлу, который требуется расшифровать *.txt :\s""");
                                        inputFile11 = scanner.nextLine().trim().replace("\"", "");

                                        try {
                                            if (Integer.parseInt(inputFile11) == 0) {
                                                menu11 = Integer.parseInt(inputFile11);
                                                clearConsole();
                                                exitMenuKey11 = true;

                                            }
                                        } catch (NumberFormatException ignored) {
                                        }

                                        exitMenuPath11 = true;
                                    }

                                    while (!exitMenuKey11) {
                                        System.out.print("""
                                                Введите ключ шифрования:\s""");

                                        incorrectMenuKey11 = scanner.nextLine().trim();
                                        try {
                                            key11 = Integer.parseInt(incorrectMenuKey11);
                                            exitMenuKey11 = true;
                                        } catch (NumberFormatException e) {
                                            clearConsole();
                                            System.out.println("\nНеверный формат \"" + incorrectMenuKey11 + "\"");
                                            System.out.println("Введите корректное значение.");
                                        }
                                    }
                                    clearConsole();
                                    if (!(menu11 == 0)) {
                                        encryptImport(inputFile11, key11);
                                    }
                                    exitMenu11 = true;
                                    menu11 = -4;
                                }
                            }

                            case 9 -> {
                                clearConsole();
                                exitMenu1 = true;
                            }

                            case 0 -> {
                                System.out.println("Программа завершена.");
                                exitMenu = exitMenu1 = true;
                            }

                            case -1 -> {
                                clearConsole();
                                System.out.println("Пункт не существует.");
                                System.out.println("Введите корректное значение.\n");
                            }

                            case -2 -> {
                                clearConsole();
                                System.out.println("Неверный формат");
                                System.out.println("Введите корректное значение.\n");
                            }

                            default -> {
                                clearConsole();
                                System.out.println("??? Неизвестная ошибка");
                            }

                        }
                    }
                }

                case 2 -> {

                    clearConsole();
                    exitMenu2 = false;

                    while (!exitMenu2) {

                        System.out.print("""
                                1. Расшифрование по ключу
                                2. Расшифрование "BruteForce"
                                
                                9. Назад
                                0. Завершить программу
                                
                                Введите выбранный пункт:\s""");

                        menu2 = checkNumberMenu(1, 2, 9, 0);

                        switch (menu2) {

                            case 1 -> {

                                exitMenu21 = false;

                                while (!exitMenu21) {

                                    exitMenuPath21 = false;
                                    exitMenuKey21 = false;

                                    while (!exitMenuPath21) {
                                        System.out.print("""
                                                
                                                Для отмены введите 0.
                                                Введите полный путь к файлу, который требуется расшифровать *.txt :\s""");

                                        inputFile21 = scanner.nextLine().trim().replace("\"", "");

                                        try {
                                            if (Integer.parseInt(inputFile21) == 0) {
                                                menu21 = Integer.parseInt(inputFile21);
                                                clearConsole();
                                                exitMenuKey21 = true;

                                            }
                                        } catch (NumberFormatException ignored) {
                                        }

                                        exitMenuPath21 = true;
                                    }

                                    while (!exitMenuKey21) {
                                        System.out.print("""
                                                Введите ключ шифрования:\s""");

                                        incorrectMenuKey21 = scanner.nextLine().trim();
                                        try {
                                            key21 = Integer.parseInt(incorrectMenuKey21);
                                            exitMenuKey21 = true;
                                        } catch (NumberFormatException e) {
                                            clearConsole();
                                            System.out.println("\nНеверный формат");
                                            System.out.println("Введите корректное значение.");
                                        }
                                    }
                                    clearConsole();
                                    if (!(menu21 == 0)) {
                                        decryptImport(inputFile21, key21);
                                    }
                                    exitMenu21 = true;
                                    menu21 = -4;
                                }

                            }

                            case 2 -> {
                                exitMenu22 = false;

                                while (!exitMenu22) {

                                    System.out.print("""
                                            
                                            Для отмены введите 0.
                                            Введите полный путь к файлу, который требуется расшифровать *.txt :\s""");

                                    inputFile22 = scanner.nextLine().trim();
                                    menu22 = -1;

                                    try {
                                        menu22 = Integer.parseInt(inputFile22);
                                        if (menu22 == 0) {

                                            clearConsole();
                                            exitMenu22 = true;

                                        }

                                    } catch (NumberFormatException ignored) {
                                    }

                                    if (menu22 != 0) {
                                        bruteForce(inputFile22);
                                        exitMenu22 = true;
                                    }

                                }


                            }

                            case 9 -> {
                                clearConsole();
                                exitMenu2 = true;
                            }

                            case 0 -> {
                                System.out.println("Программа завершена.");
                                exitMenu = exitMenu2 = true;
                            }

                            case -1 -> {
                                clearConsole();
                                System.out.println("Пункт не существует.");
                                System.out.println("Введите корректное значение.\n");
                            }

                            case -2 -> {
                                clearConsole();
                                System.out.println("Неверный формат");
                                System.out.println("Введите корректное значение.\n");
                            }

                            default -> {
                                clearConsole();
                                System.out.println("??? Неизвестная ошибка");
                            }

                        }

                    }

                }

                case 0 -> {
                    System.out.println("Программа завершена.");
                    exitMenu = true;
                }

                case -1 -> {
                    clearConsole();
                    System.out.println("Пункт не существует.");
                    System.out.println("Введите корректное значение.\n");
                }

                case -2 -> {
                    clearConsole();
                    System.out.println("Неверный формат");
                    System.out.println("Введите корректное значение.\n");
                }

                default -> System.out.println("??? - Неизвестная ошибка");
            }

        }

    } // УЖСССССС УЖАААААСНЫЙ

    public static void clearConsole() {

        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }

    public static String encrypt(String text, int key) { // text - исходная строка, key - сдвиг символов.

        char[] textArraysChar = text.toCharArray();

        Collections.rotate(ENCRYPTED_ALPHABET, -(key % ALPHABET.size())); // сдвиг символов (-key вправо, б = в; key влево, б = а)
        Collections.rotate(ENCRYPTED_CAPITAL_ALPHABET, -(key % Main.CAPITAL_ALPHABET.size()));

        for (int i = 0; i < textArraysChar.length; i++) {
            for (int n = 0; n < ALPHABET.size(); n++) {

                if (textArraysChar[i] == ALPHABET.get(n)) { // проверка символа по ключу для шифрования
                    textArraysChar[i] = ENCRYPTED_ALPHABET.get(n);
                    break;

                } else if (n < 33 && textArraysChar[i] == CAPITAL_ALPHABET.get(n)) { // проверка символа по ключу для шифрования
                    textArraysChar[i] = ENCRYPTED_CAPITAL_ALPHABET.get(n);
                    break;
                }
            }
        }

        Collections.rotate(ENCRYPTED_ALPHABET, (key % ALPHABET.size()));
        Collections.rotate(ENCRYPTED_CAPITAL_ALPHABET, (key % CAPITAL_ALPHABET.size()));

        return toStringBuilder(textArraysChar);
    }

    public static String decrypt(String text, int key) {

        char[] textArraysChar = text.toCharArray();

        Collections.rotate(ENCRYPTED_ALPHABET, -(key % ALPHABET.size()));
        Collections.rotate(ENCRYPTED_CAPITAL_ALPHABET, -(key % CAPITAL_ALPHABET.size()));

        for (int i = 0; i < textArraysChar.length; i++) {
            for (int n = 0; n < ENCRYPTED_ALPHABET.size(); n++) {

                if (textArraysChar[i] == ENCRYPTED_ALPHABET.get(n)) {
                    textArraysChar[i] = ALPHABET.get(n);
                    break;

                } else if (n < ENCRYPTED_CAPITAL_ALPHABET.size() && textArraysChar[i] == ENCRYPTED_CAPITAL_ALPHABET.get(n)) {
                    textArraysChar[i] = CAPITAL_ALPHABET.get(n);
                    break;
                }
            }
        }

        Collections.rotate(ENCRYPTED_ALPHABET, (key % ALPHABET.size()));
        Collections.rotate(ENCRYPTED_CAPITAL_ALPHABET, (key % CAPITAL_ALPHABET.size()));

        return toStringBuilder(textArraysChar);
    }

    public static void bruteForce(String input) {

        HashSet<String> uniqueKeys = new HashSet<>();
        String origLine;
        String line = "";
        int menu;
        int key = 1;
        boolean exit = false;
        char[] symbols = new char[]{
                '\n', '\t', '\b', '\r', '\f', '\'',
                '\"', '\\', '\'', '\'', '\'', '\"',
                '\"', '"', '`', '~', '!', '@', '#',
                '№', '$', ';', '%', '^', ':', '&',
                '?', '*', '(', ')', '-', '_', '=',
                '+', '[', '{', ']', '}', '|', '/',
                ',', '<', '.', '>', '/', '—', '…',
                '«', '»', '“', '”'};

        Path path = Path.of(input.trim().replace("\"", ""));
        String fileName = String.valueOf(path.getFileName())
                .replace("-encrypted", "")
                .replace("-decrypted", "")
                .replace("-bruteForce", "")
                .replace(".txt", "");

        Path output = Path.of(path.getParent() + "\\" + fileName + "-bruteForce.txt");
        Path pathKeys = Path.of("src\\TheCaesarCipher\\keysStorageBF.txt").toAbsolutePath();


        try (FileReader fileReader1 = new FileReader(pathKeys.toString());
             BufferedReader keys = new BufferedReader(fileReader1);
             FileReader fileReader = new FileReader(path.toString());
             BufferedReader buffLine = new BufferedReader(fileReader)) {

            while (keys.ready()) {
                uniqueKeys.add(keys.readLine());
            }

            while (buffLine.ready()) {
                origLine = buffLine.readLine();

                for (int i = 0; i < ALPHABET.size(); i++) {
                    line = origLine;
                    line = decrypt(line, i);

                    for (char symbol : symbols) {
                        line = line.replace(symbol, '`').replace("`", "");
                    }

                    String[] str = line.toLowerCase().split(" ");
                    ArrayList<String> wordArray = new ArrayList<>();
                    Collections.addAll(wordArray, str);

                    for (int k = 0; k < wordArray.size(); k++) {
                        if (wordArray.get(k).isEmpty() || wordArray.get(k).equals(" ") || wordArray.get(k).length() < 3) {
                            wordArray.remove(k);
                        }
                    }

                    for (String uniqueKey : uniqueKeys) {
                        for (String word : wordArray) {

                            if (word.equals(uniqueKey)) {

                                clearConsole();
                                if (i != 0) {
                                    System.out.println("Вероятный ключ: " + i + ".\n");
                                } else System.out.println("Текст не нуждается в расшифровке.");
                                System.out.print("""
                                        Сохранить файл?
                                        1. Да
                                        2. Нет
                                        
                                        Введите выбранный пункт:\s""");

                                menu = checkNumberMenu(1, 2);

                                switch (menu) {

                                    case 1 -> {

                                        fileReader.close();
                                        fileReader1.close();
                                        keys.close();
                                        buffLine.close();

                                        try (FileReader fr = new FileReader(path.toString());
                                             BufferedReader br = new BufferedReader(fr);
                                             FileWriter fw = new FileWriter(output.toString())) {

                                            while (br.ready()) {
                                                fw.write(decrypt(br.readLine(), i) + "\n");
                                            }
                                            clearConsole();
                                            System.out.println("Файл сохранен: " + output + "\n");

                                        }

                                    }

                                    case 2 -> {
                                        clearConsole();
                                    }

                                    case -1 -> {
                                        clearConsole();
                                        System.out.println("Пункт не существует.");
                                        System.out.println("Введите корректное значение.\n");
                                    }

                                    case -2 -> {
                                        clearConsole();
                                        System.out.println("Неверный формат");
                                        System.out.println("Введите корректное значение.\n");
                                    }

                                    default -> {
                                        clearConsole();
                                        System.out.println("??? Неизвестная ошибка");
                                    }

                                }

                                return;
                            }

                        }

                    }

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, проверьте корректность указанного пути.");
        } catch (IOException e) {
            throw new RuntimeException("Неизвестная ошибка");
        }

        clearConsole();
        System.out.println("Ключ не удалось определить.");
        System.out.print("""
                Использовать ручной подбор?
                1. Да
                2. Нет
                
                Введите выбранный пункт:\s""");

        menu = checkNumberMenu(1, 2);

        switch (menu) {

            case 1 -> {

                clearConsole();

                try (FileReader fr = new FileReader(path.toString());
                     BufferedReader br = new BufferedReader(fr);
                     FileWriter fw = new FileWriter(output.toString())) {

                    if (br.ready()) {
                        line = br.readLine();
                    }


                    while (!exit) {

                        clearConsole();
                        System.out.println("""
                        На экран выведена строка из текстового файла,
                        проверьте подходит ли ключ.
                        """);
                        System.out.println("Ключ: " + (key % ALPHABET.size()));
                        System.out.println("Строка из файла: " + decrypt(line, key));
                        System.out.print("""
                                
                                1. Следующий ключ
                                2. Предыдущий ключ
                                3. Сохранить файл с этим ключом
                                
                                0. Завершить подбор
                                Введите выбранный пункт:\s""");

                        menu = checkNumberMenu(1, 2, 3, 0);

                        switch (menu) {

                            case 1 -> {
                                key++;
                            }

                            case 2 -> {
                                key--;
                            }

                            case 3 -> {

                                clearConsole();
                                fw.write(decrypt(line, key));

                                while (br.ready()) {
                                    fw.write(decrypt(br.readLine(), key) + "\n");
                                }

                                System.out.println("Файл сохранен: " + output + "\n");
                                exit = true;

                            }

                            case 0 -> {
                                exit = true;
                            }

                        }

                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }

            case 2 -> {
                clearConsole();
            }

            case -1 -> {
                clearConsole();
                System.out.println("Пункт не существует.");
                System.out.println("Введите корректное значение.\n");
            }

            case -2 -> {
                clearConsole();
                System.out.println("Неверный формат");
                System.out.println("Введите корректное значение.\n");
            }

            default -> {
                clearConsole();
                System.out.println("??? Неизвестная ошибка");
            }

        }


    }

    public static void addKeysBF(String path) {

        HashSet<String> uniqueKeys = new HashSet<>();
        ArrayList<String> buffList = new ArrayList<>();
        ArrayList<String> textArray = new ArrayList<>();
        Path keysStorageBF = Path.of("src\\TheCaesarCipher\\keysStorageBF.txt").toAbsolutePath();
        String line;
        int maxLitter = Integer.MIN_VALUE;
        char[] symbols = new char[]{
                '\n', '\t', '\b', '\r', '\f', '\'',
                '\"', '\\', '\'', '\'', '\'', '\"',
                '\"', '"', '`', '~', '!', '@', '#',
                '№', '$', ';', '%', '^', ':', '&',
                '?', '*', '(', ')', '-', '_', '=',
                '+', '[', '{', ']', '}', '|', '/',
                ',', '<', '.', '>', '/', '—', '…',
                '«', '»', '“', '”'};

        try (FileReader readKeysStorageBF = new FileReader(keysStorageBF.toString());
             BufferedReader bufKeysStorageBF = new BufferedReader(readKeysStorageBF)) {

            while (bufKeysStorageBF.ready()) {
                line = bufKeysStorageBF.readLine();

                if (!line.isEmpty() && !line.equals("\n")) {
                    uniqueKeys.add(line);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, проверьте корректность указанного пути.");

        } catch (IOException e) {
            throw new RuntimeException("Неизвестная ошибка");
        }


        try (FileReader fileReader = new FileReader(path.trim().replace("\n", ""));
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {
                buffList.add(bufferedReader.readLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, проверьте корректность указанного пути.");

        } catch (IOException e) {
            throw new RuntimeException("Неизвестная ошибка");
        }

        for (int i = 0; i < buffList.size(); i++) {

            for (char symbol : symbols) {
                buffList.set(i, buffList.get(i).replace(symbol, '`').replace("`", ""));

            }

            Collections.addAll(textArray, buffList.get(i).toLowerCase().split(" "));

            for (int j = 0; j < textArray.size(); j++) {
                if (textArray.get(j).isEmpty() || textArray.get(j).equals(" ") || textArray.get(j).length() < 3) {
                    textArray.remove(j);
                    j--;
                }
            }
        }

        for (String s : textArray) {
            maxLitter = Integer.max(maxLitter, s.length());
        }

        char[] letter = new char[maxLitter];

        for (int i = 0; i < textArray.size(); i++) {
            letter = textArray.get(i).toCharArray();

            for (char chars : letter) {

                for (char c = 'a'; c < 'z'; c++) {

                    if ((chars == c || Character.isDigit(chars))) {
                        textArray.remove(i);

                        if (i > 0) {
                            i--;
                        }

                        break;
                    }
                }
                break;
            }
        }

        uniqueKeys.addAll(textArray);

        try (FileWriter fileWriter = new FileWriter(keysStorageBF.toString())) {

            for (String uniqueKey : uniqueKeys) {
                fileWriter.write(uniqueKey + "\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void encryptImport(String input, int key) {

        Path path = Path.of(input.trim().replace("\n", ""));

        String fileName = String.valueOf(path.getFileName())
                .replace("-encrypted", "")
                .replace("-decrypted", "")
                .replace("-bruteForce", "")
                .replace(".txt", "");

        Path output = Path.of(path.getParent() + "\\" + fileName + "-encrypted.txt");


        try (FileReader fileReader = new FileReader(path.toString());
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(String.valueOf(output))) {

            while (bufferedReader.ready()) {

                fileWriter.write(encrypt(bufferedReader.readLine(), key) + "\n");

            }

            System.out.println("""
                    Шифрование прошло успешно.
                    Файл сохранен:\s""" + output + "\n");

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, проверьте корректность указанного пути.");
        } catch (IOException e) {
            System.out.println("Шифрование завершено с ошибкой.");
            throw new RuntimeException();
        }

    }

    public static void decryptImport(String input, int key) {

        Path path = Path.of(input.trim().replace("\n", ""));

        String fileName = String.valueOf(path.getFileName())
                .replace("-encrypted", "")
                .replace("-decrypted", "")
                .replace("-bruteForce", "")
                .replace(".txt", "");

        Path output = Path.of(path.getParent() + "\\" + fileName + "-decrypted.txt");

        try (FileReader fileReader = new FileReader(path.toString());
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(String.valueOf(output))) {

            while (bufferedReader.ready()) {

                fileWriter.write(decrypt(bufferedReader.readLine(), key) + "\n");

            }

            System.out.println("""
                    Расшифрование прошло успешно.
                    Файл сохранен:\s""" + output + "\n");

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден, проверьте корректность указанного пути.");
        } catch (IOException e) {
            System.out.println("Расшифрование завершено с ошибкой.");
            throw new RuntimeException();
        }

    }

    public static String toStringBuilder(char[] array) {

        StringBuilder builder = new StringBuilder();
        for (char symbol : array) {
            builder.append(symbol);
        }

        return builder.toString();
    }

    public static int checkNumberMenu(int... numberMenu) {

        int menu;
        int result = -3;
        String text = scanner.nextLine().trim();

        try {
            menu = Integer.parseInt(text);

            for (int i : numberMenu) {

                if (menu == i) {
                    result = menu;
                    break;

                } else {
                    result = -1;
                }

            }
        } catch (NumberFormatException e) {

            if (text.equals("ADBF")) {

                System.out.print("""
                        Введите путь к файлу для добавления ключей:\s""");
                addKeysBF(scanner.nextLine().trim().replace("\"", ""));
                System.out.println("Уникальные ключи добавлены.");
                result = 0;

            } else result = -2;
        }

        return result;
    }

}
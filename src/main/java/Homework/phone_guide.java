package Homework;

import java.util.*;

public class phone_guide {
    public static void main(String[] args) {
        Map<String, ArrayList<Integer>> storage = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите команду: ");
            String command = scanner.nextLine();

            if ("exit".equalsIgnoreCase(command)) {
                break;
            }

            if ("list".equalsIgnoreCase(command)) {
                if (storage.size() == 0) {
                    System.out.println("Справочник пуст!");
                    continue;
                }
                for (var item : storage.keySet()) {
                    System.out.printf("%s = %s\n", item, storage.get(item).toString());
                }
                continue;
            }

            String[] arguments = command.split(" ");
            String function = null;
            String name = null;
            int phoneNum = -1;

            if (arguments.length == 2) {
                function = arguments[0];
                name = arguments[1];
            } else if (arguments.length == 3) {
                function = arguments[0];
                name = arguments[1];
                try {
                    phoneNum = Integer.parseInt(arguments[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Некорретный ввод!");
                    continue;
                }
            } else {
                System.out.println("Некорретный ввод!");
                continue;
            }

            if ("add".equalsIgnoreCase(function)) {
                if (!storage.containsKey(name)) {
                    storage.put(name, new ArrayList<Integer>(List.of(phoneNum)));
                } else {
                    ArrayList<Integer> tempPhoneNums = storage.get(name);
                    tempPhoneNums.add(phoneNum);
                    storage.put(name, tempPhoneNums);
                }
                System.out.println("Запись успешно добавлена!");
            }
            if ("get".equalsIgnoreCase(function)) {
                if (!storage.containsKey(name)) {
                    System.out.printf("Не найдена запись с фамилией %s!\n", name);
                    continue;
                }
                for (var item : storage.keySet()) {
                    if (item.equals(name)) {
                        System.out.printf("%s = %s\n", item, storage.get(item).toString());
                    }
                }
            }
            if ("remove".equalsIgnoreCase(function)) {
                if (!storage.containsKey(name)) {
                    System.out.printf("Не найдена запись с фамилией %s!\n", name);
                    continue;
                }
                for (var item : storage.keySet()) {
                    if (item.equals(name)) {
                        storage.remove(name);
                        System.out.println("Запись удалена!");
                    }
                }
                continue;
            }

        }
        System.out.println("Программа завершена!");
    }
}

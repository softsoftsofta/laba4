import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.out;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.println("Введите номер задания: ");
        int n = in.nextInt();
        in.nextLine();
        switch(n) {
            case 11:
                out.println("Обобщенная коробка");
                Box<Integer> intBox = new Box<>();

                out.println("Заполните коробку: ");
                int content = in.nextInt();
                intBox.put(content);
                Integer value = processBox(intBox);
                break;
            case 22:
                out.println("Поиск максимума");
                List<Box<? extends Number>> boxes = createBoxCollection();

                double maxValue = findMax(boxes);
                out.println("Наибольшее содержимое из коллекции коробок: " + maxValue);
                break;
            case 31:
                out.println("Функция 3.1");
                System.out.println("Введите строки для нахождения их длины (для завершения введите пустую строку):");
                List<String> inputStrings = new ArrayList<>();
                while (true) {
                    String input = in.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    inputStrings.add(input);
                }
                List<Integer> lengths = transformList(inputStrings, String::length);
                System.out.println("Длины строк: " + lengths);


                System.out.println("Введите числа для преобразования (для завершения введите пустую строку):");
                List<Integer> inputNumbers = new ArrayList<>();
                while (true) {
                    String input = in.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    try {
                        inputNumbers.add(Integer.parseInt(input));
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                    }
                }
                List<Integer> absolutes = transformList(inputNumbers, Math::abs);
                System.out.println("Модули чисел: " + absolutes);


                System.out.println("\nВведите массивы чисел для преобразования (для завершения введите пустую строку):");
                List<int[]> inputArrays = new ArrayList<>();
                while (true) {
                    System.out.println("Введите числа через пробел (для завершения введите пустую строку):");
                    String input = in.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    try {
                        String[] parts = input.split(" ");
                        int[] array = new int[parts.length];
                        for (int i = 0; i < parts.length; i++) {
                            array[i] = Integer.parseInt(parts[i]);
                        }
                        inputArrays.add(array);
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод. Пожалуйста, введите числа через пробел.");
                    }
                }
                List<Integer> maxValues = transformList(inputArrays, arr -> {
                    int max = Integer.MIN_VALUE;
                    for (int num : arr) {
                        max = Math.max(max, num);
                    }
                    return max;
                });
                System.out.println("Максимальные значения в массивах: " + maxValues);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
    }

    public static <T extends Number> T processBox(Box<T> box) {
        T item = box.get();
        out.println("Содержимое коробки: " + item);
        return item;
    }
    //2.2
    static List<Box<? extends Number>> createBoxCollection() {
        List<Box<? extends Number>> boxes = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            out.println("Введите нужный тип данных (1 - int, 2 - float, 3 - double, 4 - long, 5 - short, 6 - byte): ");
            int nn = in.nextInt();
            switch(nn) {
                case 1:
                    out.println("Введите число для хранения в коробке: ");
                    int c1 = in.nextInt();
                    boxes.add(new Box<>(c1));
                    break;
                case 2:
                    out.println("Введите число для хранения в коробке: ");
                    float c2 = in.nextFloat();
                    boxes.add(new Box<>(c2));
                    break;
                case 3:
                    out.println("Введите число для хранения в коробке: ");
                    double c3 = in.nextDouble();
                    boxes.add(new Box<>(c3));
                    break;
                case 4:
                    out.println("Введите число для хранения в коробке: ");
                    long c4 = in.nextLong();
                    boxes.add(new Box<>(c4));
                    break;
                case 5:
                    out.println("Введите число для хранения в коробке: ");
                    short c5 = in.nextShort();
                    boxes.add(new Box<>(c5));
                    break;
                case 6:
                    out.println("Введите число для хранения в коробке: ");
                    byte c6 = in.nextByte();
                    boxes.add(new Box<>(c6));
                    break;
                default:
                    throw new IllegalArgumentException("Неподдерживаемый тип данных");
            }

            out.println("Хотите ли вы прекратить добавление коробок?(1 - да, 2 - нет) ");
            int flagCheck = in.nextInt();
            if (flagCheck == 1) flag = false;
            else if (flagCheck != 2) throw new IllegalStateException("Недопустимое значение: " + flagCheck);

        }
        return boxes;
    }

    static double findMax(List<Box<? extends Number>> boxes) { //метод для задания 2.2
        if (boxes == null || boxes.isEmpty()) {
            throw new IllegalArgumentException("Должна быть хотя бы одна коробка.");
        }

        double max = Double.NEGATIVE_INFINITY;

        for (Box<? extends Number> box : boxes) {
            if (box != null && box.getContent() != null) {
                max = Math.max(max, box.getContent().doubleValue());
            }
        }
        return max;
    }

    //метод для задания 3.1
    static <T,P> List<P> transformList(List<T> inputList, Function<T,P> transformer) {
        List<P> resultList = new ArrayList<>();
        for (T item : inputList) {
            resultList.add(transformer.apply(item));
        }
        return resultList;
    }

   /* public static <T> List<T> filterList(List<T> inputList, Predicate<T> filter) {
        List<T> resultList = new ArrayList<>();
        for (T item : inputList) {
            if (filter.test(item)) {
                resultList.add(item);
            }
        }
        return resultList;
    }*/

}

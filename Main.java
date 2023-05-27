import java.util.*;

/* Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java. Создать
множество ноутбуков. Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например:
“Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
*/
public class Main {

    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("Apple", "MacBook Pro", 16, 512,
                "macOS", "Silver", 1999.99));
        laptops.add(new Laptop("Dell", "XPS 13", 8, 256,
                "Windows 10", "Black", 1199.99));
        laptops.add(new Laptop("HP", "Spectre x360", 16, 1_000,
                "Windows 10", "Rose Gold", 1499.99));
        laptops.add(new Laptop("Lenovo", "ThinkPad X1 Carbon", 16, 512,
                "Windows 10 Pro", "Black", 1799.99));
        laptops.add(new Laptop("Asus", "ZenBook Pro Duo", 32, 1_000,
                "Windows 10 Pro", "Celestial Blue", 2999.99));

        Map<Integer, String> filterCriteria = new HashMap<>();
        filterCriteria.put(1, "RAM");
        filterCriteria.put(2, "HDD накопитель");
        filterCriteria.put(3, "Операционная система");
        filterCriteria.put(4, "Цвет");
        filterCriteria.put(5, "Стоимость");

        Map<Integer, Object> filterParams = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите критерии фильтрации: ");

        for (Map.Entry<Integer, String> entry : filterCriteria.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.print("Введите количество критериев фильтрации: ");
        int numCriteria = scanner.nextInt();

        for (int i = 0; i < numCriteria; i++) {
            System.out.print("Введите номер критерия фильтрации: ");
            int criterionNumber = scanner.nextInt();
            switch (criterionNumber) {
                case 1:
                    System.out.print("Введите минимальное значение критерия: ");
                    int ram = scanner.nextInt();
                    filterParams.put(criterionNumber, ram);
                    break;
                case 2:
                    System.out.print("Введите минимальное значение критерия: ");
                    int storage = scanner.nextInt();
                    filterParams.put(criterionNumber, storage);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Введите минимальное значение критерия: ");
                    String os = scanner.nextLine();
                    filterParams.put(criterionNumber, os);
                    break;
                case 4:
                    System.out.print("Введите минимальное значение критерия: ");
                    String color = scanner.next();
                    filterParams.put(criterionNumber, color);
                    break;
                case 5:
                    System.out.print("Введите минимальное значение критерия: ");
                    Double price = scanner.nextDouble();
                    filterParams.put(criterionNumber, price);
                    break;
            }
        }

    List<Laptop> filteredLaptops = Laptop.filterLaptops(laptops, filterParams);

    System.out.println("Отфильтрованные ноутбуки: ");
    for (Laptop laptop : filteredLaptops) {
        System.out.println("Марка: " + laptop.getBrand() + ", модель: " + laptop.getModel() + ", RAM: "
                + laptop.getRAM() + "GB, накопитель: " +
                laptop.getHDDVolume() + "GB, операционная система: " + laptop.getOperatingSystem() +
                ", цвет: " + laptop.getColor() + ", цена: " + laptop.getPrice() + "$");
        }
    }
}
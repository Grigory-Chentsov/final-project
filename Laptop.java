import java.util.*;

public class Laptop {
    private String brand;
    private String model;
    private int ram;
    private int hddVolume;
    private String operatingSystem;
    private String color;
    private double price;

    public Laptop(String brand, String model, int ram, int hddVolume, String operatingSystem, String color,
                  double price) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.hddVolume = hddVolume;
        this.operatingSystem = operatingSystem;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRAM() {
        return ram;
    }

    public int getHDDVolume() {
        return hddVolume;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public static List<Laptop> filterLaptops(List<Laptop> laptops, Map<Integer, Object> filterParams) {
        List<Laptop> filteredLaptops = new ArrayList<>();
        for (Laptop laptop : laptops) {
            boolean passFilter = true;
            for (Map.Entry<Integer, Object> entry : filterParams.entrySet()) {
                switch (entry.getKey()) {
                    case 1:
                        if (laptop.getRAM() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case 2:
                        if (laptop.getHDDVolume() < (int) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                    case 3:
                        if (!laptop.getOperatingSystem().equals(entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                    case 4:
                        if (!laptop.getColor().equals(entry.getValue())) {
                            passFilter = false;
                        }
                        break;
                    case 5:
                        if (laptop.getPrice() > (double) entry.getValue()) {
                            passFilter = false;
                        }
                        break;
                }
            }
            if (passFilter) {
                filteredLaptops.add(laptop);
            }
        }
        return filteredLaptops;
    }

//    private static List<Laptop> filterLaptops(List<Laptop> laptops, Map<Integer, Integer> filterParams) {
//        List<Laptop> filteredLaptops = new ArrayList<>();
//
//        for (Laptop laptop : laptops) {
//            boolean matchesFilter = true;
//
//            for (Map.Entry<Integer, Integer> entry : filterParams.entrySet()) {
//                int criterionNumber = entry.getKey();
//                int minValue = entry.getValue();
//
//                switch (criterionNumber) {
//                    case 1:
//                        if (laptop.getRAM() < minValue) {
//                            matchesFilter = false;
//                        }
//                        break;
//                    case 2:
//                        if (laptop.getHDD
//
//                    case 1:
//                        System.out.println("Введите минимальный объем ОЗУ:");
//                        int ram = scanner.nextInt();
//                        filters.put("ram", ram);
//                        break;
//                    case 2:
//                        System.out.println("Введите минимальный объем ЖД:");
//                        int storage = scanner.nextInt();
//                        filters.put("storage", storage);
//                        break;
//                    case 3:
//                        System.out.println("Введите операционную систему:");
//                        String os = scanner.next();
//                        filters.put("os", os);
//                        break;
//                    case 4:
//                        System.out.println("Введите цвет:");
//                        String color = scanner.next();
//                        filters.put("color", color);
//                        break;
//                }
//
//                filterLaptops(laptops, filters);
//            }
//        }
//    }
}
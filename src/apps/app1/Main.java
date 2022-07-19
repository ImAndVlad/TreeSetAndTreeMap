package apps.app1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    // the address of the text file
    static String path = "C:\\Users\\38050\\Desktop\\IT - Hillel\\Projects" +
            "\\TreeSetAndTreeMap\\src\\apps\\app1\\urlsTest";

    // get duplicates size and urls with quantity repeat
    public static void main(String[] arg) throws FileNotFoundException {
        System.out.print("Size: " + getDuplicates(getList()).size());

        for (Map.Entry<String, Long> map : getDuplicates(getList()).entrySet()) {
            System.out.println("\n" + map);
        }
    }

    // method that returns a list and quantity repeating urls
    public static Map<String, Long> getDuplicates(List<String> list) {
        Map<String, Long> frequency =
                list.stream().collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting()));

        Map<String, Long> duplicates = new TreeMap<>();
        for (Map.Entry<String, Long> map : frequency.entrySet()) {
            if (map.getValue() >= 63)
                duplicates.put(map.getKey(), map.getValue());
        }
        return duplicates;
    }

    // get list urls from urls.Test(text file)
    public static List<String> getList() throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        List<String> list = new ArrayList<>();

        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        scanner.close();

        return list;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package pb1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    public MainApp() {
    }

    public static Map<Integer, Carti> citire() {
        try {
            File file = new File("C:\\Users\\Aquiris\\IdeaProjects\\Laborator7\\src\\main\\resources\\carti.json");
            ObjectMapper mapper = new ObjectMapper();
            Map<Integer, Carti> carti = (Map)mapper.readValue(file, new TypeReference<Map<Integer, Carti>>() {});
            return carti;
        } catch (IOException var3) {
            IOException e = var3;
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Carti> carti = citire();
        Carti a = new Carti("Plansul lui Nitzsche", "Irvin Yalom", 1900);
        Set<Map.Entry<Integer, Carti>> set = carti.entrySet();
        Iterator var4 = set.iterator();

        while(var4.hasNext()) {
            Map.Entry<Integer, Carti> c = (Map.Entry)var4.next();
            System.out.println(c.toString());
        }

        carti.remove(1);
        System.out.println();
        set.stream().forEach(System.out::println);


        carti.putIfAbsent(1, a);
        System.out.println();
        set.stream().forEach(System.out::println);


        Set<Map.Entry<Integer, Carti>> cartiExtrase = set.stream().filter((carte) -> {
            return ((Carti)carte.getValue()).autorul().contains("Yuval Noah Harari");
        }).collect(Collectors.toSet());
        System.out.println();
        cartiExtrase.stream().forEach(System.out::println);





        System.out.println();
         set.stream().sorted(Entry.comparingByValue((d, b) -> {
            return d.titlul().compareToIgnoreCase(b.titlul());
        })).forEach(System.out::println );

        System.out.println();
        Optional<Map.Entry<Integer, Carti>> cartiVechi=set.stream().min(Comparator.comparingInt(entry -> entry.getValue().getAnul()));
        cartiVechi.ifPresent(System.out::println);
    }
}

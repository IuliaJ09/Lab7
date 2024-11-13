package pb2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class MainApp {
    public static void scriere(Set<InstrumentMuzical> instrumente) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file=new File("C:\\Users\\Aquiris\\IdeaProjects\\Laborator7\\src\\main\\resources\\instrumente.json");
            mapper.writeValue(file,instrumente);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Set<InstrumentMuzical>  citire() {
        try {
            File file=new File("C:\\Users\\Aquiris\\IdeaProjects\\Laborator7\\src\\main\\resources\\instrumente.json");
            ObjectMapper mapper=new ObjectMapper();
            Set<InstrumentMuzical> instrumente = mapper.readValue(file, new TypeReference<Set<InstrumentMuzical>>(){});
            return instrumente;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) {
        Set<InstrumentMuzical> instrumente=new HashSet<InstrumentMuzical>();
        instrumente.add(new Chitara("Gibson", 2500.0, TipChitara.ELECTRICA, 6));
        instrumente.add(new Chitara("Yamaha", 1500.0, TipChitara.ACUSTICA, 6));
        instrumente.add(new Chitara("Fender", 2000.0, TipChitara.CLASICA, 6));
        instrumente.add(new SetTobe("Roland", 3500.0, TipTobe.ELECTRONICE, 5, 2));
        instrumente.add(new SetTobe("Yamaha", 3000.0, TipTobe.ACUSTICE, 5, 3));
        instrumente.add(new SetTobe("Pearl", 4000.0, TipTobe.ACUSTICE, 7, 4));
        scriere(instrumente);
        Set<InstrumentMuzical> listaIn=citire();
        listaIn.forEach(System.out::println);
        listaIn.removeIf(instrument-> instrument.getPret()>3000.0);
        listaIn.forEach(System.out::println);
        listaIn.stream().filter(instrument-> instrument instanceof Chitara).map(instrument -> (Chitara) instrument ).forEach(System.out::println);
        listaIn.stream().filter(instrument-> instrument.getClass()== SetTobe.class).map(instrument -> (SetTobe) instrument).forEach(System.out::println);
        Optional<Chitara> c=listaIn.stream().filter(instrument-> instrument instanceof Chitara).map(instrument -> (Chitara) instrument).max(Comparator.comparingInt(chitara->chitara.getNrCorzi()));
        c.ifPresent(System.out::println);
        listaIn.stream().filter(instrument->instrument instanceof SetTobe).map(instrument -> (SetTobe) instrument).filter(instrument-> TipTobe.ACUSTICE==instrument.getTipTobe()).sorted((t1, t2) -> Integer.compare(t1.getNrTobe(), t2.getNrTobe())).forEach(System.out::println);
    }
}

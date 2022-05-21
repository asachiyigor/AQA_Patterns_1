package ru.netology.Data;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.Keys;

import java.io.*;
import java.util.*;

import static com.codeborne.selenide.Selenide.$;

@Data
public class DataGenerator {
    private static final Faker faker = new Faker(new Locale("ru"));
    static String city;
    public static String generateCity() throws IOException {

        city = faker.address()
                .city();
        return city;
    }

    public static String setNewCity() throws IOException {

        Set<String> set = new HashSet<String>();
        File file = new File("city.txt");

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            set.add(line);
        }
        int size = set.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for (Object obj : set) {
            if (i == item)
                return (String) obj;
            i++;
        }
        return String.valueOf(item);
    }

    public static String generateName() {
        String name = faker.name().name();
        String newName = name.replace("ё", "е");
        return newName;
    }
    public static String generatePhone() {
        return faker.number().digits(11);
    }
}
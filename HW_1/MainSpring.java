import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainSpring {
    public static void main(String[] args) throws FileNotFoundException {

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        PersonJdbcImpl personJdbc = context.getBean(PersonJdbcImpl.class);

        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> totems = new ArrayList<String>();
        FileInputStream name = new FileInputStream("names.txt");
        FileInputStream totem = new FileInputStream("totem.txt");
        Scanner name_sc = new Scanner(name);
        Scanner totem_sc = new Scanner(totem);

        while (name_sc.hasNextLine()) {
            String a = name_sc.nextLine();
            names.add(a);
        }

        while (totem_sc.hasNextLine()) {
            String a = totem_sc.nextLine();
            totems.add(a);
        }
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 20000000; i++) {
            int n = (int)Math.floor(Math.random() * names.size());
            int m = (int)Math.floor(Math.random() * totems.size());
            int c = (int)Math.floor(Math.random() * 30);
            Person person = new Person (names.get(n), totems.get(m), c);
            personJdbc.insert(person);
            //personJdbc.insertFromArrays(names, totems);
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}

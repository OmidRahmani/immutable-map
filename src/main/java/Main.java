import com.google.common.collect.ImmutableMap;
import models.Person;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Person> mutableMap = new HashMap<>();
        mutableMap.put(1, new Person(1L, "reza", "rahmani", 26));
        mutableMap.put(2, new Person(2L, "amir", "mozafari", 30));
        mutableMap.put(3, new Person(3L, "pedram", "adib", 29));

        // copyOf method
        ImmutableMap<Integer, Person> immutableCopyMap = ImmutableMap.copyOf(mutableMap);
        immutableCopyMap.get(1).setFirstName("omid");

        boolean hasOmid = immutableCopyMap.values()
                .stream()
                .anyMatch(a -> a.getFirstName().equals("omid"));
        System.out.println(hasOmid);


        // builder method
        ImmutableMap<Integer, Person> personImmutableMap = ImmutableMap.<Integer, Person>builder()
                .putAll(mutableMap)
                .put(10, new Person(10L, "jafar", "jafari", 100))
                .build();



        // "of" method
        ImmutableMap<String, String> of = ImmutableMap.of(
                "firstName" , "Omid",
                "lastName" , "rahmani",
                "age" , "29"
        );


        // multiple "of" methods
        List<ImmutableMap<String, String>> immutableMapList = Arrays.asList(
                ImmutableMap.of(
                        "firstName", "Omid",
                        "lastName", "rahmani",
                        "age", "29"
                ),
                ImmutableMap.of(
                        "firstName", "Yassin",
                        "lastName", "vali",
                        "age", "27"
                ),
                ImmutableMap.of(
                        "firstName", "Meysam",
                        "lastName", "zarezade",
                        "age", "28"
                )
        );

        boolean match = immutableMapList
                .stream()
                .anyMatch(member -> member.get("firstName").equals("Omid"));

        System.out.println(match);

    }// end of main method
}

package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupBySpecialization {

    public static void group(){
        List<String> oldSpecializations = new ArrayList<>();
        for(Person i:Main.persons){
            oldSpecializations.add(i.getSpecialization());
        }
        List<String> specializations = oldSpecializations.stream().distinct().collect(Collectors.toList());
        for(String spec:specializations){
            System.out.println(spec+":\n"+Main.persons.stream().filter((o) ->
                    o.getSpecialization().contains(spec)).collect(Collectors.toList()));
        }


    }
}

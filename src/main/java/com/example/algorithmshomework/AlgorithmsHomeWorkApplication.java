package com.example.algorithmshomework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class AlgorithmsHomeWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgorithmsHomeWorkApplication.class, args);
        StringList stringList = new StringListImpl();
        stringList.add("test1");// 0
        stringList.add("test2");//1
        stringList.add("test3");//2
        stringList.add("test4");//3
        // 1 2 3 4

        stringList.add(3, "test6");
        // 1 2 3 6 4

        stringList.remove(1);
        // 2 3 6 4

        System.out.println(Arrays.toString(stringList.toArray()));

        stringList.clear();
        System.out.println(stringList.size());
    }

}

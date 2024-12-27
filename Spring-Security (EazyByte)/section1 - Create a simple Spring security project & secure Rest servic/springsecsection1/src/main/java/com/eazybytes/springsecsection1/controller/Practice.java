package com.eazybytes.springsecsection1.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Practice {

    public static void main(String[] args) {

        int[] array = {20, 10, 20, 4, 100};


        List<Integer> max = Arrays.stream(array)
                .boxed()
                .sorted()
                .peek(System.out::println)
                .collect(Collectors.toList());


        System.out.println(max);

    }
}

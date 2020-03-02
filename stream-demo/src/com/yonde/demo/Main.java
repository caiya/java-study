package com.yonde.demo;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        String[] strings = {"admin", "caiya", "hello", "helawd"};
        Stream<String> stringStream = Stream.of(strings);
        stringStream.filter(s -> s.contains("c")).collect(Collectors.toList()).forEach(System.out:: println);
        Stream.iterate(10, n -> n * 2).limit(10).collect(Collectors.toList()).stream().map(s -> s + " ").collect(Collectors.toList()).forEach(System.out::println);
    }
}

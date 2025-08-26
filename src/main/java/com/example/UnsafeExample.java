package com.example;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UnsafeExample {
    
    public Map<String, String> createUnsafeMap(List<String> items) {
        // This should trigger the safety check warning
        return items.stream()
            .collect(Collectors.toMap(String::toLowerCase, Function.identity()));
    }
    
    public Map<Integer, String> anotherUnsafeMap(List<String> items) {
        // Another violation
        return items.stream()
            .collect(Collectors.toMap(String::length, s -> s));
    }

    public Map<String, String> createUnsafeMap2(List<String> items) {
        // This should trigger the safety check warning
        return items.stream()
            .collect(Collectors.toMap(String::toLowerCase, Function.identity()));
    }

}

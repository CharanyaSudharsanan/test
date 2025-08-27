package com.example;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SafeExample {
    
    public Map<String, String> createSafeMapKeepFirst(List<String> items) {
        // Safe usage: merge function keeps first value on duplicate keys
        return items.stream()
            .collect(Collectors.toMap(
                String::toLowerCase, 
                Function.identity(),
                (existing, replacement) -> existing  // Keep first value
            ));
    }
    
    public Map<String, String> createSafeMapKeepLast(List<String> items) {
        // Safe usage: merge function keeps last value on duplicate keys
        return items.stream()
            .collect(Collectors.toMap(
                String::toLowerCase, 
                Function.identity(),
                (existing, replacement) -> replacement  // Keep last value
            ));
    }
    
    public Map<Integer, String> createSafeMapWithExplicitError(List<String> items) {
        // Safe usage: explicit error handling for duplicates
        return items.stream()
            .collect(Collectors.toMap(
                String::length, 
                s -> s,
                (existing, replacement) -> { 
                    throw new IllegalStateException("Duplicate key found: " + existing + " vs " + replacement); 
                }
            ));
    }
    
    public Map<String, String> createSafeMapConcatenate(List<String> items) {
        // Safe usage: merge function concatenates values on duplicate keys
        return items.stream()
            .collect(Collectors.toMap(
                String::toLowerCase, 
                Function.identity(),
                (existing, replacement) -> existing + "," + replacement
            ));
    }
    
    // This method doesn't use Collectors.toMap() at all - should be fine
    public Map<String, String> createMapWithoutCollectors(List<String> items) {
        Map<String, String> result = new java.util.HashMap<>();
        for (String item : items) {
            result.put(item.toLowerCase(), item);
        }
        return result;
    }
}

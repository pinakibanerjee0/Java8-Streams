package com.pinaki.streamAPI.interviewQA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterOddAndEven {
    public static void main(String[] args) 
    {
        List<Integer> listOfIntegers = 
        Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
         
        Map<Boolean, List<Integer>> oddEvenNumbersMap = 
                listOfIntegers.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0));
                  
        for (Entry<Boolean, List<Integer>> entry : oddEvenNumbersMap.entrySet()) 
        {
            System.out.println("--------------");           
            if (entry.getKey())
            {
                System.out.println("Even Numbers");
            }
            else
            {
                System.out.println("Odd Numbers");
            }           
            System.out.println("--------------");
             
            List<Integer> list = entry.getValue();
             
            for (int i : list)
            {
                System.out.println(i);
            }
        }
        System.out.println("Duplicate numbers are : ");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1, 2, 3);

        Set<Integer> duplicates = new HashSet<>();

        numbers.stream()
                .filter(n -> !duplicates.add(n))
                .forEach(System.out::println);
    
    }

}

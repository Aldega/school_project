package lesson_11;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class BloomFilterTest {

    @Test
    void hash1() {
        BloomFilter bloomFilter = new BloomFilter(32);
        List<String> strings = Stream.of("0123456789"
                , "1234567890"
                , "2345678901"
                , "3456789012"
                , "4567890123"
                , "5678901234"
                , "6789012345"
                , "7890123456"
                , "8901234567"
                , "9012345678").collect(toList());

        for (int i = 0; i < strings.size(); i++) {

            System.out.println(i);
            System.out.println(bloomFilter.hash1(strings.get(i)));
            System.out.println(bloomFilter.hash2(strings.get(i)));
            System.out.println(bloomFilter.isValue(strings.get(i)));
            bloomFilter.add(strings.get(i));
            System.out.println(bloomFilter.isValue(strings.get(i)));
            System.out.println(Integer.toBinaryString(bloomFilter.bitArray) + "\n");
        }

    }

    @Test
    void hash2() {
    }

    @Test
    void add() {
    }

    @Test
    void isValue() {
    }
}
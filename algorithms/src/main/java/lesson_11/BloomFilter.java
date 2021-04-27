package lesson_11;

public class BloomFilter {

    public int filter_len;
    public int bitArray = 0;

    // создаём битовый массив длиной f_len ...
    public BloomFilter(int f_len) {
        filter_len = f_len;
    }

    // хэш-функции
    public int hash1(String str1) {
        return hash(str1, 17);
    }

    public int hash2(String str1) {
        return hash(str1, 223);
    }

    public void add(String str1) {
        bitArray = bitArray | (1 << hash1(str1)) | (1 << hash2(str1));
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        return (bitArray & (1 << hash1(str1))) != 0 && (bitArray & (1 << hash2(str1))) != 0;
    }

    private int hash(String str1, int randomValue) {
        int code = 0;
        for (int i = 0; i < str1.length(); i++) {
            code = Math.abs(code * randomValue + (int) str1.charAt(i));
        }
        return code % filter_len;
    }
}

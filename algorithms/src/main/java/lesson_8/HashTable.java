package lesson_8;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        return value.hashCode() % size;
    }

    public int seekSlot(String value) {
        int firstSlot = hashFun(value);
        int index = firstSlot;

        while (!isOverhead(index, firstSlot)) {
            int slot = getSlot(index);
            if (slots[slot] == null) {
                return slot;
            }
            index = index + step;
        }
        return -1;
    }

    public int put(String value) {
        // записываем значение по хэш-функции

        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
        return -1;
    }

    public int find(String value) {
        // находит индекс слота со значением, или -1
        return -1;
    }

    private int getCicleCount(int index) {
        return index / size;
    }

    private int getSlot(int index) {
        return index % size;
    }

    private boolean isOverhead(int index, int firstSlot) {
        return getCicleCount(index) >= 1 && getSlot(index) >= firstSlot;
    }
}

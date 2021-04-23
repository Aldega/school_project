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
        return Math.abs(value.hashCode()) % size;
    }

    public int seekSlot(String value) {
        int firstSlot = hashFun(value);
        int index = firstSlot;

        while (isNotOverhead(index, firstSlot)) {
            int slot = getSlot(index);
            if (slots[slot] == null) {
                return slot;
            }
            index = index + step;
        }
        return -1;
    }

    public int put(String value) {
        int slot = seekSlot(value);

        if (slot != -1) {
            slots[slot] = value;
        }

        return slot;
    }

    public int find(String value) {

        int firstSlot = hashFun(value);
        int index = firstSlot;

        while (isNotOverhead(index, firstSlot)) {
            int slot = getSlot(index);
            if (value.equals(slots[slot])) {
                return slot;
            }
            index = index + step;
        }
        return -1;
    }

    private int getCicleCount(int index) {
        return index / size;
    }

    private int getSlot(int index) {
        return index % size;
    }

    private boolean isNotOverhead(int index, int firstSlot) {
        return getCicleCount(index) < 1 || getSlot(index) < firstSlot;
    }
}

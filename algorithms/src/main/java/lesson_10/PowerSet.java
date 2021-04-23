package lesson_10;

public class PowerSet {

    public HashTable hashTable;
    public int size;

    public PowerSet() {
        this.hashTable = new HashTable();
        this.size = 0;
    }

    // количество элементов в множестве
    public int size() {
        return size;
    }

    // всегда срабатывает
    public void put(String value) {
        hashTable.put(value);
        size++;
    }

    // возвращает true если value имеется в множестве,
    // иначе false
    public boolean get(String value) {
        return hashTable.find(value) != -1;
    }

    // возвращает true если value удалено
    // иначе false
    public boolean remove(String value) {

        int i = hashTable.find(value);

        if (i == -1) return false;

        hashTable.slots[i] = null;
        size--;
        return true;
    }

    // пересечение текущего множества и set2
    public PowerSet intersection(PowerSet set2) {
        if (set2 == null || set2.size() == 0 || this.size() == 0) return new PowerSet();

        PowerSet a = this;
        PowerSet b = set2;

        PowerSet littleSet;
        PowerSet bigSet;
        if (a.size() != b.size()) {
            littleSet = chooseSetWithMinimumElements(a, b);
            bigSet = chooseSetWithMaximumElements(a, b);
        } else {
            littleSet = a;
            bigSet = b;
        }

        PowerSet result = new PowerSet();

        String[] slots = littleSet.hashTable.slots;
        for (String slot : slots) {
            if (slot != null && bigSet.get(slot)) {
                result.put(slot);
            }
        }
        return result;
    }

    // объединение текущего множества и set2
    public PowerSet union(PowerSet set2) {

        PowerSet result = new PowerSet();
        if (this.size() > 0) {
            String[] slots = this.hashTable.slots;
            System.arraycopy(slots, 0, result.hashTable.slots, 0, slots.length);
            result.size = this.size;
        }
        if (set2 != null && set2.size() > 0) {
            for (String slot : set2.hashTable.slots) {
                if (slot != null) result.put(slot);
            }
        }

        return result;
    }

    // разница текущего множества и set2
    public PowerSet difference(PowerSet set2) {

        PowerSet result = new PowerSet();
        if (this.size() > 0) {
            String[] slots = this.hashTable.slots;
            System.arraycopy(slots, 0, result.hashTable.slots, 0, slots.length);
            result.size = this.size;
        }

        if (set2 == null || set2.size() == 0) return result;

        for (String slot : set2.hashTable.slots) {
            if (slot != null) {
                result.remove(slot);
            }
        }

        return result;
    }

    // возвращает true, если set2 есть
    // подмножество текущего множества,
    // иначе false
    public boolean isSubset(PowerSet set2) {
        if (set2 == null || set2.size() == 0) return true;

        if (set2.size() > this.size()) return false;

        for (String slot : set2.hashTable.slots) {
            if (slot != null && !this.get(slot)) return false;
        }
        return true;
    }

    private PowerSet chooseSetWithMinimumElements(PowerSet a, PowerSet b) {
        if (a.size() < b.size()) return a;
        return b;
    }

    private PowerSet chooseSetWithMaximumElements(PowerSet a, PowerSet b) {
        if (a.size() > b.size()) return a;
        return b;
    }
}

class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable() {
        size = 20_000;
        step = 3;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        return Math.abs(value.hashCode()) % size;
    }

    public int seekSlot(String value) {
        if (value == null) return -1;

        int normalIndexForKey = hashFun(value);

        int stepCount = 0;
        int index = normalIndexForKey;
        while (stepCount < size) {
            //если по данному индексу пусто, добавляем ключ и значение в него.
            //или если слот уже занят этим ключом
            int slot = index % size;
            if (slots[slot] == null || value.equals(slots[slot])) {
                return slot;
            }
            stepCount = stepCount + 1;
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
        if (value == null) return -1;

        int normalIndexForKey = hashFun(value);

        int stepCount = 0;
        int index = normalIndexForKey;
        while (stepCount < size) {

            int slot = index % size;
            // если в данном слоте пусто, то дальше не ищем
            if (slots[slot] == null) {
                return -1;
            }
            // если в данном слоте не пусто, то возможно это наш случай
            if (value.equals(slots[slot])) {
                return slot;
            }
            stepCount = stepCount + 1;
            index = index + step;
        }

        return -1;
    }
}

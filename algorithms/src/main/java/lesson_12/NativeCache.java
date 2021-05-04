package lesson_12;

import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public String [] slots;
    public T [] values;
    public int [] hits;

    private final int step = 3;

    private int count = 0;

    public NativeCache(int size, Class clazz) {
        this.size = size;
        this.slots = new String[size];
        this.hits = new int[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
    }

    // всегда возвращает корректный индекс слота
    public int hashFun(String key) {
        return Math.abs(key.hashCode()) % size;
    }

    // возвращает true если ключ имеется,
    // иначе false
    public boolean isKey(String key) {
        if (key == null) return false;

        int normalIndexForKey = hashFun(key);

        int stepCount = 0;
        int index = normalIndexForKey;
        while (stepCount < size) {

            int slot = index % size;
            // если в данном слоте пусто, то дальше не ищем
            if (slots[slot] == null) {
                return false;
            }
            // если в данном слоте не пусто, то возможно это наш случай
            if (key.equals(slots[slot])) {
                return true;
            }
            stepCount = stepCount + 1;
            index = index + step;
        }

        return false;
    }

    // гарантированно записываем
    // значение value по ключу key
    public void put(String key, T value) {
        if (key == null) return;
        int minimumHitsSlot = -1;
        if (isFool()) {
            minimumHitsSlot = getMinimumHitsSlot();
        }

        //cначала пытаемся поместить как обычно
        int normalIndexForKey = hashFun(key);

        int stepCount = 0;
        int index = normalIndexForKey;

        while (stepCount < size) {
            //если по данному индексу пусто, добавляем ключ и значение в него.
            //или если слот уже занят этим ключом
            int slot = index % size;
            if (slots[slot] == null) {
                assignKeyValueToSlot(key, value, slot);
                count = count + 1;
                return;
            }
            if (key.equals(slots[slot])) {
                assignKeyValueToSlot(key, value, slot);
                return;
            }
            stepCount = stepCount + 1;
            index = index + step;
        }

        //если не получилось, как обычно, добавляем в минимальный слот
        if (minimumHitsSlot != -1) {
            assignKeyValueToSlot(key, value, minimumHitsSlot);
        }
    }

    // возвращает value для key,
    // или null если ключ не найден
    public T get(String key) {
        if (key == null) return null;

        int normalIndexForKey = hashFun(key);

        int stepCount = 0;
        int index = normalIndexForKey;
        while (stepCount < size) {

            int slot = index % size;
            // если в данном слоте пусто, то дальше не ищем
            if (slots[slot] == null) {
                return null;
            }
            // если в данном слоте не пусто, то возможно это наш случай
            if (key.equals(slots[slot])) {
                hits[slot] = hits[slot] + 1;
                return values[slot];
            }
            stepCount = stepCount + 1;
            index = index + step;
        }

        return null;
    }

    private boolean isFool() {
        return size == count;
    }

    private void assignKeyValueToSlot(String key, T value, int slot) {
        slots[slot] = key;
        values[slot] = value;
        hits[slot] = 0;
    }

    private int getMinimumHitsSlot() {

        int minimumSlot = 0;
        for (int i = 1; i < hits.length; i++) {
            if (hits[i] < hits[minimumSlot]) {
                minimumSlot = i;
            }
        }
        return minimumSlot;
    }

}

package lesson_9;

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    private final int step = 3;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
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

        int normalIndexForKey = hashFun(key);

        int stepCount = 0;
        int index = normalIndexForKey;
        while (stepCount < size) {
            //если по данному индексу пусто, добавляем ключ и значение в него.
            //или если слот уже занят этим ключом
            int slot = index % size;
            if (slots[slot] == null || key.equals(slots[slot])) {
                slots[slot] = key;
                values[slot] = value;
                return;
            }
            stepCount = stepCount + 1;
            index = index + step;
        }

        //если свободных мест нет, не добавляем
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
                return values[slot];
            }
            stepCount = stepCount + 1;
            index = index + step;
        }

        return null;
    }

}

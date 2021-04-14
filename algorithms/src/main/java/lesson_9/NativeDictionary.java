package lesson_9;

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
    }

    // всегда возвращает корректный индекс слота
    public int hashFun(String key) {
        return key.hashCode() % size;
    }

    // возвращает true если ключ имеется,
    // иначе false
    public boolean isKey(String key) {
        if (key == null) return false;

        int slot = hashFun(key);

        return key.equals(slots[slot]);
    }

    // гарантированно записываем
    // значение value по ключу key
    public void put(String key, T value) {
        if (key == null) return;

        int slot = hashFun(key);
        slots[slot] = key;
        values[slot] = value;
    }

    // возвращает value для key,
    // или null если ключ не найден
    public T get(String key) {
        if (key == null) return null;

        int slot = hashFun(key);
        if (key.equals(slots[slot])) {
            return values[slot];
        }
        return null;
    }

}

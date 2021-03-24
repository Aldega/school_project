package lesson_3;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

    private final double FILL_PERCENTAGE = 0.5d;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);

        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity)
    {
        T [] newArray = (T[]) java.lang.reflect.Array.newInstance(this.clazz, new_capacity);
        for (int i = 0; i < count; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        capacity = new_capacity;
    }

    private void expand() {
        int newCapacity = capacity * 2;
        makeArray(newCapacity);
    }

    private void compress() {
        int newCapacity = Math.max((int) (capacity / 1.5), 16);
        makeArray(newCapacity);
    }

    public T getItem(int index)
    {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();
        return array[index];
    }

    public void append(T itm)
    {
        if (count == capacity) {
            expand();
        }
        array[count] = itm;
        count = count + 1;
    }

    public void insert(T itm, int index)
    {
        if (index < 0 || index > count) throw new IndexOutOfBoundsException();

        if (count == capacity) {
            expand();
        }
        for (int i = index; i <= count; i++) {
            T temp = array[i];
            array[i] = itm;
            itm = temp;
        }
        count = count + 1;
    }

    public void remove(int index)
    {
        if (index < 0 || index >= count) throw new IndexOutOfBoundsException();

        for (int i = index; i < count - 1; i++) {
            array[i] = array[i + 1];
        }
        count = count - 1;

        if (count * 1.0d / capacity < FILL_PERCENTAGE) {
            compress();
        }
    }

}

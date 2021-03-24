package lesson_3;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    Class clazz;

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

    public T getItem(int index)
    {
        // ваш код
        return null;
    }

    public void append(T itm)
    {
        // ваш код
    }

    public void insert(T itm, int index)
    {
        // ваш код
    }

    public void remove(int index)
    {
        // ваш код
    }

}

package lesson_12;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class NativeCacheTest {

    @Test
    void emptyNativeCache() {
        NativeCache<String> nativeCache = new NativeCache<>(199, String.class);
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            assertFalse(nativeCache.isKey(uuid));
            assertNull(nativeCache.get(uuid));
        }
    }

    @Test
    void putLessLimit() {
        NativeCache<String> nativeCache = new NativeCache<>(199, String.class);
        List<String> uuids = createListOfUniqStrings(100);
        for (String uuid : uuids) {
            nativeCache.put(uuid, uuid);
            assertTrue(nativeCache.isKey(uuid));
            assertEquals(uuid, nativeCache.get(uuid));
        }
        for (String uuid : uuids) {
            assertTrue(nativeCache.isKey(uuid));
            assertEquals(uuid, nativeCache.get(uuid));
        }

        for (String uuid : uuids) {
            int slot = findSlotInStructureByKey(nativeCache, uuid);
            assertNotEquals(-1, slot);
            assertEquals(nativeCache.slots[slot], nativeCache.values[slot]);
            assertEquals(2, nativeCache.hits[slot]);
        }
    }
    @Test
    void putForLimit() {
        NativeCache<String> nativeCache = new NativeCache<>(200, String.class);
        List<String> uuids = createListOfUniqStrings(250);
        System.out.println("Created values");
        for (int i = 0; i < uuids.size(); i++) {
            System.out.println(i + ") " + uuids.get(i));
        }


        //hits [1 ... 200]
        //index [0 ... 199]
        //Записываем первые 200 значений из листа и делаем количесво запросов равное индексу листа
        for (int index = 0; index < 200; index++) {
            nativeCache.put(uuids.get(index), uuids.get(index));
            int slot = findSlotInStructureByKey(nativeCache, uuids.get(index));
            assertNotEquals(-1, slot);
            assertEquals(nativeCache.slots[slot], nativeCache.values[slot]);
            assertEquals(0, nativeCache.hits[slot]);
            for (int hit = 1; hit <= index + 1; hit++) {
                assertEquals(uuids.get(index), nativeCache.get(uuids.get(index)));
                assertTrue(nativeCache.isKey(uuids.get(index)));
                assertEquals(hit, nativeCache.hits[slot]);
            }
        }

        System.out.println("\n\nValues in cache");
        for (int i = 0; i < nativeCache.size; i++) {
            System.out.println("index " + i + ") hits=" + nativeCache.hits[i] + " slot=" + nativeCache.slots[i] + " value=" + nativeCache.values[i]);
        }

        //index [200 ... 249]
        //hits [200 ... 249]
        //Записываем оставшиеся 50 значений из листа, которые будут затирать самые редкопосещаемые записи
        for (int index = 200; index < uuids.size(); index++) {
            //проверяем, что редкие записи на месте (index [0 ... 49])
            int oldValueSlot = findSlotInStructureByKey(nativeCache, uuids.get(index - 200));
            assertNotEquals(-1, oldValueSlot);
            assertEquals(uuids.get(index - 200),  nativeCache.values[oldValueSlot]);
            assertTrue( nativeCache.isKey(uuids.get(index - 200)));

            //помещаем новую запись на место редкопосещаемой
            nativeCache.put(uuids.get(index), uuids.get(index));
            int newValueSlot = findSlotInStructureByKey(nativeCache, uuids.get(index));
            System.out.println("Добавил в слот " + newValueSlot + " значение " + uuids.get(index));
            for (int hit = 1; hit < index + 1; hit++) {
                assertEquals(uuids.get(index), nativeCache.get(uuids.get(index)));
                assertTrue(nativeCache.isKey(uuids.get(index)));
                assertEquals(hit, nativeCache.hits[newValueSlot]);

            }

            //проверяем, что редкой записи больше нет
            int oldNotExistValueSlot = findSlotInStructureByKey(nativeCache, uuids.get(index - 200));
            assertEquals(-1, oldNotExistValueSlot);
            assertNull( nativeCache.get(uuids.get(index - 200)));
            assertFalse( nativeCache.isKey(uuids.get(index - 200)));



        }

    }


    public String findValuesForCollision(String key, int size) {
        int index = key.hashCode() % size;

        String uuid = UUID.randomUUID().toString();
        while (index != uuid.hashCode() % size) {
            uuid = UUID.randomUUID().toString();
        }
        return uuid;
    }

    private List<String> createListOfUniqStrings(int size) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < size; i++) {
            result.add(UUID.randomUUID().toString() + " " + LocalTime.now().toString());
        }
        return new ArrayList<>(result);
    }

    private int findSlotInStructureByKey(NativeCache nativeCache, String key) {
        for (int i = 0; i < nativeCache.size; i++) {
            if (key.equals(nativeCache.slots[i])) return i;
        }
        return -1;
    }
}
package lesson_10;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class PowerSetTest {

    @Test
    void size() {
    }

    @Test
    void put() {
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
        PowerSet set = new PowerSet();

        //удаление несуществующего элемента
        for (int i = 0; i < 20_000; i++) {
            String s = UUID.randomUUID().toString();
            assertEquals(0, set.size());
            assertFalse(set.get(s));
            assertFalse(set.remove(s));
            assertFalse(set.get(s));
            assertEquals(0, set.size());
        }

        List<String> notExistedKey = createListOfUniqStrings(10_000);
        List<String> existedKey = createListOfUniqStrings(19_000);

        for (String item : existedKey) {
            assertFalse(set.get(item));
            set.put(item);
            assertTrue(set.get(item));
        }
        assertEquals(19_000, set.size());

        for (String s : notExistedKey) {
            assertFalse(set.get(s));
            assertFalse(set.remove(s));
        }
        assertEquals(19_000, set.size());

        for (String s : existedKey) {
            assertTrue(set.get(s));
            assertTrue(set.remove(s));
            assertFalse(set.get(s));
        }
        assertEquals(0, set.size());

        for (String item : notExistedKey) {
            assertFalse(set.get(item));
            set.put(item);
            assertTrue(set.get(item));
        }
        assertEquals(10_000, set.size());






    }

    @Test
    void intersection() {
        List<String> list1 = createListOfUniqStrings(10_000);
        List<String> list2 = createListOfUniqStrings(9_000);
        List<String> list3 = createListOfUniqStrings(2_000);

        PowerSet a = new PowerSet();
        list1.forEach(a::put);

        PowerSet b = new PowerSet();
        list2.forEach(b::put);

        PowerSet emptySet = new PowerSet();
        PowerSet intersectWithEmpty = a.intersection(emptySet);
        PowerSet intersectWithEmpty2 = emptySet.intersection(a);
        PowerSet selfEmptyIntersection = emptySet.intersection(emptySet);

        assertEquals(0, intersectWithEmpty.size());
        assertEquals(0, intersectWithEmpty2.size());
        assertEquals(0, selfEmptyIntersection.size());

        PowerSet emptyIntersection = a.intersection(b);
        for (String s : list2) {
            assertFalse(emptyIntersection.get(s));
        }
        for (String s : list1) {
            assertFalse(emptyIntersection.get(s));
        }

        emptyIntersection = b.intersection(a);
        for (String s : list2) {
            assertFalse(emptyIntersection.get(s));
        }
        for (String s : list1) {
            assertFalse(emptyIntersection.get(s));
        }

        list3.forEach(a::put);
        list3.forEach(b::put);

        PowerSet notEmptyIntersection = a.intersection(b);
        PowerSet notEmptyIntersection2 = b.intersection(a);

        list3.forEach(value -> {
            assertTrue(notEmptyIntersection.get(value));
            assertTrue(notEmptyIntersection2.get(value));
        });
        list2.forEach(value -> {
            assertFalse(notEmptyIntersection.get(value));
            assertFalse(notEmptyIntersection2.get(value));
        });
        list1.forEach(value -> {
            assertFalse(notEmptyIntersection.get(value));
            assertFalse(notEmptyIntersection2.get(value));
        });

        PowerSet aSelfIntersection = a.intersection(a);
        list1.forEach(value -> {
            assertTrue(aSelfIntersection.get(value));
        });
        list3.forEach(value -> {
            assertTrue(aSelfIntersection.get(value));
        });
    }

    @Test
    void union() {
        List<String> list1 = createListOfUniqStrings(10_000);
        List<String> list2 = createListOfUniqStrings(9_000);

        PowerSet a = new PowerSet();
        list1.forEach(a::put);

        PowerSet unionSelf = a.union(a);
        list1.forEach(value -> assertTrue(unionSelf.get(value)));
        assertEquals(a.size(), unionSelf.size());

        PowerSet emptySet = new PowerSet();
        PowerSet emptySelfSetUnion = emptySet.union(emptySet);
        assertEquals(0, emptySelfSetUnion.size());

        PowerSet aUnionEmptySet = a.union(emptySet);
        PowerSet emptySetUnionA = emptySet.union(a);

        assertEquals(list1.size(), aUnionEmptySet.size());
        assertEquals(list1.size(), emptySetUnionA.size());

        list1.forEach(value -> {
            assertTrue(aUnionEmptySet.get(value));
            assertTrue(emptySetUnionA.get(value));
        });

        list1.forEach(value -> {
            assertTrue(aUnionEmptySet.remove(value));
            assertTrue(emptySetUnionA.remove(value));
        });

        assertEquals(0, aUnionEmptySet.size());
        assertEquals(0, emptySetUnionA.size());

        list1.forEach(value -> {
            assertFalse(aUnionEmptySet.get(value));
            assertFalse(emptySetUnionA.get(value));
        });



        PowerSet b = new PowerSet();
        list2.forEach(b::put);

        PowerSet aUnionBSet = a.union(b);
        PowerSet bUnionASet = b.union(a);
        assertEquals(a.size() + b.size(), aUnionBSet.size());
        assertEquals(a.size() + b.size(), bUnionASet.size());

        list1.forEach(value -> {
            assertTrue(aUnionBSet.get(value));
            assertTrue(bUnionASet.get(value));
        });

        list2.forEach(value -> {
            assertTrue(aUnionBSet.get(value));
            assertTrue(bUnionASet.get(value));
        });

        list1.forEach(value -> {
            assertTrue(aUnionBSet.remove(value));
            assertTrue(bUnionASet.remove(value));
        });
        assertEquals(b.size(), aUnionBSet.size());
        assertEquals(b.size(), bUnionASet.size());

        list2.forEach(value -> {
            assertTrue(aUnionBSet.remove(value));
            assertTrue(bUnionASet.remove(value));
        });

        assertEquals(0, aUnionBSet.size());
        assertEquals(0, bUnionASet.size());

        list1.forEach(value -> {
            assertFalse(aUnionBSet.get(value));
            assertFalse(bUnionASet.get(value));
        });

        list2.forEach(value -> {
            assertFalse(aUnionBSet.get(value));
            assertFalse(bUnionASet.get(value));
        });

    }

    @Test
    void difference() {
        List<String> list1 = createListOfUniqStrings(3_000);
        List<String> list2 = createListOfUniqStrings(4_000);
        List<String> list3 = createListOfUniqStrings(5_000);

        //пустой - пустой = пустой
        PowerSet differenceEmptyEmpty = new PowerSet().difference(new PowerSet());
        assertEquals(0, differenceEmptyEmpty.size());
        for (Node slot : differenceEmptyEmpty.hashTable.slots) {
            assertNull(slot);
        }

        //полный - пустой = полный
        PowerSet notEmpty1 = new PowerSet();
        list1.forEach(notEmpty1::put);

        PowerSet notEmpty1MinusEmpty = notEmpty1.difference(new PowerSet());
        assertEquals(notEmpty1.size(), notEmpty1MinusEmpty.size());
        list1.forEach(value -> assertTrue(notEmpty1MinusEmpty.get(value)));

        //пустой - полный = пустой
        PowerSet emptyMinusNotEmpty1 = new PowerSet().difference(notEmpty1);
        assertEquals(0, emptyMinusNotEmpty1.size());
        list1.forEach(value -> assertFalse(emptyMinusNotEmpty1.get(value)));

        //полный1 - полный1 = пустой
        PowerSet selfNotEmptyDifference = notEmpty1.difference(notEmpty1);
        assertEquals(0, emptyMinusNotEmpty1.size());
        list1.forEach(value -> assertFalse(emptyMinusNotEmpty1.get(value)));

        //(полный1 + полный2) - (полный2 + полный3) = полный1
        PowerSet notEmpty2 = new PowerSet();
        list2.forEach(notEmpty2::put);
        PowerSet notEmpty3 = new PowerSet();
        list3.forEach(notEmpty3::put);

        PowerSet difference = notEmpty1.union(notEmpty2).difference(notEmpty2.union(notEmpty3));
        assertEquals(list1.size(), difference.size());
        list1.forEach(value -> assertTrue(difference.get(value)));
        list2.forEach(value -> assertFalse(difference.get(value)));
        list3.forEach(value -> assertFalse(difference.get(value)));
    }

    @Test
    void isSubset() {
        List<String> list1 = createListOfUniqStrings(3_000);
        List<String> list2 = createListOfUniqStrings(4_000);
        List<String> list3 = createListOfUniqStrings(5_000);

        PowerSet powerSet1 = new PowerSet();
        PowerSet powerSet2 = new PowerSet();
        PowerSet powerSet3 = new PowerSet();
        list1.forEach(powerSet1::put);
        list2.forEach(powerSet2::put);
        list3.forEach(powerSet3::put);

        //пустой подмножество пустого
        assertTrue(new PowerSet().isSubset(new PowerSet()));
        //пустой подмножество полного
        assertTrue(powerSet1.isSubset(new PowerSet()));
        //полный не подмножество пустого
        assertFalse(new PowerSet().isSubset(powerSet1));

        //полный1 подмножество полный1
        assertTrue(powerSet1.isSubset(powerSet1));
        //полный1+полный2 не подмножество полный1
        assertFalse(powerSet1.isSubset(powerSet1.union(powerSet2)));
        //полный1 подмножество полный1+полный2
        assertTrue(powerSet1.union(powerSet2).isSubset(powerSet1));
    }

    private List<String> createListOfUniqStrings(int size) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < size; i++) {
            result.add(UUID.randomUUID().toString() + " " + LocalDateTime.now().toString());
        }
        return new ArrayList<>(result);
    }
}
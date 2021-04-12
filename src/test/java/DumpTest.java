import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class DumpTest {
    @Test
    public void testGetRandomDetails() {
        int quantity = 20;
        int size = Dump.getRandomDetails(quantity).size();
        assertEquals(quantity, size);
    }

    @Test
    public void testAdd() {
        int from = 1;
        int to = 4;
        int random = (int) (Math.random() * (to - from + 1) + from);
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < 100 || set.size() == 4; i++) {
            assertTrue(random > 0 && random < 5);
            set.add((int) (Math.random() * (to - from + 1) + from));
        }
        assertEquals(4,set.size());
    }
    @Test
    public void testTake(){
        Map<Details,Details> map = new HashMap<>();
        map.put(Details.BODY,Details.BODY);
        Details detail = map.get(Details.BODY);
        map.get(Details.BODY).incrimination();
        assertNotEquals(map.get(Details.BODY).getCount(),map.get(Details.BODY).getCount());
    }

}
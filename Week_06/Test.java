public class Test {
    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1,1);
        lru.put(2,2);
        
        System.out.println(lru.get(1));
        lru.put(3, 3);
        System.out.println(lru.get(2));

        


//        for (int i = 1; i <= 4; i++) {
//            int value = lru.get(i);
//            System.out.println(value);
//        }

    }
}

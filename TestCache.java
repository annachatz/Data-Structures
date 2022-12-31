public class TestCache {
    public static void main(String[] args){
        System.out.println("Going to test the LRU "
                + " Cache Implementation");
        CacheImpl cache = new CacheImpl(2);
        cache.store(1,10);
        cache.store(1,20);
        System.out.println("Value for the key: 1 is " + cache.lookUp(1));
        cache.store(3, 30);

        System.out.println("Value for the key: 2 is " + cache.lookUp(2));
//        String x = "9";
//        System.out.println(((Object)x).getClass().getSimpleName().equals("Integer"));
//        System.out.println(((Object)x).getClass().getSimpleName());

//        cache.store(4,40);
//        System.out.println("Value for the key: 1 is " + cache.lookUp(1));
//        System.out.println("Value for the key: 3 is " + cache.lookUp(3));
//        System.out.println("Value for the key: 4 is " + cache.lookUp(4));

    }
}

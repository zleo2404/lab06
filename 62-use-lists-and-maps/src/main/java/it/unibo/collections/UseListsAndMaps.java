package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */

         ArrayList<Integer> list = new ArrayList<>();
         for(int i=1000; i<2000;i++){

            list.add(i);

         }
         //System.out.println(list.toString());

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
         LinkedList<Integer> linked = new LinkedList<>();
         linked.addAll(list);
         //System.out.println(linked.toString());
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
         int tmp = list.get(list.size()-1);
         list.set(list.size()-1, list.get(0));
         list.set(0, tmp);

        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */

         for(int elem : list){
            System.out.println(elem);
         }

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */

         long time = System.nanoTime();

         for(int i=0; i< 100000;i++){
            list.addFirst(i);
            linked.addFirst(i);
         }
         time = System.nanoTime() - time;
         final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Inserting 100000 elements "
                + " in a list and in a linkedlist took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */

         time = System.nanoTime();

         for(int i=0; i< 1000;i++){
            list.get(list.get((list.size()-1)/2));
            linked.get(linked.get((linked.size()-1)/2));
         }

         time = System.nanoTime() - time;
         final var millis1 = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading 1000 elements "
                + " in a list and in a linkedlist took "
                + time
                + "ns ("
                + millis1
                + "ms)"
        );

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */

         Map<String,Long> m = new HashMap<>();
         m.put("Africa", 110635000L);
         m.put("Africa", 110635000L);
         m.put("Americas", 972005000L);
         m.put("Antartica", 0L);
         m.put("Asia", 4298723000L);
         m.put("Europe", 742452000L);
         m.put("Oceania", 38304000L);
         

        /*
         * 8) Compute the population of the world
         */
         long calcolo =0;
         for(String key : m.keySet()){
            calcolo += m.get(key);
         }
         System.out.println(calcolo);

        
    }
}

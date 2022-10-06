package edu.neu.coe.info6205.threesum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * Implementation of ThreeSum which follows the approach of dividing the solution-space into
 * N sub-spaces where each sub-space corresponds to a fixed value for the middle index of the three values.
 * Each sub-space is then solved by expanding the scope of the other two indices outwards from the starting point.
 * Since each sub-space can be solved in O(N) time, the overall complexity is O(N^2).
 * <p>
 * The array provided in the constructor MUST be ordered.
 */
public class ThreeSumQuadraticWithCalipers implements ThreeSum {
    /**
     * Construct a ThreeSumQuadratic on a.
     *
     * @param a a sorted array.
     */
    public ThreeSumQuadraticWithCalipers(int[] a) {
        this.a = a;
        length = a.length;
    }

    /**
     * Get an array or Triple containing all of those triples for which sum is zero.
     *
     * @return a Triple[].
     */
    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        Collections.sort(triples); // ???
        for (int i = 0; i < length - 2; i++)
            triples.addAll(calipers(a, i, Triple::sum));
        return triples.stream().distinct().toArray(Triple[]::new);
    }

    /**
     * Get a set of candidate Triples such that the first index is the given value i.
     * Any candidate triple is added to the result if it yields zero when passed into function.
     *
     * @param a        a sorted array of ints.
     * @param i        the index of the first element of resulting triples.
     * @param function a function which takes a triple and returns a value which will be compared with zero.
     * @return a List of Triples.
     */
    public static List<Triple> calipers(int[] a, int i, Function<Triple, Integer> function) {
        List<Triple> triples = new ArrayList<>();
        // FIXME : use function to qualify triples and to navigate otherwise.
        // END
        //-----------------------------------------------
//        int length = a.length;
//        int ii=i;
//            // Fix the second element as A[j]
//            for (int jj = ii + 1; jj < length - 1; jj++) {
//                // Now look for the third number
//                for (int k = jj + 1; k < length; k++)
//                {
//                    int sum = a[ii] + a[jj] + a[k];
//                    if (sum == 0 ) {
////                        System.out.println("-- Triplet is " + a[ii] + ", " + a[jj] + ", " + a[k]);
//                        Triple t = new Triple (a[ii],a[jj],a[k]);
//                        triples.add(t);
////                        return True;
//                    }
//                    else if (sum > 0) break;
//                }
//            }
        //-----------------------------------------------
        int mid = i+1;
        int last = a.length-1;

        while (mid < last) {
            int sum = a[i]+a[mid]+a[last];
            if (sum == 0) {
                Triple tr = new Triple(a[i],a[mid],a[last]);
                triples.add(tr);
            }
            if (sum >= 0) {
                last--;
            }
            else {
                mid++;
            }
        }
//        System.out.println ("iter triples = "+triples.toString());
        return triples;
    }

    private final int[] a;
    private final int length;


}

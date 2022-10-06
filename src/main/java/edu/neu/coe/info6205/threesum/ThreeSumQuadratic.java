package edu.neu.coe.info6205.threesum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementation of ThreeSum which follows the approach of dividing the solution-space into
 * N sub-spaces where each sub-space corresponds to a fixed value for the middle index of the three values.
 * Each sub-space is then solved by expanding the scope of the other two indices outwards from the starting point.
 * Since each sub-space can be solved in O(N) time, the overall complexity is O(N^2).
 * <p>
 * NOTE: The array provided in the constructor MUST be ordered.
 */
public class ThreeSumQuadratic implements ThreeSum {
    /**
     * Construct a ThreeSumQuadratic on a.
     * @param a a sorted array.
     */
    public ThreeSumQuadratic(int[] a) {
        this.a = a;
        length = a.length;
    }

    public Triple[] getTriples() {
        List<Triple> triples = new ArrayList<>();
        for (int i = 0; i < length; i++) triples.addAll(getTriples(i));
        Collections.sort(triples);
        return triples.stream().distinct().toArray(Triple[]::new);
    }

    /**
     * Get a list of Triples such that the middle index is the given value j.
     *
     * @param j the index of the middle value.
     * @return a Triple such that
     */
    public List<Triple> getTriples(int j) {
        List<Triple> triples = new ArrayList<>();
        // FIXME : for each candidate, test if a[i] + a[j] + a[k] = 0.
        // END
//        for (int i=1; i<length-1; i++)
//        {
//            if (this.a[i-1]+this.a[i]+this.a[i+1] == 0)
//            {
//                Triple t = new Triple (this.a[i-1],this.a[i],this.a[i+1]);
//                triples.add(t);
//            }
//        }
//        ===================================================================
//        for (int i = j-1; i >= 0; i--) {
//            // Fix the second element as A[j]
//                // Now look for the third number
//                for (int k = j + 1; k < this.length; k++) {
//                    int sum = a[i] + a[j] + a[k];
//                    if (sum == 0) {
//                        System.out.println("-- Triplet is " + a[i] + ", " + a[j] + ", " + a[k]);
//                        Triple t = new Triple (this.a[i],this.a[j],this.a[k]);
//                        triples.add(t);
//                    }
//                    else if (sum > 0) break;
//                }
//
//        }
//        ======================================================================
        int mid=j;
        int fir = j-1;
        int last = j+1;

        int sum = 0;
        while (fir >=0 && last < a.length)
        {
            sum = a[fir]+a[mid]+a[last];
            if (sum > 0) fir--;
            else if (sum < 0) last++;
            else
            {
//                System.out.println("-- Triplet is " + a[fir] + ", " + a[mid] + ", " + a[last]);
                triples.add(new Triple (this.a[fir],this.a[mid],this.a[last]));
                if (fir != 0) fir--;
                else break;
            }
//            System.out.println(fir+" "+mid+" "+last);

        }
//        ======================================================================

//        System.out.println ("iter triples = "+triples.toString());
        return triples;
    }


    private final int[] a;
    private final int length;
}

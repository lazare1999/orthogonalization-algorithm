package app;

import java.util.*;

/**
 * Created by Lazo on 2021-12-08
 */

public class algorithm extends OrtAlgorithmHelper {

    public static void ortAlgorithm(ArrayList<HashMap<Integer, Boolean>> listX) {

        listX.sort(Comparator.comparing(a -> Collections.min(a.keySet())));
        listX.sort(Comparator.comparing(HashMap::size));

        List<ArrayList<HashMap<Integer, Boolean>>> kInvertedMatrixList = new ArrayList<>();

        for (int i=0; listX.size()-1 > i; i++) {
            kInvertedMatrixList.add(invertHashMap(listX.get(i)));
        }

        ArrayList<HashMap<Integer, Boolean>> ans = calculateLogicalAnds(listX, kInvertedMatrixList);

        for (var a : ans) {
            for (var aa : a.entrySet()) {
                var b = "x"+aa.getKey().toString();
                if (!aa.getValue())
                    b += "' ";
                else
                    b += " ";

                System.out.print(b);
            }
            System.out.println();
        }

    }

}

import java.util.*;

/**
 * Created by Lazo on 2021-11-10
 */


public class Main
{
    public static void main(String[] args) {

        /*
        Scanner myObj = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        String numOfRows = myObj.nextLine();
        int numOfRowsInt = Integer.parseInt(numOfRows);

        ArrayList<HashMap<Integer, Boolean>> listX = new ArrayList<>();

        int rIndex =1;
        int rElementIndex =1;
        while (numOfRowsInt >0) {

            System.out.print("Enter length of row " + rIndex + ": " );
            String lengthOfRow = myObj.nextLine();
            int lengthOfRowInt = Integer.parseInt(lengthOfRow);

            HashMap<Integer, Boolean> row = new HashMap<>();
            while (lengthOfRowInt >0) {
                System.out.print("enter index of row " + rIndex + " element " + rElementIndex + ": ");
                String index = myObj.nextLine();
                Integer indexInt = Integer.parseInt(index);
//                System.out.print("is inverted? \n y or n \n type: ");
//                String inverted = myObj.nextLine();
//                boolean value;
//                if (inverted.equals("y")) {
//                    value = false;
//                } else if (inverted.equals("n")) {
//                    value = true;
//                } else {
//                    System.out.println("error");
//                    return;
//                }
//                row.put(indexInt, value);
                row.put(indexInt, true);
                lengthOfRowInt--;
                rElementIndex++;
            }
            listX.add(row);
            numOfRowsInt--;
            rIndex++;
            rElementIndex = 1;
        }
        */


        ArrayList<HashMap<Integer, Boolean>> listX2 = new ArrayList<>();
        HashMap<Integer, Boolean> row1 = new HashMap<>();
        HashMap<Integer, Boolean> row2 = new HashMap<>();
        HashMap<Integer, Boolean> row3 = new HashMap<>();
        HashMap<Integer, Boolean> row4 = new HashMap<>();
        row1.put(1, true);
        row1.put(3, true);
        row1.put(5, true);
        row2.put(1, true);
        row2.put(3, true);
        row2.put(4, true);
        row2.put(6, true);
        row2.put(8, true);
        row3.put(2, true);
        row3.put(4, true);
        row3.put(6, true);
        row4.put(2, true);
        row4.put(3, true);
        row4.put(4, true);
        row4.put(5, true);
        row4.put(8, true);

        listX2.add(row1);
        listX2.add(row2);
        listX2.add(row3);
        listX2.add(row4);

        System.out.println("answer is: " + algorithm(listX2));
    }

    public static <K, V> Map<K, V> copyMap(Map<K, V> original) {
        return new HashMap<>(original);
    }

    private static ArrayList<HashMap<Integer, Boolean>> invert(HashMap<Integer, Boolean> k) {
        ArrayList<HashMap<Integer, Boolean>> invertedK = new ArrayList<>();

        Iterator<Map.Entry<Integer, Boolean>> it = k.entrySet().iterator();
        HashMap<Integer, Boolean> commonRow = new HashMap<>();
        int i =1;

        while (it.hasNext()) {
            Map.Entry<Integer, Boolean> pair = it.next();

            HashMap<Integer, Boolean> row = new HashMap<>();

            if (i!=1) {
                row = (HashMap<Integer, Boolean>) copyMap(commonRow);
            }

            commonRow.put(pair.getKey(), pair.getValue());
            row.put(pair.getKey(), !pair.getValue());


            invertedK.add(row);
            i++;
        }

        return invertedK;
    }

    private static ArrayList<HashMap<Integer, Boolean>> logicalAnd(List<ArrayList<HashMap<Integer, Boolean>>> kInvertedMatrixList,
                                                                   HashMap<Integer, Boolean> k) {

        ArrayList<HashMap<Integer, Boolean>> ans = new ArrayList<>();

        if (kInvertedMatrixList.isEmpty() || k.isEmpty())
            return ans;

        ArrayList<HashMap<Integer, Boolean>> kInvertedCombined;
        kInvertedCombined = kInvertedMatrixList.get(0);
        if (kInvertedMatrixList.size() >1) {

            HashMap<Integer, Boolean> row = new HashMap<>();
            ArrayList<HashMap<Integer, Boolean>> mewKInvertedCombined = new ArrayList<>();

            for (int i=1; i<kInvertedMatrixList.size(); i++) {

                var ki = kInvertedMatrixList.get(i);

                for (HashMap<Integer, Boolean> kic : kInvertedCombined) {


                    if (kic.entrySet().stream().anyMatch(kicc ->
                            ki.stream().anyMatch(
                                    kii -> kii.get(kicc.getKey()) !=null && kii.get(kicc.getKey()) != kicc.getValue()))) {
                        continue;
                    }

                    for (HashMap<Integer, Boolean> kii : ki) {

                        row = (HashMap<Integer, Boolean>) copyMap(kic);

                        row.putAll(kii);

                        mewKInvertedCombined.add((HashMap<Integer, Boolean>) copyMap(row));
                        row.clear();
                    }


                }

            }

            kInvertedCombined = mewKInvertedCombined;
        }

        for (var kInverted : kInvertedCombined) {
            HashMap<Integer, Boolean> row = new HashMap<>();

            if (kInverted.entrySet().stream().anyMatch(ki -> k.get(ki.getKey()) !=null && k.get(ki.getKey()) != ki.getValue()))
                continue;

            for (var integerBooleanEntry : kInverted.entrySet()) {
                row.putAll(k);
                row.put(integerBooleanEntry.getKey(), integerBooleanEntry.getValue());
            }
            if (!row.isEmpty()) {
                ans.add((HashMap<Integer, Boolean>) copyMap(row));
                row.clear();
            }
        }




        return ans;
    }

    private static ArrayList<HashMap<Integer, Boolean>> calculateLogicalAnds(ArrayList<HashMap<Integer, Boolean>> listX,
                                                                             List<ArrayList<HashMap<Integer, Boolean>>> kInvertedMatrixList) {

        ArrayList<HashMap<Integer, Boolean>> ans = new ArrayList<>();

        for (int i =0; i < listX.size(); i++) {
            if (i ==0) {
                ans.add(listX.get(0));
            } else {
                List<ArrayList<HashMap<Integer, Boolean>>> aa= new ArrayList<>();

                for (int j =0; j < i; j++) {
                    aa.add(kInvertedMatrixList.get(j));
                }

                var logicalAndAns = logicalAnd(aa, listX.get(i));
                ans.addAll(logicalAndAns);
            }
        }


        return ans;
    }

    private static double algorithm(ArrayList<HashMap<Integer, Boolean>> listX) {

        listX.sort(Comparator.comparing(a -> Collections.min(a.keySet())));
        listX.sort(Comparator.comparing(HashMap::size));

        List<ArrayList<HashMap<Integer, Boolean>>> kInvertedMatrixList = new ArrayList<>();

        for (int i=0; listX.size()-1 > i; i++) {
            kInvertedMatrixList.add(invert(listX.get(i)));
        }

        ArrayList<HashMap<Integer, Boolean>> ans = calculateLogicalAnds(listX, kInvertedMatrixList);

        return 0.99;
    }
}

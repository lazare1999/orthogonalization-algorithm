import java.util.*;

/**
 * Created by Lazo on 2021-11-10
 */


public class Main
{
    public static void main(String[] args) {

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
        System.out.println("answer is: " + algorithm(listX));
    }

    public static <K, V> Map<K, V> copyMap(Map<K, V> original) {
        return new HashMap<>(original);
    }

    private static ArrayList<HashMap<Integer, Boolean>> invert(HashMap<Integer, Boolean> k) {
        ArrayList<HashMap<Integer, Boolean>> invertedK = new ArrayList<>();

        Iterator<Map.Entry<Integer, Boolean>> it = k.entrySet().iterator();
        int i =1;

        HashMap<Integer, Boolean> commonRow = new HashMap<>();
        while (it.hasNext()) {
            Map.Entry<Integer, Boolean> pair = it.next();

            HashMap<Integer, Boolean> row = new HashMap<>();

            if (i!=1) {
                row = (HashMap<Integer, Boolean>) copyMap(commonRow);
            }

            commonRow.put(pair.getKey(), pair.getValue());
            row.put(pair.getKey(), !pair.getValue());


            invertedK.add(row);
            it.remove();
            i++;
        }

        return invertedK;
    }

    private static ArrayList algorithm(ArrayList<HashMap<Integer, Boolean>> listX) {

        listX.sort(Comparator.comparing(a -> Collections.min(a.keySet())));

        listX.sort(Comparator.comparing(HashMap::size));

        List<ArrayList<HashMap<Integer, Boolean>>> kInvertedMatrixList = new ArrayList<>();

        for (int i=0; listX.size()-1 > i; i++) {
            kInvertedMatrixList.add(invert(listX.get(i)));
        }

        return listX;
    }
}

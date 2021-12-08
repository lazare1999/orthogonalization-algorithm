import java.util.*;

import static app.algorithm.ortAlgorithm;

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

        ortAlgorithm(electricEnergeticSystem());
        ortAlgorithm(example());
    }


    private static ArrayList<HashMap<Integer, Boolean>> electricEnergeticSystem() {

        ArrayList<HashMap<Integer, Boolean>> listX2 = new ArrayList<>();
        HashMap<Integer, Boolean> row1 = new HashMap<>();
        row1.put(1, true);
        row1.put(3, true);
        row1.put(5, true);
        listX2.add(row1);

        HashMap<Integer, Boolean> row2 = new HashMap<>();
        row2.put(1, true);
        row2.put(3, true);
        row2.put(4, true);
        row2.put(6, true);
        row2.put(8, true);
        listX2.add(row2);

        HashMap<Integer, Boolean> row3 = new HashMap<>();
        row3.put(2, true);
        row3.put(4, true);
        row3.put(6, true);
        listX2.add(row3);

        HashMap<Integer, Boolean> row4 = new HashMap<>();
        row4.put(2, true);
        row4.put(3, true);
        row4.put(4, true);
        row4.put(5, true);
        row4.put(8, true);
        listX2.add(row4);

        return listX2;

    }

    private static ArrayList<HashMap<Integer, Boolean>> example() {

        ArrayList<HashMap<Integer, Boolean>> listX2 = new ArrayList<>();
        HashMap<Integer, Boolean> row1 = new HashMap<>();
        row1.put(1, true);
        row1.put(3, true);
        listX2.add(row1);

        HashMap<Integer, Boolean> row2 = new HashMap<>();
        row2.put(1, true);
        row2.put(4, true);
        listX2.add(row2);

        HashMap<Integer, Boolean> row3 = new HashMap<>();
        row3.put(2, true);
        row3.put(4, true);
        listX2.add(row3);

        HashMap<Integer, Boolean> row4 = new HashMap<>();
        row4.put(2, true);
        row4.put(5, true);
        listX2.add(row4);

        return listX2;

    }

}

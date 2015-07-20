package name.davidwbrown;

public class MinMax {

    public static void main(String[] args) {

        int[][] A = new int[5][5];
        A[0][0] = 0;    A[0][1] = 1;    A[0][2] = 9;    A[0][3] = 3;
        A[1][0] = 7;    A[1][1] = 5;    A[1][2] = 8;    A[1][3] = 3;
        A[2][0] = 9;    A[2][1] = 2;    A[2][2] = 9;    A[2][3] = 4;
        A[3][0] = 4;    A[3][1] = 6;    A[3][2] = 7;    A[3][3] = 1;


        int rowIndex = minMaxRowIndex(A);
        int colIndex = minMaxColIndex(A);
        System.out.println("A["+rowIndex+"]["+colIndex+"]="+A[rowIndex][colIndex]);

    }

    public static int getMaxVectorVal(int[] inputArray){
        int maxValue = inputArray[0];
        for(int i=1;i < inputArray.length;i++){
            if(inputArray[i] > maxValue){
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    public static int getMinVectorVal(int[] inputArray){
        int minValue = inputArray[0];
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i] < minValue){
                minValue = inputArray[i];
            }
        }
        return minValue;
    }

    static int[] maxValVector(int[][] array) {
        int[] result = new int[array[0].length];
        for (int i = 0; i < array[0].length; i++) {
            int[] temp = new int[array.length];
            for (int j = 0; j < array.length; j++) {
                temp[j] = array[j][i];
            }
            result[i] = getMaxVectorVal(temp);
        }
        return result;
    }

    static int[] minValVector(int[][] array) {
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = getMinVectorVal(array[i]);
        }
        return result;
    }

    static int minMaxRowIndex(int[][] array) {
        int[] row = minValVector(array);
        int[] column = maxValVector(array);
        for (int i = 0; i < row.length; i++)
            for (int j = 0; j < column.length; j++)
                if (row[i] == column[j])
                    return i;
        return -1;
    }

    static int minMaxColIndex(int[][] array) {
        int[] row = minValVector(array);
        int[] column = maxValVector(array);
        for (int i = 0; i < row.length; i++)
            for (int j = 0; j < column.length; j++)
                if (row[i] == column[j])
                    return j;
        return -1;
    }
}

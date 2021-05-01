public class SparseArray{
    public static void main(String[] args) {
        // create a two-dimensional array to represent the chess
        // 0: no piece; 1: white piece; 2: black piece
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;

        //print chessArray1
        System.out.println("Chessarray1:");
        for(int[] row : chessArray1) {
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println();

        // calculate total number of effective elements
        int sum = 0;
        for(int i = 0; i < chessArray1.length; i++) {
            for(int j = 0; j < chessArray1[i].length; j++) {
                if(chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }

        // create new sparsearray
        int sparseArray[][] = new int[sum+1][3];
        sparseArray[0][0] = chessArray1.length;
        sparseArray[0][1] = chessArray1[0].length;
        sparseArray[0][2] = sum;
        int num = 1;
        for(int i = 0; i < chessArray1.length; i++) {
            for(int j = 0; j < chessArray1[i].length; j++) {
                if(chessArray1[i][j] != 0) {
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = j;
                    sparseArray[num][2] = chessArray1[i][j];
                    num++;
                }
            }
        }

        //print sparsearray
        System.out.println("Sparsearray:");
        for(int[] row : sparseArray) {
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        System.out.println();

        // recover original array from sparsearray
        int totalRow = sparseArray[0][0];
        int totalCol = sparseArray[0][1];
        int numEff = sparseArray[0][2];
        int chessArray2[][] = new int[totalRow][totalCol];
        for(int i = 1; i < sparseArray.length; i++) {
            int row = sparseArray[i][0];
            int col = sparseArray[i][1];
            int value = sparseArray[i][2];
            chessArray2[row][col] = value;
        }

        // print chessArray2
        System.out.println("Chessarray2:");
        for(int[] row : chessArray2) {
            for(int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}

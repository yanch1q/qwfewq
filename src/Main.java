import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] m = new int[4][4];
        Random r = new Random();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                m[i][j] = r.nextInt(50) + 1;
            }
        }

        System.out.println("Матриця 4x4:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        int sumEvenRows = 0, sumOddRows = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i % 2 == 0) sumEvenRows += m[i][j];
                else sumOddRows += m[i][j];
            }
        }

        long prodEvenCols = 1, prodOddCols = 1;
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                if (j % 2 == 0) prodEvenCols *= m[i][j];
                else prodOddCols *= m[i][j];
            }
        }

        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + sumEvenRows);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + sumOddRows);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + prodEvenCols);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + prodOddCols);
        System.out.println();

        int target = 0;
        for (int j = 0; j < 4; j++) target += m[0][j];

        boolean isMagic = true;
        for (int i = 0; i < 4; i++) {
            int row = 0, col = 0;
            for (int j = 0; j < 4; j++) {
                row += m[i][j];
                col += m[j][i];
            }
            if (row != target || col != target) {
                isMagic = false;
                break;
            }
        }

        if (isMagic) {
            int d1 = 0, d2 = 0;
            for (int i = 0; i < 4; i++) {
                d1 += m[i][i];
                d2 += m[i][3 - i];
            }
            if (d1 != target || d2 != target) isMagic = false;
        }

        if (isMagic) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }
}
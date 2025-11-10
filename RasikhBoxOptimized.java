import java.util.*;

public class RasikhBoxOptimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        
        char[][] box = new char[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                box[i][j] = sc.next().charAt(0);
            }
        }
        
        int K = sc.nextInt();
        sc.nextLine();
        
        int netRotation = 0;
        for (int i = 0; i < K; i++) {
            String dir = sc.next();
            if (dir.equals("right")) netRotation++;
            else if (dir.equals("left")) netRotation--;
        }
        
        // normalize rotations to 0-3 range
        netRotation = ((netRotation % 4) + 4) % 4;
        
        // apply rotations efficiently
        if (netRotation == 1) {
            box = rotateRight(box);
        } else if (netRotation == 2) {
            box = rotateRight(rotateRight(box));
        } else if (netRotation == 3) {
            box = rotateLeft(box);
        }
        
        // apply gravity once at the end
        applyGravity(box);
        
        // print final result
        for (char[] row : box) {
            for (int j = 0; j < row.length; j++) {
                System.out.print(row[j]);
                if (j < row.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
        
        sc.close();
    }

    private static char[][] rotateRight(char[][] box) {
        int M = box.length, N = box[0].length;
        char[][] rotated = new char[N][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][M - 1 - i] = box[i][j];
            }
        }
        return rotated;
    }

    private static char[][] rotateLeft(char[][] box) {
        int M = box.length, N = box[0].length;
        char[][] rotated = new char[N][M];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                rotated[N - 1 - j][i] = box[i][j];
            }
        }
        return rotated;
    }

    private static void applyGravity(char[][] box) {
        int M = box.length, N = box[0].length;
        for (int j = 0; j < N; j++) {
            int emptyRow = M - 1;
            for (int i = M - 1; i >= 0; i--) {
                if (box[i][j] == '*') {
                    if (i != emptyRow) {
                        box[emptyRow][j] = '*';
                        box[i][j] = '.';
                    }
                    emptyRow--;
                }
            }
        }
    }
}

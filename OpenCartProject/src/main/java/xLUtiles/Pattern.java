package xLUtiles;

public class Pattern {
	public static void main(String[] args) {
        int n = 4;
        int startNum = 1;

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(startNum);
                startNum++;
            }
            System.out.println();
        }
    }
}

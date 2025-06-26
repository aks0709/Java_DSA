package Company.Accenture;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(min_moves(l, r, k, a, b));
    }

    public static int min_moves(int l, int r, int k, int a, int b) {
        if (a == b) {
            return 0;
        }
        if (Math.abs(a - b) >= k) {
            return 1;
        }

        if ((Math.abs(b - l) >= k && Math.abs(a - l) >= k) ||
                (Math.abs(b - r) >= k && Math.abs(a - r) >= k)) {
            return 2;
        }

        if ((Math.abs(b - l) >= k && Math.abs(a - r) >= k) ||
                (Math.abs(b - r) >= k && Math.abs(a - l) >= k)) {
            return 3;
        }

        return -1;
    }

}

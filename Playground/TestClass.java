import java.io.*;
import java.util.*;
import java.util.HashMap;
import java.lang.*;

class TestClass {
    private static void solution(String str) {
        String ans = "";
        boolean first = true;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            System.out.println(c);
            if (c >= 'A' && c <= 'Z') {
                if (!first) {
                    ans += '-';
                } else {
                    first = false;
                }
                ans += (char) ((c - 'A') + 'a');
            } else {
                ans += c;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            m.put(v, m.getOrDefault(v, 0) + 1);
        }
        double ans = 0;
        for (int k : m.keySet()) {
            int v = m.get(k);
            if (v % 2 == 0) {
                ans += ((k + (0.1 * k)) * (v / 2));
            } else {
                ans += ((k + (0.1 * k)) * (v / 2)) + (0.5 * k);
            }
        }
        System.out.println(ans);
    }

}

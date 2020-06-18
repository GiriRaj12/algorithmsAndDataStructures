package dataStructures.Algorithms;

import java.util.List;
import java.util.Scanner;

public class SlotsRecursion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int []services = new int[]{20,60,30};
        int gcd = findGCD(services, services.length);
    }
    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static int findGCD(int arr[], int n)
    {
        int result = arr[0];
        for (int i = 1; i < n; i++)
            result = gcd(arr[i], result);

        return result;
    }

}

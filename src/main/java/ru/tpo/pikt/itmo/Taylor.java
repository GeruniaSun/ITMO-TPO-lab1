package ru.tpo.pikt.itmo;

public class Taylor {

    public static double cos(double x, int n) {
        double res = 1.0;
        double last = 1.0;

        for (int i = 1; i <= n; i++) {
            last *= -1 * x * x / ((2 * i - 1) * (2 * i)); // обновляем последний терм ряда
            res += last;
        }

        return res;
    }
}

package ru.tpo.pikt.itmo;

public class RadixSort {

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) return arr;

        // отрицательные отдельно
        int posCount = 0, negCount = 0;
        for (int v : arr) {
            if (v < 0) negCount++;
            else posCount++;
        }

        int[] pos = new int[posCount];
        int[] negAbs = new int[negCount];
        int pIdx = 0, nIdx = 0;
        for (int v : arr) {
            if (v < 0) {
                negAbs[nIdx++] = -v;
            } else {
                pos[pIdx++] = v;
            }
        }

        // сортировка
        radixSortNonNegative(pos);
        radixSortNonNegative(negAbs);

        // конкатенация
        int idx = 0;
        for (int i = negAbs.length - 1; i >= 0; i--) {
            arr[idx++] = -negAbs[i];
        }
        for (int v : pos) arr[idx++] = v;

        return arr;
    }

    // непосредственно RadixSort
    private static void radixSortNonNegative(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int max = arr[0];
        for (int v : arr) if (v > max) max = v;
        int exp = 1;
        int[] aux = new int[arr.length];

        while (max / exp > 0) {
            int[] count = new int[10];
            for (int v : arr) count[(v / exp) % 10]++;
            for (int i = 1; i < 10; i++) count[i] += count[i - 1];
            for (int i = arr.length - 1; i >= 0; i--) {
                int d = (arr[i] / exp) % 10;
                aux[--count[d]] = arr[i];
            }
            System.arraycopy(aux, 0, arr, 0, arr.length);
            exp *= 10;
        }
    }
}
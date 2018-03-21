package com.jamil;

public class Main
{
    public static void main(String[] args)
    {
        new Main();
    }

    Main()
    {
        problem6();
    }

    void problem6()
    {
        int[] y = new int[]{3800, 5100, 4200, 6200, 5800, 4100, 3900, 3600, 3800, 4100, 4500, 5100, 4200, 4000};
        int[] x = new int[]{25100, 32200, 29600, 35000, 34400, 26500, 28700, 28200, 34600, 32700, 31500, 30600, 27700, 28500};

        double s1 = 0, s2 = 0;

        for (int i = 0; i < x.length; i++)
        {
            s1 += x[i];
            s2 += y[i];
        }

        double r = s2 / s1;
        double sr2 = 0;

        System.out.println(r);

        for (int i = 0; i < x.length; i++)
            sr2 += Math.pow(y[i] - r * x[i], 2);

        sr2 /= (x.length - 1);
        double ux = s1 / x.length;

        double v = (1 - (((double) 14) / 150)) * Math.pow(ux, -2) * sr2 / x.length;

        System.out.println(Math.sqrt(4 * v));
    }
}

package com.jamil;

public class Main
{
    public static void main(String[] args)
    {
        new Main();
    }

    Main()
    {
        problem25();
    }

    void problem25()
    {
        double[][] x = new double[][]{{204, 143, 82, 256, 275, 198}, {137, 189, 119, 63, 103, 107, 159, 63, 87}};
        double[][] y = new double[][]{{210, 160, 75, 280, 300, 190}, {150, 200, 125, 60, 110, 100, 180, 75, 90}};
        double[] N = new double[]{120, 180};
        double[] mux = {24500 / N[0], 21200 / N[1]};

        double[] ybar = new double[]{0, 0};
        double[] xbar = new double[]{0, 0};

        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < x[i].length; j++)
            {
                ybar[i] += y[i][j];
                xbar[i] += x[i][j];
            }

            ybar[i] /= y[i].length;
            xbar[i] /= x[i].length;
        }

        double muySR = 0;

        for (int i = 0; i < 2; i++)
            muySR += (N[i] / 300) * mux[i] * (ybar[i] / xbar[i]);

        double vSR = 0;

        for (int i = 0; i < 2; i++)
        {
            double sr2 = 0;
            for (int j = 0; j < x[i].length; j++)
                sr2 += (y[i][j] - (ybar[i] / xbar[i]) * x[i][j]) * (y[i][j] - (ybar[i] / xbar[i]) * x[i][j]);

            sr2 /= x[i].length - 1;

            vSR += (N[i] / 300) * (N[i] / 300) * (1 - ((double) x[i].length) / N[i]) * (sr2 / x[i].length);
        }

        vSR *= 300 * 300;

        System.out.println(300 * muySR);
        System.out.println(vSR);

        double yst = 0, xst = 0;

        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < x[i].length; j++)
            {
                yst += y[i][j];
                xst += x[i][j];
            }

        double rC = yst / xst;
        double muyRC = rC * (21200 + 24500) / 300;

        System.out.println(300 * muyRC);

        double vCR = 0;
        for (int i = 0; i < 2; i++)
        {
            double sr2 = 0;
            for (int j = 0; j < x[i].length; j++)
                sr2 += (y[i][j] - rC * x[i][j]) * (y[i][j] - rC * x[i][j]);

            sr2 /= x[i].length - 1;

            vCR += (N[i] / 300) * (N[i] / 300) * (1 - ((double) x[i].length) / N[i]) * (sr2 / x[i].length);
        }
        System.out.println(300 * 300 * vCR);
    }

    void problem23c()
    {
        double[] x = new double[]{21, 63, 91, 60, 70, 50};
        double[] y = new double[]{26, 91, 47, 70, 70, 50};

        double dbar = 0;
        double n = x.length;
        double N = 19;

        for (int i = 0; i < n; i++)
            dbar += y[i] - x[i];

        dbar /= n;
        double tauy = 674 + N * dbar;
        System.out.println(tauy);

        double temp = 0;

        for (int i = 0; i < n; i++)
            temp += ((y[i] - x[i]) - dbar) * ((y[i] - x[i]) - dbar);

        temp /= (n - 1);

        double v = (1 - n / N) * (1 / n) * temp;

        System.out.println(Math.sqrt(4 * v));
    }

    void problem23b()
    {
        double[] x = new double[]{21, 63, 91, 60, 70, 50};
        double[] y = new double[]{26, 91, 47, 70, 70, 50};

        double n = x.length;
        double N = 19;

        double xbar = 0, ybar = 0;

        for (int i = 0; i < x.length; i++)
        {
            xbar += x[i];
            ybar += y[i];
        }

        xbar /= x.length;
        ybar /= y.length;

        double SSxy = 0, SSxx = 0, SSyy = 0;

        for (int i = 0; i < x.length; i++)
        {
            SSxy += (y[i] - ybar) * (x[i] - xbar);
            SSxx += (x[i] - xbar) * (x[i] - xbar);
            SSyy += (y[i] - ybar) * (y[i] - ybar);
        }

        double b = SSxy / SSxx;
        double mux = ((double) 674) / 19;
        double muy = ybar + b * (mux - xbar);

        System.out.println(N * muy);

        double v = N * N * (1 - (n / N)) * (1 / n) * ((SSyy - b * SSxy) / (n - 2));

        System.out.println(Math.sqrt(4 * v));
    }

    void problem23a()
    {
        double[] x = new double[]{21, 63, 91, 60, 70, 50};
        double[] y = new double[]{26, 91, 47, 70, 70, 50};

        double s1 = 0, s2 = 0;

        for (int i = 0; i < x.length; i++)
        {
            s1 += x[i];
            s2 += y[i];
        }

        double r = s2 / s1;
        double t = 674 * r;

        System.out.println(t);

        double sr2 = 0;

        for (int i = 0; i < x.length; i++)
            sr2 += Math.pow(y[i] - r * x[i], 2);

        sr2 /= (x.length - 1);

        double v = 19 * 19 * (1 - (((double) x.length) / 19)) * sr2 / x.length;

        System.out.println(Math.sqrt(4 * v));
    }

    void problem21b()
    {
        double[] P = new double[]{12, 14, 20, 11, 8, 15};
        double[] T = new double[]{15, 18, 16, 14, 13, 16};

        String temp = "";

        //generates input for graphing tool, desmos
        for (int i = 0; i < T.length; i++)
            temp += "(" + T[i] + ", " + P[i] + "), ";
        System.out.println(temp.substring(0, temp.length() - 2));

        double s1 = 0, s2 = 0;

        for (int i = 0; i < T.length; i++)
        {
            s1 += T[i];
            s2 += P[i];
        }

        double r = s2 / s1;
        double sr2 = 0;

        System.out.println(r);

        for (int i = 0; i < T.length; i++)
            sr2 += Math.pow(P[i] - r * T[i], 2);

        sr2 /= (T.length - 1);
        double ux = s1 / T.length;

        double v = Math.pow(ux, -2) * sr2 / T.length;

        System.out.println(Math.sqrt(4 * v));
    }

    void problem21a()
    {
        double[] W = new double[]{16, 17, 17, 16, 12, 18};
        double[] T = new double[]{15, 18, 16, 14, 13, 16};

        String temp = "";

        //generates input for graphing tool, desmos
        for (int i = 0; i < T.length; i++)
            temp += "(" + T[i] + ", " + W[i] + "), ";
        System.out.println(temp.substring(0, temp.length() - 2));

        double s1 = 0, s2 = 0;

        for (int i = 0; i < T.length; i++)
        {
            s1 += T[i];
            s2 += W[i];
        }

        double r = s2 / s1;
        double sr2 = 0;

        System.out.println(r);

        for (int i = 0; i < T.length; i++)
            sr2 += Math.pow(W[i] - r * T[i], 2);

        sr2 /= (T.length - 1);
        double ux = s1 / T.length;

        double v = Math.pow(ux, -2) * sr2 / T.length;

        System.out.println(Math.sqrt(4 * v));
    }

    void problem14()
    {
        double[] x = new double[]{550, 720, 1500, 1020, 620, 980, 928, 1200, 1350, 1750, 670, 729, 1530};
        double[] y = new double[]{610, 780, 1600, 1030, 600, 1050, 977, 1440, 1570, 2210, 980, 865, 1710};

        double xbar = 0, ybar = 0;

        for (int i = 0; i < x.length; i++)
        {
            xbar += x[i];
            ybar += y[i];
        }

        xbar /= x.length;
        ybar /= y.length;

        double SSxy = 0, SSxx = 0, SSyy = 0;

        for (int i = 0; i < x.length; i++)
        {
            SSxy += (y[i] - ybar) * (x[i] - xbar);
            SSxx += (x[i] - xbar) * (x[i] - xbar);
            SSyy += (y[i] - ybar) * (y[i] - ybar);
        }


        double b = SSxy / SSxx;
        double mux = 128200 / 123;
        double muy = ybar + b * (mux - xbar);

        System.out.println(muy);

        double n = x.length;
        double N = 123;

        double v = (1 - (n / N)) * (1 / n) * ((SSyy - b * SSxy) / (n - 2));

        System.out.println(Math.sqrt(4 * v));
    }

    void problem13()
    {
        double[] x = new double[]{208, 400, 440, 259, 351, 880, 273, 487, 183, 863, 599, 510, 828, 473, 924, 110, 829, 257, 388, 244};
        double[] y = new double[]{239, 428, 472, 276, 363, 942, 294, 514, 195, 897, 626, 538, 888, 510, 998, 171, 889, 265, 419, 257};

        double s1 = 0, s2 = 0;

        for (int i = 0; i < x.length; i++)
        {
            s1 += x[i];
            s2 += y[i];
        }

        double r = s2 / s1;

        double sr2 = 0;

        for (int i = 0; i < x.length; i++)
            sr2 += Math.pow(y[i] - r * x[i], 2);

        sr2 /= (x.length - 1);

        double N = 452;
        double D = (3800 * 3800) / (4 * N * N);

        double n = N * sr2 / (N * D + sr2);

        System.out.println(n);
    }

    void problem11()
    {
        double[] x = new double[]{815, 919, 690, 984, 500, 560, 1323, 1067, 789, 573, 834, 1049};
        double[] y = new double[]{897, 992, 752, 1093, 768, 828, 1428, 1152, 875, 642, 909, 1122};

        //generates input for graphing tool, desmos
        for (int i = 0; i < x.length; i++)
        {
            System.out.print("(" + x[i] / 1000 + ", " + y[i] / 1000 + "), ");
        }
        System.out.println();

        double s1 = 0, s2 = 0;

        for (int i = 0; i < x.length; i++)
        {
            s1 += x[i];
            s2 += y[i];
        }

        double r = s2 / s1;
        double uy = r * 880;

        System.out.println(uy);

        double sr2 = 0;

        for (int i = 0; i < x.length; i++)
            sr2 += Math.pow(y[i] - r * x[i], 2);

        sr2 /= (x.length - 1);

        double v = (1 - (((double) x.length) / 500)) * sr2 / x.length;

        System.out.println(Math.sqrt(4 * v));
    }

    void problem4()
    {
        int[] x = new int[]{550, 720, 1500, 1020, 620, 980, 928, 1200, 1350, 1750, 670, 729, 1530};
        int[] y = new int[]{610, 780, 1600, 1030, 600, 1050, 977, 1440, 1570, 2210, 980, 865, 1710};

        double s1 = 0, s2 = 0;

        for (int i = 0; i < x.length; i++)
        {
            s1 += x[i];
            s2 += y[i];
        }

        double r = s2 / s1;
        double t = 128200 * r;

        System.out.println(t);

        double sr2 = 0;

        for (int i = 0; i < x.length; i++)
            sr2 += Math.pow(y[i] - r * x[i], 2);

        sr2 /= (x.length - 1);

        double v = 123 * 123 * (1 - (((double) x.length) / 123)) * sr2 / x.length;

        System.out.println(Math.sqrt(4 * v));
    }

    void problem3()
    {
        double[] y = new double[]{3800, 5100, 4200, 6200, 5800, 4100, 3900, 3600, 3800, 4100, 4500, 5100, 4200, 4000};
        double[] x = new double[]{25100, 32200, 29600, 35000, 34400, 26500, 28700, 28200, 34600, 32700, 31500, 30600, 27700, 28500};

        //generates input for graphing tool, desmos
        for (int i = 0; i < x.length; i++)
        {
            System.out.print("(" + x[i] / 1000 + ", " + y[i] / 1000 + "), ");
        }
        System.out.println();

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

        double v = (1 - (((double) x.length) / 150)) * Math.pow(ux, -2) * sr2 / x.length;

        System.out.println(Math.sqrt(4 * v));
    }
}

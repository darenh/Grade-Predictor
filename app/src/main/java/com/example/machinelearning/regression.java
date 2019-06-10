package com.example.machinelearning;

import static java.lang.Math.pow;

public class regression {
    public static double alpha = 0.01;
    public static int iterations = 7000;
    public static double m;
    public static int r;

    public double getM() {
        return m;
    }

    // Setter
    public static void setM(int x) {
         m = x;
         r = x;
        System.out.println(m);
    }

    public static double main(double[] x, double[] y, double theta[], int est)
    {
        double j = 0;
        double store[] = new double[2];
        store = gradientDescent(x, y, theta);
        System.out.println(store[0] + " " + store[1]);
        j = store[0] + (store[1]*est);
        return j;
    }

    public static double power(double x) {
        return x * x;
    }

    public static double costFunction(double x[], double y[], double theta[]) {
        double j = 0, sum = 0;
        int i;
        double hyp[] = new double[r];
        for (i = 0; i < x.length; i++) {
            hyp[i] = theta[1] * x[i] + theta[0];
        }
        for (i = 0; i < hyp.length; i++) {
            hyp[i] = pow(hyp[i] - y[i], 2);
            sum += hyp[i];
        }
        j = 1 / (2.0 * m) * sum;
       //System.out.println("theta0: " + theta[0] + "theta1: " + theta[1]);
        //System.out.println("j: " + j);
        return j;
    }
    public static double minim(double x, double y)
    {
        if (x < y)
        {
            return x;
        }
        return y;
    }
    public static double[] gradientDescent(double x[], double y[], double theta[])
    {
        int i, n;
        double store[] = new double[2];
        double thetaZero, thetaOne;
        double hyp[] = new double[r];
        double yes[] = new double[r];
        double sum = 0.0, mul = 0.0, min = costFunction(x, y, theta);
        // iterations globally defined
        for (n = 0; n < iterations; n++)
        {
            for (i = 0; i < x.length; i++)
            {
                hyp[i] = (theta[1] * x[i]) + theta[0];
                yes[i] = (hyp[i] - y[i]) * x[i];
                // for thetaone
                mul += yes[i];
                // for theta 0
                sum += hyp[i] - y[i];
            }
            // sum has the hypothesis value minus y.
            thetaZero = theta[0] - alpha * 1.0/m * sum;
            thetaOne = theta[1] - alpha * 1.0/m * mul;
            theta[0] = thetaZero;
            theta[1] = thetaOne;
            if (costFunction(x, y, theta) < min)
            {
                min = costFunction(x, y, theta);
                store[0] = theta[0];
                store[1] = theta[1];
            }
        }
        System.out.println("Min: " + min);
        // sum has the hypothesis value minus y.
        // 3 represents training sessions.
        return store;
    }

}

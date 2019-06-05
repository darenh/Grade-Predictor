package com.example.machinelearning;

public class regression {
    public static double alpha = 0.001;
    public static int iterations = 1000;

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
        double hyp[] = new double[3];
        for (i = 0; i < x.length; i++) {
            hyp[i] += theta[1] * x[i] + theta[0];
        }
        for (i = 0; i < hyp.length; i++) {
            hyp[i] = power(hyp[i] - y[i]);
            sum += hyp[i];
        }
        j = 1 / (2 * 3.0) * sum;
        System.out.println("theta0: " + theta[0] + "theta1: " + theta[1]);
        System.out.println("j: " + j);
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
        double hyp[] = new double[3];
        double yes[] = new double[3];
        double sum = 0, mult = 0, min = costFunction(x, y, theta);
        for (n = 0; n < iterations; n++)
        {
            for (i = 0; i < x.length; i++)
            {
                hyp[i] = theta[0] + (theta[1] * x[i]);
                yes[i] = (hyp[i] - y[i]) * x[i];
                sum += hyp[i] - y[i];
            }
            for (i = 0; i < x.length; i++)
            {
                mult += yes[i];
            }
            // sum has the hypothesis value minus y.
            // 3 represents training sessions.
            thetaZero = theta[0] - alpha * 1/3 * sum;
            thetaOne = theta[1] - alpha * 1/3 * mult;
            theta[0] = thetaZero;
            theta[1] = thetaOne;
            if (costFunction(x, y, theta) < min)
            {
                min = costFunction(x, y, theta);
                store[0] = theta[0];
                store[1] = theta[1];
            }
        }
        // sum has the hypothesis value minus y.
        // 3 represents training sessions.
        return store;
    }

}

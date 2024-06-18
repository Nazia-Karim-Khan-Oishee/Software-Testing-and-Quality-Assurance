package org.example;

public class combination {

    public long nCr  (double n, double r) throws IllegalArgumentException
    {
        if(!isInt(n) || !isInt(r))
        {
            throw new IllegalArgumentException("Inputs must be an integer");

        }
        else if (n == 0 )
        {
            throw new IllegalArgumentException("Inputs must be greater than 0");


        }
        else if (n < 0 || r<0)
        {
            throw new IllegalArgumentException("Inputs must be positive value");


        }
        else if (n > 15 || r>15)
        {
            throw new IllegalArgumentException("Inputs must be in the range 0 to 15");


        }
        else
        {
            return (long) ( fact((long) n) / (fact((long) r) * fact((long) (n - r))));

        }

    }

    public boolean isInt(double n) {
        if(n == (int)n)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private long fact(long n) {
        long result = 1;
        for (int i = 2; i <= n; i++)
            result = result * i;

//        System.out.println(n + "        " + result);
        return result;
    }


}

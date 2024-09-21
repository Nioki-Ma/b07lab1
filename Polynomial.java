public class Polynomial
{
    private double[] coe;
    public Polynomial(double[] coe)
    {
        this.coe = coe;
    }
    public Polynomial()
    {
        coe = new double[1];
    }
    public Polynomial add(Polynomial addition)
    {
        double[] coef;
        int len1 = this.coe.length;
        int len2 = addition.coe.length;
        if (len1 > len2)
        coef = new double[len1];
        else
        coef = new double[len2];

        for(int i = 0; i < len1; i++)
        coef[i] += this.coe[i];

        for(int j=0; j < len2; j++)
        coef[j] += addition.coe[j];

        return new Polynomial(coef);
    }
    public double evaluate(double x)
    {
        double result = 0.0;
        for(int m =0; m < this.coe.length; m++)
        {
            result += this.coe[m] * Math.pow(x,m);
        }
        return result;
    }
    public boolean hasRoot(double y)
    {
        return evaluate(y) == 0.0;
    }
}
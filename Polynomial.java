import java.io.*;
import java.util.Scanner;
public class Polynomial
{
    private double[] coe;
    private int[] exp;
    public Polynomial(double[] coe,int[] exp)
    {
        this.coe = coe;
        this.exp = exp;
    }
    public Polynomial()
    {
        coe = new double[1];
        exp = new int[1];
    }
    public Polynomial add(Polynomial addition)
    {
        double[] coef;
        int len1 = this.exp.length;
        int len2 = addition.exp.length;
        int exp1 = this.exp[len1-1]+1;
        int exp2 = addition.exp[len2-1]+1;
        if (this.coe[0]==0 && len1==1)
        {
            return addition;
        }
        if (addition.coe[0]==0 && len2==1)
        {
            return new Polynomial(this.coe,this.exp);
        }
        if(exp1 >= exp2)
        {
            coef= new double [exp1];
        }
        else
        {
            coef = new double [exp2];
        }
        for(int i=0; i<len1;i++)
        {
            coef[this.exp[i]] = this.coe[i];
        }
        for(int j=0; j<len2; j++)
        {
            coef[addition.exp[j]] += addition.coe[j];
        } 
        int len3 = 0;
        for (int m=0; m<coef.length;m++)
        {
            if (coef[m]!=0)
            {
                len3++;
            }
        } 
        double[] res_coe = new double[len3];
        int[] res_exp = new int[len3];
        int start =0;
        for (int s=0; s<coef.length;s++)
        {
            if(coef[s]!=0)
            {
                res_coe[start]=coef[s];
                res_exp[start]=s;
                start++;
            }
        }
       
        return new Polynomial(res_coe,res_exp);
    }
    public double evaluate(double x)
    {
        double result = 0.0;
        for(int m =0; m < this.coe.length; m++)
        {
            result += this.coe[m] * Math.pow(x,this.exp[m]);
        }
        return result;
    }
    public boolean hasRoot(double y)
    {
        return evaluate(y) == 0.0;
    }
    public Polynomial multiply(Polynomial multiplication)
    {
        double[] coef;
        int len1 = this.exp.length;
        int len2 = multiplication.exp.length;
        int exp1 = this.exp[len1-1];
        int exp2 = multiplication.exp[len2-1];
        if (this.coe[0]==0 && len1==1)
        {
            return multiplication;
        }
        if (multiplication.coe[0]==0 && len2==1)
        {
            return new Polynomial(this.coe,this.exp);
        }
        if(exp1 >= exp2)
        {
            coef= new double [2*exp1];
        }
        else
        {
            coef = new double [2*exp2];
        }
        for(int i=0;i<len1;i++)
        {
            for(int j = 0; j<len2;j++)
            {
                double temp = 0;
                temp=this.coe[i]*multiplication.coe[j];
                coef[this.exp[i]+multiplication.exp[j]]= temp;
            }
        }
        int temp5=0;
        for(int y=0;y<coef.length;y++)
        {
            if(coef[y]!=0)
            temp5++;
        }
        double[] res_coef=new double[temp5];
        int[] res_expo=new int[temp5];
        int start=0;
        for (int m =0;m<coef.length;m++)
        {
            if(coef[m]!=0)
            {
                res_coef[start]=coef[m];
                res_expo[start]=m;
                start++;
            }
        }
        return new Polynomial(res_coef,res_expo);
    }
    public Polynomial(File file) throws FileNotFoundException
    {
        Scanner scan = new Scanner(file);
        String poly = scan.nextLine();
        scan.close();
        poly = poly.replace("-", "+-");
        String[] polys = poly.split("\\+"); 
        this.coe= new double[polys.length];
        this.exp = new int[polys.length];
        for (int w = 0; w < polys.length; w++)
        {
        String[] data = polys[w].split("x");
        this.coe[w] = Double.parseDouble(data[0]);
        if(data.length==1)
            {
             this.exp[w] = 0;
            }
        else
            {
                this.exp[w] =Integer.parseInt(data[1]);
            }
        }
    }
    public void saveToFile(String file) throws IOException
    {
    FileWriter writer = new FileWriter(file);
    String data = "";
    data += this.coe[0] + "x" + this.exp[0];
    for (int i = 1; i < this.coe.length; i++)
    {
        if(this.coe[i]<0)
        {
            data += this.coe[i] + "x" + this.exp[i];
        }
        else
        {
            data += "+" + this.coe[i] + "x" + this.exp[i];
        }
    }
    writer.write(data);
    writer.close();
    }
}
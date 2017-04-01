package fractals;

/**
 * Created by Deb Rezanka on 3/25/2017.
 */

public class Complex
{
  private double real;
  private double imaginary;

  public Complex(double x, double y)
  {
    real = x;
    imaginary = y;
  }

  public Complex getSquare()
  {
    Complex newValue;
    double tempReal = (real * real) - (imaginary * imaginary);
    double tempImaginary = 2 * (real * imaginary);
    newValue = new Complex(tempReal, tempImaginary);
    return newValue;
  }

  public Complex getSum(Complex a, Complex b)
  {
    Complex newValue = new Complex((a.real + b.real), (a.imaginary + b.imaginary));
    return newValue;
  }

  public double getAbsVal()
  {
    double temp = Math.max(real, imaginary);
    return temp;
  }
}

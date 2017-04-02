package fractals;

/**
 * @author Deb Rezanka
 * The Complex class contains methods to calculate powers of
 * complex numbers, addition of complex numbers and absolute
 * value of complex numbers.
 */
//***********************************
//Deb Rezanka
//
//Complex method handles calculations using
//complex numbers.
//***********************************

public class Complex
{
  private static boolean DEBUG = false;
  private double real;
  private double imaginary;

  public Complex(double x, double y)
  {
    real = x;
    imaginary = y;
  }

  /**
   * getPower calculates the value of the input complex number raised
   * to the input power.
   *
   * @param power: the value the complex number is to be raised to
   * @param old: The base number being raised to a power.
   * @return: Complex value raised to the input value
   */
  //***********************************
  //getPower calculates the value of the input complex number raised
  //to the input power. Input = int power and Complex number old.
  // output = complex number raised to the input power
  //***********************************

  public static Complex getPower(int power, Complex old)
  {
    Complex newValue;
    double newReal = old.real;
    double newImaginary = old.imaginary;
    double tempReal;
    double tempImaginary;

    for(int i = 1; i < power; i++)
    {
      tempReal = (old.real * newReal) - (old.imaginary * newImaginary);
      tempImaginary = (old.real * newImaginary) + (newReal * old.imaginary);
      newReal = tempReal;
      newImaginary = tempImaginary;
    }
    newValue = new Complex(newReal, newImaginary);

    if(DEBUG)
    {
      System.out.println("power: " + power + " value: " + old.real + " + " + old.imaginary);
      System.out.println("new Complex: " + newReal + " + " + newImaginary);
    }
    return newValue;
  }

  /**
   * getSum calculates the sum of two complex numbers and returns it
   * @param a: Complex value a
   * @param b: Complex Value b
   * @return: the Complex sum of the inputs
   */
  //***********************************
  //getSum calculates the sum of two complex numbers and returns it
  // Input = two complex numbers
  // output = complex value of the sum of the two inputs
  //***********************************
  public Complex getSum(Complex a, Complex b)
  {
    Complex newValue = new Complex((a.real + b.real), (a.imaginary + b.imaginary));
    return newValue;
  }

  /**
   * getAbsVal is used to get the maximum value of this complex number.
   * @return: double, the maximum value of the real and imaginary parts of a
   * complex number
   */
  //***********************************
  // getAbsVal is used to get the maximum value of this complex number.
  // output = double value of the maximum value of the complex number.
  //***********************************
  public double getAbsVal()
  {
    double temp = Math.max(this.real, this.imaginary);
    return temp;
  }
}

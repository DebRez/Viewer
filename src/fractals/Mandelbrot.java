package fractals;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * @author Deb Rezanka
 * Mandelbrot draws the mandelbrot patten for
 * any available power. Mandelbrot extends Fractal.
 */
//***********************************
//Deb Rezanka
//
//Mandelbrot draws the requested mandelbrot
//pattern using the requested color scheme.
//
//***********************************
public class Mandelbrot extends Fractal
{
  private boolean DEBUG = false;
  private static int maxIterations;
  private int iterations;
  private double realStart;
  private double realEnd;
  private double imaginaryStart;
  private double imaginaryEnd;
  private double epsilon;
  private Complex constant;
  private Complex zed;
  private double bailout;
  private Canvas canvas;
  private GraphicsContext gtx;
  private List<Color> colors;

  /**
   * Mandelbrot is responsible for drawing the Mandelbrot pattern
   * @param rs: double, real starting point.
   * @param re: double, real ending point.
   * @param is: double, imaginary starting point.
   * @param ie: double, imaginary ending point.
   * @param iter: int, maximum number of iterations.
   * @param colorScheme: int, colorScheme to use for the fractal.
   * @param bo: double, bailout/threshold value to use.
   * @param can: Canvas, canvas to draw on.
   * @param power: int, power to raise zed to in the equation
   *             zed = zed ^ power + constant
   **/
  public Mandelbrot(double rs, double re, double is, double ie, int iter, int colorScheme,
                    double bo, Canvas can, int power)
  {
    super(colorScheme);
    maxIterations = iter;
    bailout = bo;
    canvas = can;
    gtx = canvas.getGraphicsContext2D();
    realStart = rs;
    realEnd = re;
    imaginaryStart = is;
    imaginaryEnd = ie;
    epsilon = calculateEpsilon();
    colors = this.getColorScheme();

    int next = 0;
    int i = -1;
    int j = -1;

    for(x = realStart; x < realEnd; x += epsilon)
    {
      j += 1;
      i = -1;

      for(y = imaginaryStart ; y < imaginaryEnd; y += epsilon)
      {
        i += 1;
        iterations = 0;
        constant = new Complex(x, y);
        zed = new Complex(0, 0);
        while(zed.getAbsVal() < bailout && iterations < maxIterations)
        {
          //zed = zed * zed + complex;
          zed = zed.getPower(power, zed);
          zed = zed.getSum(zed, constant);
          iterations += 1;
        }
        gtx.setFill(getColor(iterations));
        gtx.fillRect(j, i, 1, 1);
      }
    }
  }

  /**
   * @return epsilon: double, used as step size
   * the maximum of the relation between start and stop points and window size
   * is used to determine the step size to use.
   */
  //***********************************
  // calculateEpsilon returns the maximum value of the range to display/size of the canvas
  // it is used to determine the step size to use.
  //
  //***********************************

  private double calculateEpsilon()
  {
    epsilon = Math.max(((Math.abs(realStart) + Math.abs(realEnd)) / canvas.getWidth()),
              (Math.abs((imaginaryStart ) + Math.abs(imaginaryEnd))));

    if(DEBUG) System.out.println("epsilon is: " + epsilon);

    return epsilon;
  }

  /**
   *
   * @param it: integer, number of iteration to get to the bailout value
   * @return color: Color, used to set pixel color
   */
  //***********************************
  // getColor returns the appropriate color for the number
  // of iterations needed to get to the bailout value.
  // Colors are based on the chosen color scheme.
  //***********************************
  private Color getColor(int it)
  {
    Color color;
    if(DEBUG) System.out.println("its: " + it);
    //background color
    if(it <= 9 || it >= maxIterations)
    {
      color = colors.get(0);
    }
    else if(it <= 10)
    {
      color = colors.get(11);
    }
    else if(it <= 12)
    {
      color = colors.get(1);
    }
    else if(it <= 14)
    {
      color = colors.get(3);
    }
    else if(it <= 16)
    {
      color = colors.get(4);
    }
    else if(it <= 18)
    {
      color = colors.get(5);
    }
    else if(it <= 20)
    {
      color = colors.get(6);
    }
    else if(it <= 22)
    {
      color = colors.get(7);
    }
    else if(it <= 24)
    {
      color = colors.get(8);
    }
    else if(it <= 26)
    {
      color = colors.get(9);
    }
    else if(it <= 28)
    {
      color = colors.get(10);
    }
    else if(it <= 36)
    {
      color = colors.get(1);
    }
    else if(it <= 46)
    {
      color = colors.get(2);
    }
    else if(it <= 56)
    {
      color = colors.get(3);
    }
    else if(it <= 66)
    {
      color = colors.get(4);
    }
    else if(it <= 76)
    {
      color = colors.get(5);
    }
    else if(it <= 86)
    {
      color = colors.get(6);
    }
    else if(it <= 96)
    {
      color = colors.get(7);
    }
    else if(it <= 106)
    {
      color = colors.get(8);
    }
    else if(it <= 116)
    {
      color = colors.get(9);
    }
    else if(it <= 126)
    {
      color = colors.get(10);
    }
    else if(it <= 136)
    {
      color = colors.get(1);
    }
    else if(it <= 146)
    {
      color = colors.get(2);
    }
    else if(it <= 156)
    {
      color = colors.get(3);
    }
    else if(it <= 166)
    {
      color = colors.get(4);
    }
    else if(it <= 176)
    {
      color = colors.get(5);
    }
    else if(it <= 186)
    {
      color = colors.get(6);
    }
    else if(it <= 196)
    {
      color = colors.get(7);
    }
    else if(it <= 206)
    {
      color = colors.get(8);
    }
    else if(it <= 216)
    {
      color = colors.get(9);
    }
    else if(it <= 226)
    {
      color = colors.get(10);
    }

    //background color
    else color = colors.get(0);

    return color;
  }
}

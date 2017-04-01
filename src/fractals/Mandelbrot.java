package fractals;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.List;

/**
 * Created by Deb Rezanka on 3/25/2017.
 */
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

  //x, y come from the Fractal Class
  public Mandelbrot(double rs, double re, double is, double ie, int iter, int colorScheme,
                    double bo, Canvas can) throws ClassNotFoundException, IllegalAccessException
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
          zed = zed.getSquare();
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
  private Color getColor(int it)
  {
    Color color;
    if(DEBUG) System.out.println("its: " + it);
    //background color
    if(it <= 9)
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
    //background color
    else color = colors.get(0);

    return color;
  }
}

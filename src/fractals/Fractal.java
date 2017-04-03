package fractals;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Deb Rezanka
 * Fractal is an abstract class holding
 * the color schemes. It is meant to make adding
 * new functinality easier in the future.
 */

//***********************************
//Deb Rezanka
//
//Fractal is an abstract class that all fractal
// pattern should inherit from to get shared
// resources
//
//***********************************

public abstract class Fractal
{
  private boolean DEBUG = true;
  public double x;
  public double y;
  private List<Color> colorScheme = new ArrayList<>();
  private List<Color> temp = new ArrayList<>();

  public Fractal(int cs)
  {
    colorScheme = setColorScheme(cs);
  }

  /**
   *
   * @param cs integer value to indicate which colorScheme to use
   * @return ArrayList<Color> of the requested colorScheme
   *
   * temp[0] is used as the background color. Default scheme is Forest
   **/
  //***********************************
  //setColorScheme returns a color scheme based on the
  //Users choice. Default is Forest.
  //***********************************

  private ArrayList<Color> setColorScheme(int cs)
  {
    temp.clear();

    switch(cs)
    {
      //Desert Scheme
      case 0:
        temp.add(0, Color.DARKSLATEGREY);
        temp.add(1, Color.GOLD);
        temp.add(2, Color.WHITE);
        temp.add(3, Color.DARKGOLDENROD);
        temp.add(4, Color.TAN);
        temp.add(5, Color.SADDLEBROWN);
        temp.add(6, Color.CHOCOLATE);
        temp.add(7, Color.PALEGOLDENROD);
        temp.add(8, Color.SANDYBROWN);
        temp.add(9, Color.GOLDENROD);
        temp.add(10, Color.OLIVEDRAB);
        temp.add(11, Color.LIGHTGOLDENRODYELLOW);
        break;

      //Forest scheme
      case 1:
        temp.add(0, Color.BLACK);
        temp.add(1, Color.DARKGREEN);
        temp.add(2, Color.FORESTGREEN);
        temp.add(3, Color.GREENYELLOW);
        temp.add(4, Color.OLIVE);
        temp.add(5, Color.SADDLEBROWN);
        temp.add(6, Color.GOLD);
        temp.add(7, Color.OLIVEDRAB);
        temp.add(8, Color.YELLOWGREEN);
        temp.add(9, Color.YELLOW);
        temp.add(10, Color.DARKGOLDENROD);
        temp.add(11, Color.WHITE);
        break;

      //Ocean scheme
      case 2:
        temp.add(0, Color.BLACK);
        temp.add(1, Color.MIDNIGHTBLUE);
        temp.add(2, Color.ROYALBLUE);
        temp.add(3, Color.MEDIUMSLATEBLUE);
        temp.add(4, Color.SLATEGRAY);
        temp.add(5, Color.CADETBLUE);
        temp.add(6, Color.AQUAMARINE);
        temp.add(7, Color.LIGHTSEAGREEN);
        temp.add(8, Color.DARKCYAN);
        temp.add(9, Color.DODGERBLUE);
        temp.add(10, Color.PALEGREEN);
        temp.add(11, Color.DODGERBLUE);
        break;

      //Sunrise scheme
      case 3:
        temp.add(0, Color.BLACK);
        temp.add(1, Color.ROYALBLUE);
        temp.add(2, Color.ORANGERED);
        temp.add(3, Color.YELLOW);
        temp.add(4, Color.TOMATO);
        temp.add(5, Color.ORANGERED);
        temp.add(6, Color.ORANGE);
        temp.add(7, Color.GOLD);
        temp.add(8, Color.YELLOW);
        temp.add(9, Color.CORNSILK);
        temp.add(10, Color.HONEYDEW);
        temp.add(11, Color.MIDNIGHTBLUE);
        break;

      //ocean scheme
      default:
        temp.add(0, Color.BLACK);
        temp.add(1, Color.MIDNIGHTBLUE);
        temp.add(2, Color.ROYALBLUE);
        temp.add(3, Color.MEDIUMSLATEBLUE);
        temp.add(4, Color.SLATEGRAY);
        temp.add(5, Color.CADETBLUE);
        temp.add(6, Color.AQUAMARINE);
        temp.add(7, Color.LIGHTSEAGREEN);
        temp.add(8, Color.DARKCYAN);
        temp.add(9, Color.DODGERBLUE);
        temp.add(10, Color.PALEGREEN);
        temp.add(11, Color.DODGERBLUE);

        break;

    }
    return (ArrayList<Color>) temp;
  }

  /**
   *
   * @return ArrayList, returns the array list of Colors
   * for the requested color Scheme. Default is Forest.
   */
  //***********************************
  //getColorScheme returns a color scheme based on the
  //Users choice. Default is Forest.
  //***********************************

  public ArrayList<Color> getColorScheme()
  {
    return (ArrayList<Color>) colorScheme;
  }
}

package fractals;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deb Rezanka on 3/25/2017.
 */
public abstract class Fractal
{
  private boolean DEBUG = true;
  public double x;
  public double y;
  private List<Color> colorScheme = new ArrayList<>();
  private List<Color> temp = new ArrayList<>();

  public Fractal(int cs) throws ClassNotFoundException, IllegalAccessException
  {
    colorScheme = setColorScheme(cs);
  }

  /**
   *
   * @param cs integer value to indicate which colorScheme to use
   * @return ArrayList<Color> of the requested colorScheme
   *
   *   temp[0] is the background color.
   * */
  private ArrayList<Color> setColorScheme(int cs)
  {
    temp.clear();

    switch(cs)
    {
      //Practice scheme - kind of horrible
      case 0:
        temp.add(0, Color.BLACK);
        temp.add(1, Color.RED);
        temp.add(2, Color.WHITE);
        temp.add(3, Color.BLUE);
        temp.add(4, Color.GREEN);
        temp.add(5, Color.ORANGE);
        temp.add(6, Color.LIGHTSEAGREEN);
        temp.add(7, Color.SADDLEBROWN);
        temp.add(8, Color.AQUAMARINE);
        temp.add(9, Color.YELLOW);
        temp.add(10, Color.AQUA);
        temp.add(11, Color.WHEAT);
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

  public ArrayList<Color> getColorScheme()
  {
    return (ArrayList<Color>) colorScheme;
  }
}

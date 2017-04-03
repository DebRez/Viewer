package gui;

import fractals.Fractal;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import fractals.Mandelbrot;

/**
 * @author Deb Rezanka
 * 04/01/17
 * Fractal Viewer - GUI
 */
//***********************************
//Deb Rezanka
//
//Main builds the Gui and
//controls input from user
//
//***********************************

public class Main extends Application implements EventHandler<ActionEvent>
{
  private BorderPane root;
  private Scene scene;
  private StackPane frame;
  private HBox controls;
  private static Canvas canvas;
  private static final double WIDTH = 1000;
  private static final double HEIGHT = 1000;

  private MenuBar menuBar;
  private Menu fileMenu = new Menu("File");
  private MenuItem exit = new MenuItem("Exit");
  private Menu chooseFractal = new Menu("Fractal");
  private MenuItem mb2 = new MenuItem("Mandelbrot^2");
  private MenuItem mb3 = new MenuItem("Mandelbrot^3");
  private MenuItem mb4 = new MenuItem("Mandelbrot^4");
  private MenuItem mb5 = new MenuItem("Mandelbrot^5");
  private MenuItem mb6 = new MenuItem("Mandelbrot^6");
  private MenuItem mb2SeaHorse = new MenuItem("MB2 -0.75, 0.1");
  private MenuItem mb2Spiral = new MenuItem("MB2 -0.274, 0.482");
  private MenuItem mb2Scepter = new MenuItem("MB2 -0.1, 0.83");
  private Menu chooseColors = new Menu("Color Scheme");
  private MenuItem c1 = new MenuItem("Desert");
  private MenuItem c2 = new MenuItem("Forest");
  private MenuItem c3 = new MenuItem("Ocean");
  private MenuItem c4 = new MenuItem("Sunrise");
  //default values
  private int iterations = 170;
  private int colorScheme = 1;
  private double bailout = 4.0;
  private int power = 2;
  //default start and end points
  private double realStart = -2.1;
  private double realEnd = 1;
  private double imagStart = -1.2;
  private double imagEnd = 1.2;

  /**
   *
   * @param primaryStage the Stage
   * @throws Exception exception handler
   */
  //***********************************
  //start builds the gui
  //The Mandelbrot to the power of 2 in
  //color scheme Forest is the default display
  //***********************************
  @Override
  public void start(Stage primaryStage) throws Exception
  {
    //TODO bailout
    primaryStage.setTitle("Fractal Viewer by Deb Rezanka");
    root = new BorderPane();
    scene = new Scene(root, WIDTH, HEIGHT);
    frame = new StackPane();
    controls = new HBox(10);
    root.setTop(controls);
    root.setCenter(frame);
    canvas = new Canvas(WIDTH, HEIGHT);
    canvas.setVisible(true);
    frame.getChildren().addAll(canvas);
    //place default picture
    new Mandelbrot(realStart, realEnd, imagStart, imagEnd, iterations, colorScheme, bailout, canvas, 2);

    //controls
    menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu, chooseFractal, chooseColors);
    controls.getChildren().addAll(menuBar);
    fileMenu.getItems().add(exit);
    exit.setOnAction(e -> System.exit(0));

    chooseFractal.getItems().addAll(mb2, mb3, mb4, mb5, mb6, mb2SeaHorse, mb2Spiral, mb2Scepter);
    mb2.setOnAction(this);
    mb3.setOnAction(this);
    mb4.setOnAction(this);
    mb5.setOnAction(this);
    mb6.setOnAction(this);
    mb2SeaHorse.setOnAction(this);
    mb2Spiral.setOnAction(this);
    mb2Scepter.setOnAction(this);


    chooseColors.getItems().addAll(c1, c2, c3, c4);
    c1.setOnAction(this);
    c2.setOnAction(this);
    c3.setOnAction(this);
    c4.setOnAction(this);

    primaryStage.setScene(scene);
    primaryStage.show();
  }
  /**
   * handle calls the fractal to redraw when changes have been
   * made.
   * @param event: event handler for the menu
   */
  //***********************************
  //handle contains the logic for handling
  //gui interface events, redraws the requested pattern when
  //changes have been made.
  // ***********************************
  @Override
  public void handle(ActionEvent event)
  {
    canvas.getGraphicsContext2D().clearRect(0, 0, WIDTH, HEIGHT);
    Object source = event.getSource();
    if(source == mb2)
    {
      power = 2;
      realStart = -2.1;
      realEnd = 1;
      imagStart = -1.2;
      imagEnd = 1.2;
    }
    else if(source == mb3)
    {
      power = 3;
      realStart = -1.4;
      realEnd = 1.4;
      imagStart = -1.4;
      imagEnd = 1.4;
    }
    else if(source == mb4)
    {
      power = 4;
      realStart = -1.4;
      realEnd = 1.4;
      imagStart = -1.4;
      imagEnd = 1.4;
    }
    else if(source == mb5)
    {
      power = 5;
      realStart = -1.4;
      realEnd = 1.4;
      imagStart = -1.4;
      imagEnd = 1.4;
    }
    else if(source == mb6)
    {
      power = 6;
      realStart = -1.4;
      realEnd = 1.4;
      imagStart = -1.4;
      imagEnd = 1.4;
    }
    else if(source == mb2SeaHorse)
    {
      power = 2;
      realStart = -0.75;
      realEnd = 0.1;
      imagStart = -0.75;
      imagEnd = 0.1;
    }
    else if(source == mb2Spiral)
    {
      power = 2;
      realStart = -0.274;
      realEnd = 0.482;
      imagStart = -0.274;
      imagEnd = 0.482;
    }
    else if(source == mb2Scepter)
    {
      power = 2;
      realStart = -0.1002;
      realEnd = 0.8383;
      imagStart = -0.1002;
      imagEnd = 0.8383;
    }

    else if(source == c1)
    {
      colorScheme = 0;
    }
    else if(source == c2)
    {
      colorScheme = 1;
    }
    else if(source == c3)
    {
      colorScheme = 2;
    }
    else if(source == c4)
    {
      colorScheme = 3;
    }
    new Mandelbrot(realStart, realEnd, imagStart, imagEnd,
              iterations, colorScheme, bailout, canvas, power);
  }
  public static void main(String[] args) {
        launch(args);
    }


}

package gui;

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
public class Main extends Application
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
  private Menu optionMenu = new Menu("Options");
  private Menu chooseFractal = new Menu("Choose Fractal Equation");
  private Menu helpMenu = new Menu("Help");
  private MenuItem readme = new MenuItem("Open Readme File");
  private int iterations = 170;
  private int colorScheme = 3;
  private double bailout = 4.0;
  //default start and end points
  private double realStart = -1.5;
  private double realEnd = 0.7;
  private double imagStart = -1;
  private double imagEnd = 1;

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

    //controls
    menuBar = new MenuBar();
    menuBar.getMenus().addAll(fileMenu, optionMenu, helpMenu);
    controls.getChildren().addAll(menuBar);
    fileMenu.getItems().add(exit);
    exit.setOnAction(event -> System.exit(0));
    helpMenu.getItems().addAll(readme);
    readme.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        ;//TODO: show readme file
      }
    });
    optionMenu.getItems().addAll(chooseFractal);
    //TODO setup choose color and choose equation Menu's
    Menu mandelbrot = new Menu("Mandelbrot^2");
    MenuItem mb1 = new MenuItem("MB1");
    chooseFractal.getItems().add(mandelbrot);
    mandelbrot.getItems().addAll(mb1);

    primaryStage.setScene(scene);
    primaryStage.show();
    mb1.setOnAction(new EventHandler<ActionEvent>()
    {
      @Override
      public void handle(ActionEvent event)
      {
        try
        {
          new Mandelbrot(realStart, realEnd, imagStart, imagEnd, iterations, colorScheme, bailout, canvas);
        }
        catch (ClassNotFoundException e)
        {
          e.printStackTrace();
        }
        catch (IllegalAccessException e)
        {
          e.printStackTrace();
        }
      }
    });
  }

  public static void main(String[] args) {
        launch(args);
    }
}

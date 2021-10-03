import shapes.*;
import java.util.*;

/**
 * A class that tests the ShapeContainer class
 * @author Efe Beydoðan
 * @version 08.03.2020
 */
public class ShapeTester
{
   public static void main( String[] args)
   {
      Scanner scan = new Scanner( System.in);
      
      // constants
      
      // variables
      String input;
      ShapeContainer shape;
      String selectShape;
      int width;
      int length;
      int squareSide;
      int radius;
      int x;
      int y;
      int shapeX;
      int shapeY;
      Selectable select;
      
      // program code
      
      selectShape = "";
      shape = null;
      do
      {
         System.out.println( "=================================================================");
         System.out.println( "Please enter a selection: ");
         System.out.println( "(1) Create an empty set of shapes");
         System.out.println( "(2) Add as many square, circle and rectangles to it as you wish");
         System.out.println( "(3) Print out the total surface area of the entire set of shapes");
         System.out.println( "(4) Print out information about all of the shapes in the container");
         System.out.println( "(5) Find the first shape that contains a given x,y point and toggle its selected state");
         System.out.println( "(6) Remove all selected shapes from the set of shapes");
         System.out.println( " Enter Quit to exit");
         System.out.println( "=================================================================");
         
         // Prompt the user for an input
         input = scan.next();
         
         if ( input.equals( "1"))
         {
            // Create an empty ShapeContainer
            shape = new ShapeContainer();
            System.out.println( "Creating empty ShapeContainer...");
         }
         else if ( input.equals( "2"))
         {
            // If the ShapeContainer hasn't been initialized give a warning
            if ( shape == null)
            {
               System.out.println( "You haven't created an empty ShapeContainer yet!");
            }
            else
            {
               do
               {
                  System.out.println( "Select the shape you want to add: (1) Rectangle, (2) Square, (3) Circle OR enter (4) to go back to the main menu");
                  selectShape = scan.next();
                  if ( selectShape.equals( "1"))
                  {
                     System.out.println( "Please enter the width");
                     width = scan.nextInt();
                     if ( width <= 0)
                     {
                        System.out.println( "Enter a valid value!");
                     }
                     else
                     {
                        System.out.println( "Please enter the length");
                        length = scan.nextInt();
                        if ( length <= 0)
                        {
                           System.out.println( "Enter a valid value!");
                        }
                        else
                        {
                           shape.add( new Rectangle( width, length));
                           System.out.println( "Enter the x coordinate: ");
                           shapeX = scan.nextInt();
                           System.out.println( "Enter the y coordinate: ");
                           shapeY = scan.nextInt();
                           shape.lastShape().setLocation( shapeX, shapeY);
                        }
                        
                     }
                  }
                  else if ( selectShape.equals( "2"))
                  {
                     System.out.println( "Please enter one side of the square");
                     squareSide = scan.nextInt();
                     if ( squareSide <= 0)
                     {
                        System.out.println( "Enter a valid value!");
                     }
                     else
                     {
                        shape.add( new Square( squareSide));
                        System.out.println( "Enter the x coordinate: ");
                        shapeX = scan.nextInt();
                        System.out.println( "Enter the y coordinate: ");
                        shapeY = scan.nextInt();
                        shape.lastShape().setLocation( shapeX, shapeY);
                     }
                     
                  }
                  else if ( selectShape.equals( "3"))
                  {
                     System.out.println( "Please enter the radius of the circle");
                     radius = scan.nextInt();
                     if ( radius <= 0)
                     {
                        System.out.println( "Enter a valid value!");
                     }
                     else
                     {
                        shape.add( new Circle( radius));
                        System.out.println( "Enter the x coordinate: ");
                        shapeX = scan.nextInt();
                        System.out.println( "Enter the y coordinate: ");
                        shapeY = scan.nextInt();
                        shape.lastShape().setLocation( shapeX, shapeY);
                     }
                  }
                  else if ( !selectShape.equals( "4"))
                  {
                     System.out.println( "Invalid input!");
                  }
               } while ( !selectShape.equals( "4"));
            }
         }
         else if ( input.equals( "3"))
         {
            if ( shape == null)
            {
               System.out.println( "You haven't created an empty ShapeContainer yet!");
            }
            else
            {
               if ( shape.getSize() == 0)
               {
                  System.out.println( "There are no shapes!");
               }
               else
               {
                  System.out.println( "The total surface area of all the shapes is " + shape.getArea());
               }
            }
         }
         else if ( input.equals( "4"))
         {
            if ( shape == null)
            {
               System.out.println( "You haven't created an empty ShapeContainer yet!");
            }
            else
            {
               if ( shape.getSize() == 0)
               {
                  System.out.println( "There are no shapes!");
               }
               else
               {
                  System.out.println( shape.toString());
               }
            }
         }
         else if ( input.equals( "5"))
         {
            if ( shape == null)
            {
               System.out.println( "You haven't created an empty ShapeContainer yet!");
            }
            else
            {
               System.out.println( "Please enter an x value: ");
               x = scan.nextInt();
               System.out.println( "Please enter a y value: ");
               y = scan.nextInt();
               
               Shape s = shape.findShape( x, y);
               if ( s == null)
               {
                  System.out.println( "No such shape!");
               }
               else
               {
                  select = (Selectable) s;
                  select.setSelected( !select.getSelected());
                  s = (Shape) select;
                  System.out.println( "The shape: " + s); 
               }
            }
         }
         else if ( input.equals( "6"))
         {
            if ( shape == null)
            {
               System.out.println( "You haven't created an empty ShapeContainer yet!");
            }
            else
            {
               System.out.println( "Removing all selected shapes");
               shape.removeSelected();
            }
         }
         else if ( !input.equals( "Quit"))
         {
            System.out.println( "Invalid input!");
         }
         
      } while ( !input.equals( "Quit"));
      
      System.out.println( "You quit");
   }
}
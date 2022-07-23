package ru.kami.thinkinjava.chapter14;

abstract class Shape
{
 private static boolean isHighlighted;

 void draw()
 {
  System.out.println(this + ".draw()");
 }

 public static boolean isIsHighlighted()
 {
  return isHighlighted;
 }

 public static void setIsHighlighted(boolean isHighlighted)
 {
  Shape.isHighlighted = isHighlighted;
 }

 abstract public boolean rotate();

 @Override
 public String toString()
 {
  return isHighlighted ? "is highlighted" : "is not highlighted";
 }
}

class Circle extends Shape
{
 @Override
 public boolean rotate()
 {
  return false;
 }
}

class Triangle extends Shape
{
 @Override
 public boolean rotate()
 {
  return true;
 }
}

class Square extends Shape
{
 @Override
 public boolean rotate()
 {
  return true;
 }
}

class Rhomboid extends Shape
{
 @Override
 public boolean rotate()
 {
  return true;
 }
}

/**
 * Tasks:
 * 3. Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a Shape, then downcast it back to a Rhomboid.
 *    Try downcasting to a Circle and see what happens.
 *
 * 4. Modify the previous exercise so that it uses instanceof to check the type before performing the downcast.
 *
 * 5. Implement a rotate(Shape) method in Shapes.java,
 *    such that it checks to see if it is rotating a Circle (and, if so, doesn’t perform the operation).
 *
 * 6. Modify Shapes.java so that it can "highlight" (set a flag in) all shapes of a particular type.
 *    The toString( ) method for each derived Shape should indicate whether that Shape is "highlighted."
 */
public class Shapes_3_6
{
 public static void main(String[] args)
 {
  // Апкаст к классу Shape.
  Shape shape = new Rhomboid();
  // Даункаст к классу Rhomboid
  if (shape instanceof Rhomboid)
  {
   Rhomboid rhomboid = (Rhomboid) shape;
   System.out.println(rhomboid);
  }
  else
  {
   // Выбросится ClassCastException
   Circle circle = (Circle) shape;
  }
 }
}

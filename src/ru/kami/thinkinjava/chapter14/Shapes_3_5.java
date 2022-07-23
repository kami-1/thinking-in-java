package ru.kami.thinkinjava.chapter14;

abstract class Shape
{
 void draw()
 {
  System.out.println(this + ".draw()");
 }

 abstract public boolean rotate();

 abstract public String toString();
}

class Circle extends Shape
{
 @Override
 public boolean rotate()
 {
  return false;
 }

 @Override
 public String toString()
 {
  return "Circle";
 }
}

class Triangle extends Shape
{
 @Override
 public boolean rotate()
 {
  return true;
 }

 @Override
 public String toString()
 {
  return "Triangle";
 }
}

class Square extends Shape
{
 @Override
 public boolean rotate()
 {
  return true;
 }

 @Override
 public String toString()
 {
  return "Square";
 }
}

class Rhomboid extends Shape
{
 @Override
 public boolean rotate()
 {
  return true;
 }

 @Override
 public String toString()
 {
  return "Rhomboid";
 }
}

/**
 * Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a Shape, then downcast it back to a Rhomboid.
 * Try downcasting to a Circle and see what happens.
 */
public class Shapes_3_5
{
 public static void main(String[] args)
 {
  // Апкаст к классу Shape.
  Shape shape = new Rhomboid();
  // Даункаст к классу Rhomboid
  if (shape instanceof Rhomboid)
  {
   Rhomboid rhomboid = (Rhomboid) shape;
  }
  else
  {
   // Выбросится ClassCastException
   Circle circle = (Circle) shape;
  }
 }
}

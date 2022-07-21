package ru.kami.thinkinjava.chapter14;

class Toy_2
{
    Toy_2()
    {
    }

    Toy_2(int i)
    {
    }
}

class FancyToy_2 extends Toy_2 implements HasBatteries_2, Waterproof_2, Shoots_2, NewInterface
{
    FancyToy_2()
    {
        super(1);
    }
}

interface HasBatteries_2
{
}

interface Shoots_2
{
}

interface Waterproof_2
{
}

interface NewInterface
{
}

/**
 * Task: Incorporate a new kind of interface into ToyTest.java and verify that it is detected and displayed properly.
 */
public class ToyTest_2
{

    static void printInfo(Class cc)
    {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
    }

    public static void main(String[] args)
    {
        Class c = null;
        try
        {
            c = Class.forName("ru.kami.thinkinjava.chapter14.FancyToy_2");
        } catch (ClassNotFoundException e)
        {
            System.out.println("Can’t find FancyToy_2");
            System.exit(1);
        }
        printInfo(c);
        for (Class face : c.getInterfaces())
            printInfo(face);
        Class up = c.getSuperclass();
        Object obj = null;
        try
        {
            // Requires default constructor:
            obj = up.newInstance();
        } catch (InstantiationException e)
        {
            System.out.println("Cannot instantiate");
            System.exit(1);
        } catch (IllegalAccessException e)
        {
            System.out.println("Cannot access");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}

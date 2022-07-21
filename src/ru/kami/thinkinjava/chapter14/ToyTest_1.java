package ru.kami.thinkinjava.chapter14;

class Toy
{
    //Toy() {}
    Toy(int i)
    {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots
{
    FancyToy()
    {
        super(1);
    }
}

interface HasBatteries
{
}

interface Shoots
{
}

interface Waterproof
{
}


/**
 * Task: Comment out Toy’s default constructor and explain what happens.
 *
 * Ответ: Class.newInstance() Этот метод использует дефолтный конструктор класса Toy,
 *        передает ссылку на инстанс Object затем его даункастит к Toy.
 *        Без дефолтного конструктора выбросится исключение {@link InstantiationException}.
 */
public class ToyTest_1
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
            c = Class.forName("ru.kami.thinkinjava.chapter14.FancyToy");
        } catch (ClassNotFoundException e)
        {
            System.out.println("Can’t find FancyToy");
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

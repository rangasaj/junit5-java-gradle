package me.jaga.basics.junit5;

public class Calculator {

    public static int addForPositiveNumbers(int a, int b) {
        if(a < 0 || b < 0)
            throw new UnsupportedOperationException("Negative Numbers not supported");
        return a+b;
    }
}

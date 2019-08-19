package com.thoughtworks.shokunin.fact;

import io.vavr.collection.List;

public class FactFactory {

    private static final List<Class<? extends Fact>> factClasses = List.of(
            NotTheBest.class,
            NotTheWorst.class,
            NotTheBestOrTheWorst.class,
            IsBetterThan.class,
            IsNotDirectlyBelowOrAbove.class
    );

    public static Fact getFact(String factString) {
        return factClasses
                .filter(clazz -> accepts(clazz, factString))
                .map(clazz -> instantiateFact(clazz, factString))
                .getOrElse(new NullFact(factString));
    }

    private static Fact instantiateFact(Class<? extends Fact> clazz, String factString) {
        try {
            return clazz.getDeclaredConstructor(String.class).newInstance(factString);
        } catch (Exception e) {
            return new ErrorFact(e);
        }
    }

    private static boolean accepts(Class<? extends Fact> clazz, String factString) {
        try {
            return (boolean) clazz.getMethod("accepts", String.class).invoke(null, factString);
        } catch (Exception e) {
            return false;
        }
    }
}

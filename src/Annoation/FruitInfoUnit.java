package Annoation;

import java.lang.reflect.Field;
public class FruitInfoUnit {
    public static void getFruitInfo(Class<?> clasz){
        Field[] fields = clasz.getFields();

        for (Field field : fields){
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = (FruitName) field.getAnnotation(FruitName.class);
                System.out.println(fruitName.value());
            }
            else  if (field.isAnnotationPresent(FruitProvider.class)){
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                System.out.println(fruitProvider.id() + " " + fruitProvider.address() + " " + fruitProvider.name());
            }

        }
    }
}

package Annoation;

public class Apple {
    @FruitName("Apple")
    public String name;

    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    public String appleProvider;

    public static void main(String[] argv){
        FruitInfoUnit.getFruitInfo(Apple.class);
    }

}

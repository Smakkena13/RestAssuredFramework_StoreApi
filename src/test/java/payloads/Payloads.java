package payloads;

import com.github.javafaker.Faker;
import pojo.ProductPojo;

import java.util.Random;

public class Payloads {
    private static final Faker faker=new Faker();
    private static final String[] categories={"food","technology","ai","transport","beauty","books"};
    public Random rm=new Random();

    public ProductPojo ProductPayload(){
        String name= faker.commerce().productName();
        double price=Double.parseDouble(faker.commerce().price());
        String description= faker.lorem().sentence();
        String imgurl="https://fakestoreapi.com/icons/logo.png";
        String category=categories[rm.nextInt(categories.length)];

        return new ProductPojo(name,price,description,category,imgurl);
    }
}

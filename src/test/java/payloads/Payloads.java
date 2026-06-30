package payloads;

import com.github.javafaker.Faker;
import pojo.CartPojo;
import pojo.ProductPojo;
import pojo.UserPojo;

import java.util.Random;

public class Payloads {
    private static final Faker faker=new Faker();
    private static final String[] categories={"food","technology","ai","transport","beauty","books"};
    public static final Random rm=new Random();

    //product
    public static ProductPojo ProductPayload(){
        String name= faker.commerce().productName();
        double price=Double.parseDouble(faker.commerce().price());
        String description= faker.lorem().sentence();
        String imgurl="https://fakestoreapi.com/icons/logo.png";
        String category=categories[rm.nextInt(categories.length)];

        return new ProductPojo(name,price,description,category,imgurl);
    }

    //cart
    public CartPojo CartPayload(){
        int userId=faker.number().randomDigit();
        String date=faker.date().toString();

        return new CartPojo(userId,date);
    }

    //user
    public UserPojo UserPayload(){
        String email=faker.internet().emailAddress();
        String username=faker.name().fullName();
        String password=faker.finance().toString();
        String phone=faker.phoneNumber().cellPhone();

        return new UserPojo(email,username,password,phone);
    }
}

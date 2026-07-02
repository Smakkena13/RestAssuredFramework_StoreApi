package payloads;

import com.github.javafaker.Faker;
import pojo.*;

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

        String firstname=faker.name().firstName();
        String lastname=faker.name().lastName();

        Name name=new Name(firstname,lastname);

        String lat=faker.address().latitude();
        String log=faker.address().longitude();

        Geolocation geolocation=new Geolocation(lat,log);

        String city=faker.address().city();
        String street=faker.address().streetName();
        int number=rm.nextInt(20);
        String zipcode=faker.address().zipCode();

        Address address=new Address(city,street,number,zipcode,geolocation);

        String email=faker.internet().emailAddress();
        String username=faker.name().fullName();
        String password=faker.internet().password();
        String phone=faker.phoneNumber().cellPhone();

        return new UserPojo(email,username,password,name,address,phone);
    }
}

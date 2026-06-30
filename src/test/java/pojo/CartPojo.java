package pojo;

public class CartPojo {
    public CartPojo(int userId, String date){
        this.userId=userId;
        this.date=date;
    }

    private int userId;
    private String date;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

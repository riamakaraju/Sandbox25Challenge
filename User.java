import java.util.ArrayList;

//represents a user in given JSON data
//how the JSON data users are initially formatted to as an object
public class User {
    String name;
    int userId;
    ArrayList<Integer> reviews;

    User(String name, int userId, ArrayList<Integer> reviews) {
        this.name = name;
        this.userId = userId;
        this.reviews = reviews;
    }

    //returns user's name
    public String getName() {
        return this.name;
    }

    //returns user's id
    public int getUserId() {
        return this.userId;
    }

    //returns the reviews made by a user
    public ArrayList<Integer> getReviews() {
        return this.reviews;
    }
}
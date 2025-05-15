import java.util.ArrayList;

//represents a user in given JSON data
public class User {
    String name;
    int userId;
    ArrayList<Integer> reviews;

    User(String name, int userId, ArrayList<Integer> reviews) {
        this.name = name;
        this.userId = userId;
        this.reviews = reviews;
    }

    public String getName() {
        return this.name;
    }

    public int getUserId() {
        return this.userId;
    }

    public ArrayList<Integer> getReviews() {
        return this.reviews;
    }
}
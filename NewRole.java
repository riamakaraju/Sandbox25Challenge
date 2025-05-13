import java.util.ArrayList;

public class NewRole {
    String name;
    int id;
    double avgPay;
    double avgRating;
    ArrayList<NewReview> reviews;

    NewRole(String name, int id, double avgPay, double avgRating, ArrayList<NewReview> reviews) {
        this.name = name;
        this.id = id;
        this.avgPay = avgPay;
        this.avgRating = avgRating;
        this.reviews = reviews;
    }
}

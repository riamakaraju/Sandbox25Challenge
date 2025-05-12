import com.google.gson.Gson;
import java.io.Reader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try {
            Reader readerRole = new FileReader("requestContent.json");
            Reader readerReview = new FileReader("requestContent.json");
            Reader readerUser = new FileReader("requestContent.json");

            Gson gson = new Gson();

            Roles allroles = gson.fromJson(readerRole, Roles.class);
            ArrayList<Role> roles = allroles.roles;

            Reviews allReviews = gson.fromJson(readerReview, Reviews.class);
            ArrayList<Review> reviews = allReviews.reviews;

            Users allUsers = gson.fromJson(readerUser, Users.class);
            ArrayList<User> users = allUsers.users;


        }

        catch (Exception e) {
            System.out.println("Try again! Something went wrong.");
        }
    }
}

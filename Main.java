import com.google.gson.Gson;
import java.io.Reader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {
            Reader readerRole = new FileReader("requestContent.json");
            Reader readerReview = new FileReader("requestContent.json");
            Reader readerUser = new FileReader("requestContent.json");

            Gson gson = new Gson();


            Roles allroles = gson.fromJson(readerRole, Roles.class);
            ArrayList<Role> roles = allroles.getRoles();

            Reviews allReviews = gson.fromJson(readerReview, Reviews.class);
            ArrayList<Review> reviews = allReviews.getReviews();

            Users allUsers = gson.fromJson(readerUser, Users.class);
            ArrayList<User> users = allUsers.getUsers();

            //sorts all the Roles by COMPANY
            List<List<Role>> sortedRoles = new ArrayList<>(
                    roles.stream()
                            .collect(Collectors.groupingBy(Role::getCompany))
                            .values());
            // sorts all the Reviews by ROLE
            List<List<Review>> sortedReviews = new ArrayList<>(
                    reviews.stream()
                            .collect(Collectors.groupingBy(Review::getRoleId))
                            .values());

            Map<String, Object> returnInfo = new HashMap<>();
            //for each company, makes a map where the key is the company's name as a String
            //and the value is the roles in the company
            for (List<Role> comp : sortedRoles) {
                returnInfo.put(comp.get(0).getCompany(), helperRoles(comp));
            }
        }


        catch (Exception e) {
            System.out.println("Try again! Something went wrong.");
        }
    }
}

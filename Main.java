import com.google.gson.Gson;
import java.io.Reader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static class Methods {

        //makes a
        public Map<String, Object> helperRoles(List<Role> roleList) {
            Map<String, Object> rolesReturn = new HashMap<>();
            for (Role r : roleList) {
                rolesReturn.put(r.getRole(), makesRoles(r));
            }
            return rolesReturn;
        }

        public Map<String, Object> makesRoles(Role role) {
            Map<String, Object> roleReturn = new HashMap<>();
            List<Map<String, Object>> roleReviews = getAllReviews(role);
            roleReturn.put("reviews", roleReviews);
            roleReturn.put("avgRating", calculateAvgRating(roleReviews);
            roleReturn.put("avgPay", calculateAvgPay(roleReviews));
            roleReturn.put("id", role.getRoleId());
            roleReturn.put("name", role.getRole());
            return roleReturn;
        }

        public List<Map <String, Object>> getAllReviews(Role role){
            List<Map <String, Object>> reviewReturn = new ArrayList<>();


            for (Review r : sortedReviews) {
                Map<String, Object> singleReview = new HashMap<>();
                singleReview.put("review", r.getRatingId());
                singleReview.put("pay", r.getHourlyPay());
                singleReview.put("rating", r.getOverallScore());
                singleReview.put("user", "NAME PLACEHOLDER");
                reviewReturn.add(singleReview);
            }

            return reviewReturn;
        }

        public double calculateAvgRating(List<Map<String, Object>> reviews) {
            for (Review r : reviews) {

            }
        }
    }

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

            //sorts all the Roles by company
            List<List<Role>> sortedRoles = new ArrayList<>(
                    roles.stream()
                            .collect(Collectors.groupingBy(Role::getCompany))
                            .values());

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

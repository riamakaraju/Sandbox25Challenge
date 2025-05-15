import com.google.gson.Gson;
import java.io.Reader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;


public class Main {
    //defining mapOfReviews in advance as empty maps to be populated with data in main function
    static Map<Integer, List<Review>> mapOfReviews = new HashMap<>();
    static Map<Integer, String> userIdToName = new HashMap<>();

    //makes the map of all roles in a company
    public static Map<String, Object> makeMapOfRoles(List<Role> rolesInCompany) {
        Map<String, Object> returnRoles = new LinkedHashMap<>();
        for (Role role : rolesInCompany) {
            Map<String, Object> newRole = new LinkedHashMap<>();
            newRole.put("name", role.getRole());
            newRole.put("id", role.getRoleId());
            newRole.put("avgPay", calcAvgPay(role.getRoleId()));
            newRole.put("avgRating", calcAvgRating(role.getRoleId()));
            newRole.put("reviews", makeListOfReviews(role.getRoleId()));
            returnRoles.put(role.getRole(), newRole);
        }
        return returnRoles;
    }

    // makes the list of reviews for one role (:
    public static List<Object> makeListOfReviews(int id) {
        List<Object> returnReviews = new ArrayList<Object>();
        //finds all the reviews for a certain role based on roleid
        List<Review> tempListOfReviews = Main.mapOfReviews.get(id);
        //if there are no reviews for a role
        if (tempListOfReviews == null) {
            return returnReviews;
        }
        // if there are review(s) for a role, for each review in the list of reviews,
        // formats the data of the review in a single map and adds that map to the
        //list of review
        else {
            for (Review review : tempListOfReviews) {
                Map<String, Object> tempReview = new LinkedHashMap<>();
                tempReview.put("user", matchName(review.getUserId()));
                tempReview.put("rating", review.getOverallScore());
                tempReview.put("pay", review.getHourlyPay());
                tempReview.put("review", review.getRatingId());
                returnReviews.add(tempReview);
            }
        }
        /*
        SortingUtils.quickSort(sortedReviews, new Comparator<Review>() {
            public int compare(Map<String, Object> r1, Map<String, Object> r2) {
                int diff = r1.get("rating")().compareTo(r2.get("rating")());
                if (diff != 0) return diff;
                return Long.compare(r1.getId(), r2.getId());
            }
        });

         */

        Comparator<Map<String, Object>> mapComparator = new Comparator<Map<String, Object>>() {
            public int compare(Map<String, Object> rating1, Map<String, Object> rating2) {
                return rating2.get("rating").compareTo(rating1.get("rating"));
            }
        };
        System.out.println(mapComparator);
        Collections.sort(returnReviews, mapComparator);

    }

    // match userId to name
    public static String matchName(int userId) {
        return Main.userIdToName.get(userId);
    }

    //calculates average rating of a role
    public static double calcAvgRating(int id) {
        List<Review> tempListOfReviews = Main.mapOfReviews.get(id);
        float avgRating = 0;
        //if there are no reviews, the rating is 0
        if (tempListOfReviews == null) {
            return avgRating;
        }
        //if there are reviews, calculate the average
        else {
            for (Review review : tempListOfReviews) {
                avgRating += review.getOverallScore();
            }
        }
        return avgRating / tempListOfReviews.size();
    }

    // calculates average pay of a role
    public static double calcAvgPay(int id) {
        List<Review> tempListOfReviews = Main.mapOfReviews.get(id);
        float avgPay = 0;
        //if there are no reviews, the pay is 0
        if (tempListOfReviews == null) {
            return avgPay;
        }
        //if there are reviews, calculate the average pay
        else {
            for (Review review : tempListOfReviews) {
                avgPay += review.getHourlyPay();
            }
        }
        return avgPay / tempListOfReviews.size();
    }


    public static void main(String[] args) {

        try {
            // creating a fileReader for each of the three JSON value types we
            // want to collect (role, review, and user)
            Reader readerRole = new FileReader("requestContent.json");
            Reader readerReview = new FileReader("requestContent.json");
            Reader readerUser = new FileReader("requestContent.json");

            Gson gson = new Gson();

            //inputting the JSON roles into allRoles, creating a Role object
            // for each review
            Roles allroles = gson.fromJson(readerRole, Roles.class);
            ArrayList<Role> roles = allroles.getRoles();

            //inputting the JSON roles into allReviews, creating a Review object
            // for each review
            Reviews allReviews = gson.fromJson(readerReview, Reviews.class);
            ArrayList<Review> reviews = allReviews.getReviews();

            //inputting the JSON users into allUsers, creating a User object
            // for each user
            Users allUsers = gson.fromJson(readerUser, Users.class);
            ArrayList<User> users = allUsers.getUsers();

            //sorts all the Roles by COMPANY, puts them into sortedRoles
            List<List<Role>> sortedRoles = new ArrayList<>(
                    roles.stream()
                            .collect(Collectors.groupingBy(Role::getCompany))
                            .values());

            // sorts all the Reviews by ROLE, puts them into sortedReviews
            List<List<Review>> sortedReviews = new ArrayList<>(
                    reviews.stream()
                            .collect(Collectors.groupingBy(Review::getRoleId))
                            .values());

            // mapping each roleId to the list of reviews of that role
            for (List<Review> listOfReviews : sortedReviews) {
                mapOfReviews.put(listOfReviews.get(0).getRoleId(), listOfReviews);
            }

            // makes map that links userId to user's name for quick usage when sorting
            for (User user : users) {
                userIdToName.put(user.getUserId(), user.getName());
            }

            // makes the map of all companies with formatted content
            Map<String, Object> returnCompanies = new TreeMap<>();
            for (List<Role> rolesInCompany : sortedRoles) {
                returnCompanies.put(rolesInCompany.get(0).getCompany(), makeMapOfRoles(rolesInCompany));
            }

            // makes the final return map with one key value pair
            Map<String, Object> finalReturn = new LinkedHashMap<>();
            finalReturn.put("companies", returnCompanies);

            //converts the formatted data to JSON and prints it
            System.out.println(gson.toJson(finalReturn));
        }

        // required catch for fileReader error
        catch (Exception e) {
            System.out.println("Try again! Something went wrong." + e);
            e.printStackTrace();
        }
    }
}

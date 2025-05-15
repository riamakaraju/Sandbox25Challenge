import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
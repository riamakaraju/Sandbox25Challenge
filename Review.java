//represents a review in given JSON data
public class Review {
    int roleId;
    int ratingId;
    int overallScore;
    int hourlyPay;
    int userId;

    Review(int roleId, int ratingId, int overallScore, int hourlyPay, int userId) {
        this.roleId = roleId;
        this.ratingId = ratingId;
        this.overallScore = overallScore;
        this.hourlyPay = hourlyPay;
        this.userId = userId;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public int getRatingId() {
        return this.ratingId;
    }

    public int getOverallScore() {
        return this.overallScore;
    }

    public int getHourlyPay() {
        return this.hourlyPay;
    }

    public int getUserId() {
        return this.userId;
    }


}
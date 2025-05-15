//represents a review in given JSON data
//how the JSON data reviews are initially formatted to as an object

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

    //returns the role the review is about
    public int getRoleId() {
        return this.roleId;
    }

    //returns the review's id
    public int getRatingId() {
        return this.ratingId;
    }

    //returns the score in the review
    public int getOverallScore() {
        return this.overallScore;
    }

    //returns the hourly pay in the review
    public int getHourlyPay() {
        return this.hourlyPay;
    }

    //returns the userid of the review writer
    public int getUserId() {
        return this.userId;
    }

}
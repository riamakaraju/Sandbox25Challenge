//represents a role in given JSON data
class role {
    String role;
    int roleId;
    String company;

    role(String role, int roleId, String company) {
        this.role = role;
        this.roleId = roleId;
        this.company = company;
    }
}

//represents a review in given JSON data
class review {
    int roleId;
    int ratingId;
    int overallScore;
    int hourlyPay;
    int userId;

    review(int roleId, int ratingId, int overallScore, int hourlyPay, int userId) {
        this.roleId = roleId;
        this.ratingId = ratingId;
        this.overallScore = overallScore;
        this.hourlyPay = hourlyPay;
        this.userId = userId;
    }
}

//represents a user in given JSON data
class user {
    String name;
    String userId;
    ArrayList<int> reviews;

    user(String name, String userId, ArrayList<review> reviews) {
        this.name = name;
        this.userId = userId;
        this.reviews = reviews;
    }
}

Reader reader = new FileReader("requestContent.json");
Gson gson = new Gson();

ArrayList<role> listOfRoles = new Arraylist<role>();
System.out.println(reader.roles);
System.out.println("please work");

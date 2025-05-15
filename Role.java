//represents a role in given JSON data
//how the JSON data roles are initially formatted to as an object
public class Role {
    String role;
    int roleId;
    String company;

    Role(String role, int roleId, String company) {
        this.role = role;
        this.roleId = roleId;
        this.company = company;
    }

    //returns the role's name
    public String getRole() {
        return this.role;
    }

    //returns the role's id
    public int getRoleId() {
        return this.roleId;
    }

    //returns the role's company
    public String getCompany() {
        return this.company;
    }
}
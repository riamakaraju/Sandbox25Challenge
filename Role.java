//represents a role in given JSON data
public class Role {
    String role;
    int roleId;
    String company;

    Role(String role, int roleId, String company) {
        this.role = role;
        this.roleId = roleId;
        this.company = company;
    }

    public String getRole() {
        return this.role;
    }

    public int getRoleId() {
        return this.roleId;
    }

    public String getCompany() {
        return this.company;
    }
}
package Library;

/**
 * Member class to be completed by students (implements requirements).
 */
public class Member {
    private int memberId;
    private String name;
    private String phone;
    private String email;

    // Constructor chaining: primary constructor
    public Member(int memberId, String name, String phone, String email) {
        this.memberId = memberId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Overloaded constructor uses this()
    public Member(int memberId, String name) {
        this(memberId, name, "Not provided", "Not provided");
    }

    // Getters and setters
    public int getMemberId() { return memberId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Display method
    public void displayMemberInfo() {
        System.out.printf("MEMBER -> ID: %d | Name: %s | Phone: %s | Email: %s%n",
                memberId, name, phone, email);
    }
}

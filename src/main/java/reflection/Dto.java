package reflection;

public class Dto {

    private String firstName;
    private String lastName;
    private String patronymicName;
    private String email;
    private String phone;

    public Dto(String firstName, String lastName, String patronymicName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymicName = patronymicName;
        this.email = email;
        this.phone = phone;
    }
}
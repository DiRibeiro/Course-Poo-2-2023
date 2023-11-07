package fix3;

public class Author {
    private int peopleID;
    private String firstName;
    private String lastName;

    public Author(int peopleID, String firstName, String lastName) {
        this.peopleID = peopleID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Author() {
        super();
        firstName = this.firstName;
        lastName = this.lastName;
    }

    public void setPessoaID(int peopleID) {
        this.peopleID = peopleID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPeopleID() {
        return peopleID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

package auca.ac.rw.restfullApiAssignment.model.librarian;

public class Librarian {
    private Long librarianId;
    private String fullName;
    private String email;
    private String position;
    private int yearsOfExperience;

    public Librarian() {}

    public Librarian(Long librarianId, String fullName, String email, String position, int yearsOfExperience) {
        this.librarianId = librarianId;
        this.fullName = fullName;
        this.email = email;
        this.position = position;
        this.yearsOfExperience = yearsOfExperience;
    }

    public Long getLibrarianId() { return librarianId; }
    public void setLibrarianId(Long librarianId) { this.librarianId = librarianId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public void setYearsOfExperience(int yearsOfExperience) { this.yearsOfExperience = yearsOfExperience; }
}
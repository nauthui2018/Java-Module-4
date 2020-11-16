package model;

public class Employee {
    private String id;
    private String name;
    private String phone;

    public Employee() {
    }

    public Employee(String id, String name, String contactNumber) {
        this.id = id;
        this.name = name;
        this.phone = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

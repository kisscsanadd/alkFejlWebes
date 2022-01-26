package hu.alkfejl.model.bean;

public class Contact {
  private int id;
  private String name;
  private String birth;
  private String email;
  private String phone;
  private String address;
  private String position;
  private String organization;

  public Contact() {
  }

  public Contact(int id, String name, String birth, String email, String phone, String address, String position, String organization) {
    this.id = id;
    this.name = name;
    this.birth = birth;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.position = position;
    this.organization = organization;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirth() {
    return birth;
  }

  public void setBirth(String birth) {
    this.birth = birth;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getOrganization() {
    return organization;
  }

  public void setOrganization(String organization) {
    this.organization = organization;
  }
}


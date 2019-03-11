package kiinkiin.schedule.models;

public class Employee {
    private int employeeId;
    private String name;
    private String username;
    private String password;
    private String cpr;
    private String position;
    private String email;
    private String bankAccount;
    private String address;
    private String postcode;
    private String city;
    private String country;
    private String gender;
    private String phoneNumber;
    private int monday;
    private int tuesday;
    private int wednesday;
    private int thursday;
    private int friday;
    private int saturday;
    private int sunday;

    public Employee(){ }

    public Employee(int employeeId, String name){
        this.employeeId = employeeId;
        this.name = name;
    }

    public Employee(int employeeId, String name, String username, String password, String cpr, String position, String email, String bankAccount, String address, String postcode, String city, String country, String gender, String phoneNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.cpr = cpr;
        this.position = position;
        this.email = email;
        this.bankAccount = bankAccount;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }
    public Employee(int employeeId, String name, String username, String password, String cpr, String position, String email, String bankAccount, String address, String postcode, String city, String country, String gender, String phoneNumber, int monday, int tuesday, int wednesday, int thursday, int friday, int saturday, int sunday) {
        this.employeeId = employeeId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.cpr = cpr;
        this.position = position;
        this.email = email;
        this.bankAccount = bankAccount;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMonday() {
        return monday;
    }

    public void setMonday(int monday) {
        this.monday = monday;
    }

    public int getTuesday() {
        return tuesday;
    }

    public void setTuesday(int tuesday) {
        this.tuesday = tuesday;
    }

    public int getWednesday() {
        return wednesday;
    }

    public void setWednesday(int wednesday) {
        this.wednesday = wednesday;
    }

    public int getThursday() {
        return thursday;
    }

    public void setThursday(int thursday) {
        this.thursday = thursday;
    }

    public int getFriday() {
        return friday;
    }

    public void setFriday(int friday) {
        this.friday = friday;
    }

    public int getSaturday() {
        return saturday;
    }

    public void setSaturday(int saturday) {
        this.saturday = saturday;
    }

    public int getSunday() {
        return sunday;
    }

    public void setSunday(int sunday) {
        this.sunday = sunday;
    }

    public void addShifts(Schedule shift) {
        monday = shift.getMonday();
        tuesday = shift.getTuesday();
        wednesday = shift.getWednesday();
        thursday = shift.getThursday();
        friday = shift.getFriday();
        saturday = shift.getSaturday();
        sunday = shift.getSunday();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", cpr='" + cpr + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", monday=" + monday +
                ", tuesday=" + tuesday +
                ", wednesday=" + wednesday +
                ", thursday=" + thursday +
                ", friday=" + friday +
                ", saturday=" + saturday +
                ", sunday=" + sunday +
                '}';
    }
}

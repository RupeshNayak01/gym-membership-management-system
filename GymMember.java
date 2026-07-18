public abstract class GymMember{
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    // Constructor
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate){
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        attendance = 0;
        loyaltyPoints = 0.0;
        activeStatus = false;
    }
    
    // Accessor methods
    public int getId(){
        return id; 
    }
    public String getName(){
        return name;
    }
    public String getLocation(){ 
        return location; 
    }
    public String getPhone(){ 
        return phone; 
    }
    public String getEmail(){ 
        return email; 
    }
    public String getGender(){ 
        return gender; 
    }
    public String getDOB(){ 
        return DOB; 
    }
    public String getMembershipStartDate(){
        return membershipStartDate; 
    }
    public int getAttendance(){
        return attendance; 
    }
    public double getLoyaltyPoints(){ 
        return loyaltyPoints;
    }
    public boolean isActive(){
        return activeStatus; 
    }
    
    //Abstract method
    public abstract void markAttendance();
    
    // Method to activate membership
    public void activateMembership(){
        activeStatus = true;
        System.out.println("Membership is activated.");
    }
    
    // Method to deactivate membership
    public void deactivateMembership(){
        if(activeStatus == true){
            activeStatus = false;
        }else{
            System.out.println("Membership is already deactivated or hasn't been activated yet.");
        }
    }
    
    // Method to reset the GymMember
    public void resetMember(){
        activeStatus = false;
        attendance = 0;
        loyaltyPoints = 0.0;
    }
    
    // Method to display the details of the RegularMember
    public void display(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Location: " + location);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + DOB);
        System.out.println("Membership Start Date: " + membershipStartDate);
        System.out.println("Attendance: " + attendance);
        System.out.println("Loyalty Points: " + loyaltyPoints);
        System.out.println("Active Status: " + activeStatus);
    }

}
public class RegularMember extends GymMember{
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    // Constructor
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB, String membershipStartDate, String referralSource){
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        isEligibleForUpgrade = false;
        removalReason = "";
        attendanceLimit = 30;
        plan = "basic";
        price = 6500;
        this.referralSource = referralSource;
        
    }

    // Accessor methods
    public int getAttendanceLimit() {
        return attendanceLimit;
    }

    public boolean isEligibleForUpgrade() {
        return isEligibleForUpgrade;
    }

    public String getRemovalReason() {
        return removalReason;
    }

    public String getReferralSource() {
        return referralSource;
    }

    public String getPlan() {
        return plan;
    }

    public double getPrice() {
        return price;
    }

    // Implement abstract method markAttendance
    @Override
    public void markAttendance(){
        this.attendance += 1;
        this.loyaltyPoints += 5;
    }

    // Method to retrieve the price of the provided plan
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1;
        }
    }

    // Method to upgrade the plan
    public String upgradePlan(String plan){
        if(getAttendance() >= attendanceLimit){
            isEligibleForUpgrade = true;
        }
        
        if (this.isEligibleForUpgrade == true){
            if (this.plan.equalsIgnoreCase(plan)){
                return "You are already subscribed to the " + plan + " plan.";
            }else{
                this.plan = plan;
                price = getPlanPrice(plan);
                if(price == -1){
                    return "Invalid plan: " + plan;
                }else{
                    return "Successfully upgraded to " + plan + ".";
                }
            }
        }else{
            return "Not eligible for upgrade.";
        }
    }

    // Method to revert the member to regular status
    public void revertRegularMember(String removalReason){
        super.resetMember();
        isEligibleForUpgrade = false;
        plan = "basic";
        price = 6500;
        this.removalReason = removalReason;
    }

    // Method to display the details of the RegularMember
    @Override
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        if (!removalReason.isEmpty()){
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}

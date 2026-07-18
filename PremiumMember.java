public class PremiumMember extends GymMember{
    private final double premiumCharge;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;
    
    // Constructor
    public PremiumMember(int id, String name, String location, String phone, 
                         String email, String gender, String DOB, 
                         String membershipStartDate, String personalTrainer){
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        premiumCharge = 50000;
        paidAmount = 0.0;
        isFullPayment = false;
        discountAmount = 0.0;
        this.personalTrainer = personalTrainer;
    }

    // Accessor methods
    public double getPremiumCharge(){
        return premiumCharge;
    }

    public String getPersonalTrainer(){
        return personalTrainer;
    }

    public boolean isFullPayment(){
        return isFullPayment;
    }

    public double getPaidAmount(){
        return paidAmount;
    }

    public double getDiscountAmount(){
        return discountAmount;
    }

    public int getAttendance(){
        return attendance;
    }

    public double getLoyaltyPoints(){
        return loyaltyPoints;
    }

    // Abstract method implementation: markAttendance
    @Override
    public void markAttendance(){
        attendance += 1;
        loyaltyPoints += 10; // Increase loyalty points by 10
    }

    // Method to pay due amount
    public String payDueAmount(double paidAmount){
        // Update payment details
        if(isFullPayment == true){
            return "Payment is already complete. No further payment required.";
        }else if(this.paidAmount + paidAmount > premiumCharge){
            return "Payment exceeds the required premium charge. Please enter a valid amount.";
        }else{
            this.paidAmount += paidAmount;
            double remainingAmount = premiumCharge - this.paidAmount;
            
            // Update isFullPayment status
            isFullPayment = (this.paidAmount == premiumCharge);
            if(isFullPayment == true){
                return "Payment successful! Your premium membership is fully paid.";
            }else{
                return "Payment successful! Remaining amount to be paid: " + remainingAmount;
            }
        }
    }

    // Method to calculate discount
    public String calculateDiscount(){
        if(isFullPayment == true){
            discountAmount = premiumCharge * 0.10; // 10% discount
            return "Discount calculated successfully. Discount Amount: " + discountAmount;
        }else{
            return "No discount applicable. Full payment is required to get the discount.";
        }
    }

    // Method to revert PremiumMember
    public void revertPremiumMember(){
        super.resetMember(); // Calls superclass method
        personalTrainer = "";
        isFullPayment = false;
        paidAmount = 0.0;
        discountAmount = 0.0;
    }

    // Method to display details
    @Override
    public void display(){
        super.display(); // Displays superclass attributes
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        System.out.println("Full Payment: " + isFullPayment);
        double remainingAmount = premiumCharge - paidAmount;
        System.out.println("Remaining Amount: " + remainingAmount);

        if(isFullPayment == true){
            System.out.println("Discount Amount: " + discountAmount);
        }
    }
}

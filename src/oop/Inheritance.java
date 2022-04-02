package oop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Validator{
    static boolean isValidDeductionForChild(String reason){
        Pattern pattern = Pattern.compile("\\b(?i)(?:party|tour)\\b");
        Matcher matcher = pattern.matcher(reason);
        return !matcher.find();
    }
}

class Dad {
    private Double walletAmount = 1000d;

    public Double redeemAmountFromWallet(String reason, Double amount) throws Exception {
        if(ChildA.class.isInstance(this) || ChildB.class.isInstance(this)){
            if(Validator.isValidDeductionForChild(reason)){
                System.out.println("Child has deducted "+amount+" for "+reason + " from "+this.getClass().getName());
                walletAmount -= amount;
                return amount;
            }
        }
        throw new Exception("Invalid deduction nice try kid !!!");
    }

}

class Mom {
    private Double walletAmount = 1000d;

    public Double redeemAmountFromWallet(String reason, Double amount) throws Exception {
            System.out.println("Child has deducted "+amount+" for "+reason + " from "+this.getClass().getName());
            walletAmount -= amount;
            return amount;
    }
}

class ChildA extends Dad {
    private Double walletAmount = 0d;

    public Double redeemAmountFromWallet(String reason, Double amount) throws Exception {
        if(walletAmount>amount){
            walletAmount -= amount;
            return amount;
        }
        return super.redeemAmountFromWallet(reason, amount);
    }

}

class ChildB extends Mom {
    private Double walletAmount = 0d;

    public Double redeemAmountFromWallet(String reason, Double amount) throws Exception {
        if(walletAmount>amount){
            walletAmount -= amount;
            return amount;
        }
        return super.redeemAmountFromWallet(reason, amount);
    }
}

public class Inheritance {

    public static void main(String[] args) {

        ChildA childA = new ChildA();

        try {
            System.out.println(childA.redeemAmountFromWallet("party with friends", 500d));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ChildB childB = new ChildB();

        try {
            System.out.println(childB.redeemAmountFromWallet("Tour with friends", 500d));
            System.out.println("I got money I am happy to go for the party");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}

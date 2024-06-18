package AbstractFactoryPattern;

import BuilderPattern.BuilderPattern;

import java.util.Scanner;

public class AbstractFactoryPattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LoanFactory loanFactory = new LoanFactory();
        System.out.println("Give me Loan name");
        String loanName = sc.next();
        Loan loan = new LoanFactory().getLoan(loanName);

        System.out.println("Give me bank name");
        String bankName = sc.next();
        Bank bank = new BankFactory().getBank(bankName);

        bank.getBank();
        bank.getLoan(loan);

    }
}

interface Bank {
    void getBank();
    void getLoan(Loan loan);
}

interface Loan {
    void getLoan();
}

class HomeLoan implements Loan {

    @Override
    public void getLoan() {
        System.out.println("Home loan");
    }
}

class BusinessLoan implements Loan {

    @Override
    public void getLoan() {
        System.out.println("Business Loan");
    }
}

class HDFC implements Bank {

    @Override
    public void getBank() {
        System.out.println("HDFC");
    }

    @Override
    public void getLoan(Loan loan) {
        System.out.print("HDFC ");
        loan.getLoan();
    }
}

class SBI implements Bank {

    @Override
    public void getBank() {
        System.out.println("SBI");
    }

    @Override
    public void getLoan(Loan loan) {
        System.out.print("SBI ");
        loan.getLoan();
    }
}

abstract class Factory {
    abstract Loan getLoan(String name);
    abstract Bank getBank(String name);
}

class BankFactory extends Factory {

    @Override
    Loan getLoan(String name) {
        return null;
    }

    @Override
    Bank getBank(String name) {
        return switch (name) {
            case "HDFC" -> new HDFC();
            case "SBI" -> new SBI();
            default -> null;
        };
    }
}

class LoanFactory extends Factory {

    @Override
    Loan getLoan(String name) {
        return switch (name) {
            case "Home" -> new HomeLoan();
            case "Business" -> new BusinessLoan();
            default -> null;
        };
    }

    @Override
    Bank getBank(String name) {
        return null;
    }
}



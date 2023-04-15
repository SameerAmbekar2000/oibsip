package AtmImitator;

public interface Atm_Operation_Interface {
    public void viewBalance();
    public void withdrawAmount(double withdrawAmount);
    public void depositAmount(double depositAmount );
    void transferAmount(double transferAmount);
}


package lesson05.task01;

public class TerminalServer {
    private int balance;
    private String pin;

    public TerminalServer() {
        balance = 0;
        pin = "0123";
    }

    private final String secretCodeForPin = "Mystery";

    public int getPinHashCode() {
        return (secretCodeForPin + pin).hashCode();
    }

    public int getBalance() {
        return balance;
    }

    public void getMoney(int amount) throws TerminalServerException {
        if (amount > balance) throw new TerminalServerException("Недостаточно средств");
        balance -= amount;
    }

    public void putMoney(int amount) {
        balance += amount;
    }
}

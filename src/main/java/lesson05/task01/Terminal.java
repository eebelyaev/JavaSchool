package lesson05.task01;

public interface Terminal {
    void checkPin(String pin) throws AccountIsLockedException;

    boolean isAccessGranted();

    int getBalance() throws TerminalException;

    boolean checkAmount(int amount);

    void putMoney(int amount) throws TerminalException;

    void getMoney(int amount) throws TerminalException;
}

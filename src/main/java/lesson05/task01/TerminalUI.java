package lesson05.task01;

public interface TerminalUI {
    void inputPin();

    boolean isAccessGranted();

    void showMessage(String s);

    int selectAction();

    void viewBalance();

    void putMoney();

    void getMoney();

    void close();
}


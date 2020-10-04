package lesson05.task01;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TerminalUIImpl implements TerminalUI {
    private final Terminal terminal;
    private final Scanner scanner;

    public TerminalUIImpl(Terminal terminal) {
        this.terminal = terminal;
        scanner = new Scanner(System.in);
    }

    @Override
    public void inputPin() {
        if (isAccessGranted()) return;

        showMessage("Введите пин-код");
        String inpPin = scanner.nextLine();
        // если в строке есть хоть один нецифровой символ
        if (inpPin.matches(".*\\D.*")) {
            showMessage("Используйте только цифры");
        } else if (inpPin.length() != 4) {
            showMessage("Пин-код должен иметь длину 4 символа");
        } else
            try {
                terminal.checkPin(inpPin);
            } catch (AccountIsLockedException e) {
                showMessage(e.getMessage());
            }
    }

    @Override
    public boolean isAccessGranted() {
        return terminal.isAccessGranted();
    }

    @Override
    public void showMessage(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date()) + "> " + s);
    }

    @Override
    public int selectAction() {
        showMessage("Выберите действие (1 - узнать баланс, 2 - внести наличные, 3 - снять наличные, 0 - завершить работу)");
        String line = scanner.nextLine();
        if (line.matches("[0-3]")) return Integer.parseInt(line);
        return -1;
    }

    @Override
    public void viewBalance() {
        if (isAccessGranted()) {
            try {
                showMessage(String.valueOf(terminal.getBalance()));
            } catch (TerminalException e) {
                showMessage(e.getMessage());
            }
        } else showMessage("Нет доступа");
    }

    interface ManipulateMoneyMethod {
        void func(int amount) throws TerminalException;
    }

    /**
     * Выполняет действия по запросу и проверке суммы, вызывает указанный в параметре метод терминала.
     *
     * @param method    метод терминала putMoney или getMoney
     */
    private void manipulateMoney(ManipulateMoneyMethod method) {
        if (!isAccessGranted()) {
            showMessage("Нет доступа");
            return;
        }
        int amount = 0;
        String line;
        for (int i = 0; i < 3; i++) {
            showMessage("Введите сумму кратную 100 или -1 для завершения операции");
            line = scanner.nextLine();
            // введенное число может начинаться с "-", первая цифра не "0", не более 9-ти цифр
            if (line.matches("(-?[1-9](\\d){1,8})")) {
                amount = Integer.parseInt(line);
                if (amount == -1) {
                    showMessage("Операция прервана");
                    break;
                } else if (terminal.checkAmount(amount)) {
                    try {
                        method.func(amount);
                        showMessage("Операция выполнена\nТекущий баланс: " + terminal.getBalance());
                        break;
                    } catch (TerminalException e) {
                        showMessage(e.getMessage());
                        break;
                    }
                }
            } else {
                showMessage("Сумма введена неверно");
            }
        }
    }

    @Override
    public void putMoney() {
        manipulateMoney(terminal::putMoney);
    }

    @Override
    public void getMoney() {
        manipulateMoney(terminal::getMoney);
    }

    @Override
    public void close() {
        showMessage("Работа терминала завершена");
        //scanner.close();
    }
}

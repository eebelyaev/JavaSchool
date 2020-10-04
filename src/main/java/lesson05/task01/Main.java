package lesson05.task01;

public class Main {
    public static void main(String[] args) {
        TerminalServer terminalServer = new TerminalServer();
        PinValidator pinValidator = new PinValidator(terminalServer);
        Terminal terminal = new TerminalImpl(terminalServer, pinValidator);
        // создание и запуск
        TerminalUI terminalUI = new TerminalUIImpl(terminal);
        boolean workCompleted = false;

        while (!workCompleted) {
            terminalUI.inputPin();
            if (terminalUI.isAccessGranted()) {
                switch (terminalUI.selectAction()) {
                    case (0):
                        workCompleted = true;
                        terminalUI.close();
                        break;
                    case (1):
                        terminalUI.viewBalance();
                        break;
                    case (2):
                        terminalUI.putMoney();
                        break;
                    case (3):
                        terminalUI.getMoney();
                        break;
                    default:
                        terminalUI.showMessage("Не удалось распознать команду");
                }
            }
        }
    }
}

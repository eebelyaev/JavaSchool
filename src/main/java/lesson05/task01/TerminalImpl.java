package lesson05.task01;

import java.text.SimpleDateFormat;

public class TerminalImpl implements Terminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;

    private final int durationOfBlockInSec = 10;    // продолжительность блокировки в секундах
    private final int durationOfSessionInSec = 20;  // продолжительность сессии в секундах
    private final int limitOfEnterPin = 3;          // число неверно введенных пин-кодов перед блокировкой

    private long timeOfEndSessionInMs;     // время окончания сессии в милисекундах
    private long timeEndOfBlockInMs;       // время окончания блокировки в милисекундах
    private int countOfEnterPin;           // число неверно введенных пин-кодов

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
        timeOfEndSessionInMs = 0L;
        timeEndOfBlockInMs = 0L;
        countOfEnterPin = 0;
    }

    @Override
    public void checkPin(String pin) throws AccountIsLockedException {
        if (isBlocked()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            throw new AccountIsLockedException("Аккаунт заблокирован до " + dateFormat.format(timeEndOfBlockInMs));
        } else if (pinValidator.isPinCorrect(pin)) {
            timeEndOfBlockInMs = 0L;
            timeOfEndSessionInMs = System.currentTimeMillis() + durationOfSessionInSec * 1000;
        } else {
            if (++countOfEnterPin >= limitOfEnterPin) {
                countOfEnterPin = 0;
                timeEndOfBlockInMs = System.currentTimeMillis() + durationOfBlockInSec * 1000;
            }
        }
    }

    @Override
    public int getBalance() throws TerminalException {
        if (!isAccessGranted()) throw new TerminalException("Нет доступа");
        return server.getBalance();
    }

    @Override
    public boolean checkAmount(int amount) {
        return amount > 0 && amount % 100 == 0;
    }

    @Override
    public void putMoney(int amount) throws TerminalException {
        if (!isAccessGranted()) throw new TerminalException("Нет доступа");
        if (!checkAmount(amount)) throw new TerminalException("Сумма должна быть кратна 100");

        server.putMoney(amount);
    }

    @Override
    public void getMoney(int amount) throws TerminalException {
        if (!isAccessGranted()) throw new TerminalException("Нет доступа");
        if (!checkAmount(amount)) throw new TerminalException("Сумма должна быть кратна 100");
        if (getBalance() < amount) throw new TerminalException("Недостаточно средств");

        try {
            server.getMoney(amount);
        } catch (TerminalServerException e) {
            throw new TerminalException(e.getMessage());
        }
    }

    @Override
    public boolean isAccessGranted() {
        return timeOfEndSessionInMs > System.currentTimeMillis();
    }

    private boolean isBlocked() {
        return timeEndOfBlockInMs > System.currentTimeMillis();
    }

}

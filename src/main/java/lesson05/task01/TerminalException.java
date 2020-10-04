package lesson05.task01;

class TerminalException extends Exception {
    public TerminalException(String s) {
        super(s);
    }
}

class AccountIsLockedException extends Exception {
    public AccountIsLockedException(String s) {
        super(s);
    }
}
class TerminalServerException extends Exception {
    public TerminalServerException(String s) {
        super(s);
    }
}
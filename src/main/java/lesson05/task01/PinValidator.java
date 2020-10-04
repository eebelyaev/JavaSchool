package lesson05.task01;

public class PinValidator {
    private TerminalServer server;
    private final String secretCodeForPin = "Mystery";

    public PinValidator(TerminalServer server) {
        this.server = server;
    }

    public boolean isPinCorrect(String pin) {
        return (secretCodeForPin + pin).hashCode() == server.getPinHashCode();
    }
}

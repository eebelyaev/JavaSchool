package lesson10.task04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GammaCryptTest {

    @Test
    void getEncryptedText01() {
        String text = Stream.iterate('A', c -> (char) (c + 1))
                .limit(26)
                .map(c -> String.valueOf(c))
                .collect(Collectors.joining());
        String gamma = "UIBHYRVBK";
        String encryptedText = GammaCrypt.getEncryptedText(text, gamma);
        System.out.println("Текст: " + text + "\nГамма: " + gamma + "\nЗашифрованный текст: " + encryptedText);
        Assertions.assertEquals(GammaCrypt.getDecryptedText(encryptedText, gamma), text);
    }

    @Test
    void getEncryptedText02() {
        String text = "KJBYFVOKNKUTRDOIKLKMNKJFFOIKIUYEWQACVKPPMNBVCDERF";
        String gamma = "AMAPQZXB";
        String encryptedText = GammaCrypt.getEncryptedText(text, gamma);
        System.out.println("Текст: " + text + "\nГамма: " + gamma + "\nЗашифрованный текст: " + encryptedText);
        Assertions.assertEquals(GammaCrypt.getDecryptedText(encryptedText, gamma), text);
    }
}
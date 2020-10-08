package lesson10.task04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 4) С помощью lambda и Stream API реализуйте алгоритм шифрования текста методом
 * гаммирования (http://www.unn.ru/bibn/files/materials/kript/kr2.pdf).
 * Это творческое задание, в качестве гаммы используйте либо строку текста, либо
 * последовательность натуральных чисел. Результат шифрования необязательно должен поддаваться расшифровке :)
 */
public class GammaCrypt {
    private static final int nullCharInAlf = 'A' - 1;
    private static final int countOfSymbols = 26;

    /**
     * Применяет к тексту метод шифрования/расшифровки гамма-методом.
     * В зависимости от направления, указанного в параметре direction.
     *
     * @param text      шифруемый текст
     * @param gamma     кодовое слово
     * @param direction направление кодирования (true/false = зашифровать/расшифровать)
     * @return текст после применения шифрования
     */
    private static String applyGammaEncription(String text, String gamma, boolean direction) {
        // сохраним текст как список номеров букв в алфавите
        List<Integer> textList = Arrays.asList(text.split("")).stream()
                .map(s -> s.codePointAt(0) - nullCharInAlf)
                .collect(Collectors.toList());
        // сохраним код как список номеров букв в алфавите
        // инвертируется в зависимости от direction
        List<Integer> gammaList = Arrays.asList(gamma.split("")).stream()
                .map(s -> (direction ? 1 : -1) * (s.codePointAt(0) - nullCharInAlf))
                .collect(Collectors.toList());
        // сохраним длину текста
        int lengthText = text.length();
        // сохраним длину кода
        int lengthGamma = gamma.length();
        // создаем поток с элементами, которые содержат номер позиции в тексте,
        // номер позиции в коде и закодированный символ
        return Stream.iterate(new int[]{0, 0, 0},
                x -> {
                    int posText = (x[0] < lengthText) ? (x[0] + 1) : 1;
                    int posCode = (x[1] < lengthGamma) ? (x[1] + 1) : 1;
                    int cryptoChar = (textList.get(posText - 1) + gammaList.get(posCode - 1)) % countOfSymbols;
                    if (cryptoChar <= 0) cryptoChar += countOfSymbols;
                    return new int[]{posText, posCode, cryptoChar};
                })
                .limit(lengthText + 1).skip(1)
                .map(x -> (String.valueOf((char) (x[2] + nullCharInAlf))))
                .collect(Collectors.joining());
    }

    public static String getEncryptedText(String text, String gamma) {
        return applyGammaEncription(text, gamma, true);
    }

    public static String getDecryptedText(String text, String gamma) {
        return applyGammaEncription(text, gamma, false);
    }
}

package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null) {
            return new int[0];
        }
        if (inputArray.length != 0) {
            int lastElement = inputArray[inputArray.length - 1];
            for (int i = inputArray.length - 1; i > 0; i--) {
                inputArray[i] = inputArray[i - 1];
            }
            inputArray[0] = lastElement;
        }
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        if (inputArray.length == 1) {
            return inputArray[0];
        }
        int max1 = inputArray[0], max2 = inputArray[1];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] >= max1) {
                max2 = max1;
                max1 = inputArray[i];
            } else {
                if (inputArray[i] > max2) {
                    max2 = inputArray[i];
                }
            }
        }
        return (max1 * max2);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        int numberAB = 0;
        if (input != null && input.length() != 0) {
            String lowerCaseInput = input.toLowerCase();
            for (int i = 0; i < lowerCaseInput.length(); i++) {
                if (lowerCaseInput.charAt(i) == 'a' || lowerCaseInput.charAt(i) == 'b') {
                    numberAB++;
                }
            }
            return numberAB * 100 / input.length();
        }
        return 0;
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        int numberOfSymbol = 1;
        StringBuilder output = new StringBuilder();
        if (input != null) {
            String modifiedInput = input + " ";
            for (int i = 0; i < modifiedInput.length() - 1; i++) {
                if (modifiedInput.charAt(i) == modifiedInput.charAt(i + 1)) {
                    numberOfSymbol++;
                } else {
                    output.append(modifiedInput.charAt(i)).append(numberOfSymbol);
                    numberOfSymbol = 1;
                }
            }
        }
        return output.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() == 0 || two.length() == 0) {
            return false;
        }
        int[] firstCharCounter = new int[256];
        int[] secondCharCounter = new int[256];
        for (int i = 0; i < one.length(); i++) {
            firstCharCounter[(int) one.charAt(i)]++;
        }
        for (int i = 0; i < two.length(); i++) {
            secondCharCounter[(int) two.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (firstCharCounter[i] != secondCharCounter[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int[] charCounter = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charCounter[(int) s.charAt(i)]++;
        }
        for (int i = 0; i < 256; i++) {
            if (charCounter[i] > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if(m == null){
            return new int[0][0];
        }
        int[][] newMatrix = new int[m.length][m.length];
        if (m.length != 0) {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m.length; j++) {
                    newMatrix[i][j] = m[j][i];
                }
            }
        }
        return newMatrix;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        Character newSeparator = separator == null ? ' ' : separator;
        StringBuilder outputString = new StringBuilder();
        if (inputStrings != null && inputStrings.length != 0) {
            for (int i = 0; i < inputStrings.length - 1; i++) {
                outputString.append(inputStrings[i]).append(newSeparator);
            }
            outputString.append(inputStrings[inputStrings.length - 1]);
        }
        return outputString.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        int result = 0;
        if (inputStrings != null && prefix != null) {
            for (String inputString : inputStrings) {
                if (inputString != null && inputString.startsWith(prefix)) {
                    result++;
                }
            }
        }
        return result;
    }

}

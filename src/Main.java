public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1};
        int counter = 0; // счетчик для подсчета одинаковых цифр подряд
        StringBuilder amount = new StringBuilder(); // строка со значениями counter для нулей и единиц
        StringBuilder digits = new StringBuilder(); // строка для обозначения наполнения последовательности (либо нули, либо единицы)
        StringBuilder sequence = new StringBuilder(); // финальная строка для наибольшей последовательности цифр из нулей или единиц

        for(int i = 0; i < numbers.length; i++){ // внешний цикл
            for(int j = i; j < numbers.length; j++){ // внутренний цикл от первой цифры последовательности до первого несовпадения
                if(numbers[i] != numbers[j]){ // условие на первое несовпадение цифр
                    amount.append(counter);
                    digits.append(numbers[i]);
                    i += counter - 1;
                    counter = 0;
                    break;
                }
                if(j == numbers.length - 1){ // условие на поиск конца массива
                    amount.append(counter + 1);
                    digits.append(numbers[i]);
                    i += counter;
                    counter = 0;
                    break;
                }
                counter++; // увеличение переменной количества цифр в последовательности
            }
        }

        System.out.println(amount);
        System.out.println(digits);
        int max = Character.getNumericValue(amount.charAt(0));
        for(int i = 0; i < amount.length(); i++){ // цикл поиска максимального значения в строке с количествами
            char bufChar = amount.charAt(i);
            int bufInt = Character.getNumericValue(bufChar);
            if (bufInt > max) {
                max = bufInt;
            }
        }
        System.out.println(max);

        for(int i = 0; i < max; i++){ // цикл для заполнения финальной последовательности цифр совпадающей с их максимальным количеством
            sequence.append(digits.charAt(amount.indexOf(max + "")) + " ");
        }
        System.out.println(sequence);
    }
}
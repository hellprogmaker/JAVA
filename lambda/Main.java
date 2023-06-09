

public class Main {
    public static void main(String[] args) {

        Calculate calculate1;
        Calculate calculate2;
        Calculate calculate3;

        calculate1 = (x, y) -> x + y; // фактически реализуем функцию: int calculate(x, y) { return x + y;}
        calculate2 = (x, y) -> x - y;
        calculate3 = (x, y) -> x * y;

        System.out.println("x + y: " + calculate1.calculate(10, 20));
        System.out.println("x - y: " + calculate2.calculate(10, 20));
        System.out.println("x * y: " + calculate3.calculate(10, 20));

        // в лямбда выражении можно обойтись и без параметров. Например:
//        Calculate calculate4;
//        calculate4 = ()-> 100 + 1;

        // если используется только 1 параметр, то скобки можно опустить:
//        Calculate calculate5;
//        calculate5 = x -> x * x;

        // Терминальные лямбды, которые не возвращают никакого значения:
        Printable printable;
        printable = string->System.out.println(string);
        printable.printable("LOL");


        // Лямбды с условием:
//        Divide divide = (x, y) -> {
//
//            if (y == 0)
//                return x;
//
//            else
//                return x / y;
//        };
//
//        System.out.println("x, y != 0; x / y : " + divide.divide(96, 12));
//        System.out.println("x, y == 0; x / y : " + divide.divide(96, 0));


        // Лямбда + Generic:
        CalculateGeneric<Integer> calculateGeneric1 = (x, y) -> x + y;
        System.out.println("GENERIC: x + y : " + calculateGeneric1.calculateGeneric(10, 20));


        Parity parity = (x)->(x % 2 == 0);
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Parity sum from 1 to 10 is " + Sum(numbers, parity));

        // Можно передавать лямбда-выражение сразу в функцию:
        System.out.println("Sum of numbers, that more 5: " + Sum(numbers, (Parity) (x)->(x > 5)));


        // Ссылки на статичные методы:
        Expression expression1 = ExpressionOperations:: isPositiveNumber;
        System.out.println("> 0: " + Sum(numbers, expression1));

        Expression expression2 = ExpressionOperations:: isParityNumber;
        System.out.println("parity sum: " + Sum(numbers, (Expression) ExpressionOperations:: isParityNumber));


        // Для нестатичных методов:
        ExpressionOperations expression3 = new ExpressionOperations();
        System.out.println("not parity sum: " + Sum(numbers, (Expression) expression3:: isNotParityNumber));


        // ссылки на конструкторы:
//        PersonCreator personCreator = Person:: new;
//        Person person = personCreator.create("Alex");
//        System.out.println(person.GetName());


        // возвращение лямбда-выражений:
        CalculateGeneric<Integer> calculateGeneric = CALCULATE(2);
        int result = calculateGeneric.calculateGeneric(328, 100);
        System.out.println("result: " + result);
    }


    public static CalculateGeneric<Integer> CALCULATE(int variant) {

        switch(variant) {

            case 1:  return (x, y) -> x + y;
            case 2:  return (x, y) -> x - y;
            case 3:  return (x, y) -> x * y;
            default: return (x, y) -> x / y;
        }
    }


    interface Expression {

        boolean expresion(int x);
    }
    static class ExpressionOperations {

        static boolean isPositiveNumber(int x) {return (x > 0);}
        static boolean isParityNumber(int x) {return (x % 2 == 0);}
        boolean isNotParityNumber(int x) {return (x % 2 != 0);}
    }

    public static int Sum(int[] numbers, Parity parity) {

        int resultParity = 0;

        int i = 0;
        for(i = 0; i < numbers.length; i++)
            if(parity.isParity(numbers[i]) == true)
                resultParity += numbers[i];

        return resultParity;
    }

    public static int Sum(int[] numbers, Expression expression) {

        int resultParity = 0;

        int i = 0;
        for(i = 0; i < numbers.length; i++)
            if(expression.expresion(numbers[i]) == true)
                resultParity += numbers[i];

        return resultParity;
    }

    interface Calculate {

        int calculate(int x, int y);
    }

    interface Printable {

        void printable(String string);
    }

    interface Divide {

        int divide(int x, int y);
    }

    interface CalculateGeneric<T> {

        T calculateGeneric(T x, T y);
    }

    interface Parity {

        boolean isParity(int x);
    }

    interface PersonCreator {

        Person create(String name);
    }

    class Person {

        private String name;

        public Person(String name) {this.name = name;}
        String GetName() {return this.name;}
    }
}

package ru.geekbrains.java1.l2hw;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        byte arr[] = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};//создаю массив и сразу инициализирую элементы
        System.out.println(Arrays.toString(arr));
        change(arr);//инвертирую двоичный массив
        System.out.println(Arrays.toString(arr));

        int[] arr2 = new int [8];//создаю пустой целочисленный массив
        writeIn1D(arr2);//заполнение одномерного массива с шагом 3
        System.out.println(Arrays.toString(arr2));
        minMaxElements(arr2);
        System.out.println("Есть баланс? " + checkBalanse(arr2));

        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        minMaxElements(arr3);
        System.out.println("Есть баланс? " + checkBalanse(arr3));

        x2LowThan6(arr3); //умножение на 2 чисел меньших 6
        System.out.println(Arrays.toString(arr3));
        minMaxElements(arr3);
        System.out.println("Есть баланс? " + checkBalanse(arr3));;

        int[] arr4 = {7, 4, 3, 2, 6};
        System.out.println(Arrays.toString(arr4));
        minMaxElements(arr4);//поиск min и max элементов массива
        System.out.println("Есть баланс? " + checkBalanse(arr4));

        int[][] arrQuad = new int[6][6];//создаю пустой квадратный двумерный массив 6х6
        diag1(arrQuad); //заполнение диагоналей единицей и его распечатка

        //Смещение элементов массива
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr5));
        System.out.println("Есть баланс? " + checkBalanse(arr5));

        displacement(arr5, -3);//
        System.out.println(Arrays.toString(arr5));
        System.out.println("Есть баланс? " + checkBalanse(arr5));

    }

    // метод замены:
    public static void change (byte byteArray[]) {
            for (int i = 0; i < byteArray.length; i++){
                byteArray[i] = (byte) (1 - byteArray[i]); //приведение к типу byte, т.к. оказывается 1 по умолчанию является числом типа int
                //старая двустрочная версия:
//                if (byteArray[i] == 1) byteArray[i] = 0;
//                else byteArray[i] = 1;
        }
    }

    //метод заполнения одномерного массива с шагом 3
    public static void writeIn1D (int intArray[]){
        for (int i = 0, j = 0; i<intArray.length; i++, j+=3){
            intArray[i] = j;
        }
    }

    //метод умножения на 2 чисел меньших 6
    public static void x2LowThan6 (int intArray[]){
        for (int i = 0; i < intArray.length; i++) {
            if (intArray[i] < 6) intArray[i] *= 2; //intArray[i] = intArray[i] * 2;
        }
    }

    //метод заполнения диагоналей единицей и его распечатки
    public static void diag1 (int quadArray[][]){
        for (int i = 0, c = quadArray[0].length - 1; i < quadArray[0].length; i++, c--){
        //for (int i = 0, j = 0, c = quadArray[0].length - 1; i < quadArray[0].length; i++, j++, c--){//вариант с лишней переменной
            quadArray[i][i] = 1; //quadArray[i][j] = 1;//i - строка, j - столбец(лишняя переменная)
            quadArray[i][c] = 1;
            System.out.println(Arrays.toString(quadArray[i]));
        }
    }

    //метод определяющий мин. и макс. элементы одномер. массива
    public static void minMaxElements (int array[]) {
        int max = array[0], min = array[0];
        for (int a: array) {//цикл FOREACH
            if (a > max) max = a;
            else if (a < min) min = a;
        }
        System.out.println("min = " + min + "; max = " + max);
    }

    //метод сравнения сумм слева и справа в одномерном массиве
    public static boolean checkBalanse (int array[]){
        int sumRight, sumLeft;
        //boolean a = false; //это для старой версии метода с доп. переменной "а"
        //l - количество левых элементов, r - кол-во правых элементов
        for (int i = 0, l = array.length - 1, r = 1 ; i < array.length - 1; i++, l--, r++) {
            sumLeft = sumRight = 0;
            for (int j = 0; j < l; j++) {//перебор левых элементов
                sumLeft = sumLeft + array[j];
            }
            for (int k = 0; k < r ; k++) {//перебор правых элементов
                sumRight = sumRight + array[array.length - 1 - k];
            }
            if (sumLeft == sumRight) {
                return true;//a = true;
                //break;
            }
        }
        return false; //return a;
    }

    //метод смещения
    public static void displacement (int array[], int n){
        int c, b;
        n %= array.length;// адаптирую число под длину массива, чтобы излишне не гонять по кругу
        if(n < 0) n += array.length; //свиг влево (при n<0) равносилен сдвигу вправо на (array.length + n) элементов

        for (int i = 0; i < n; i++) {
            b = array[0]; //запись стартового значения "предыдущего элемента"
            for (int j = 0, k = 1; j < array.length ; j++, k++) {
                if (k == array.length) k = 0; //для перехода на нулевой элемент массива при выходе индекса за пределы массива
                c = array [k]; //запоминание значения "следующего элемента"
                array[k] = b;//запись в следующий элемент значения предыдущего элемента - смещение на 1 позицию вправо
                b = c; //запись значения предыдущего элемента для следующей итерации цикла
            }
        }
    }
}

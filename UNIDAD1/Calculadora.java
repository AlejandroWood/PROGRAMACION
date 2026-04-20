package UNIDAD1;

import javax.swing.JOptionPane;

public class Calculadora {
public static void main(String[] args) {
Object[] opciones = {"Suma", "Resta", "Multiplicación", "División"};
int num1 = 0;
int num2 = 0;
float num1float = 0.00f;
float num2float = 0.00f;
float resultado = 0.00f;
String num1String = "";
String num2String = "";

    num1String = JOptionPane.showInputDialog(
        null, "Introduzca el primer número",
        "Número 1",
        JOptionPane.QUESTION_MESSAGE);

    num1 = Integer.valueOf(num1String);
    num1float = num1;

    num2String = JOptionPane.showInputDialog(
        null, "Introduzca el segundo número",
        "Número 2",
        JOptionPane.QUESTION_MESSAGE);

    num2 = Integer.valueOf(num2String);
    num2float = num2;

    int seleccion = JOptionPane.showOptionDialog(
        null,
        "¿Qué operación desea realizar?",
        "Calculadora",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        opciones,
        opciones[0]
    );

    if (seleccion == 0) {
        resultado = num1float + num2float;
        JOptionPane.showMessageDialog(null, "La suma de los números es: " + resultado);
    }

    if (seleccion == 1) {
        resultado = num1float - num2float;
        JOptionPane.showMessageDialog(null, "La resta de los números es: " + resultado);
    }

    if (seleccion == 2) {
        resultado = num1float * num2float;
        JOptionPane.showMessageDialog(null, "La multiplicación de los números es: " + resultado);
    }

    if (seleccion == 3) {
        resultado = num1float / num2float;
        JOptionPane.showMessageDialog(null, "La división de los números es: " + resultado);
    }
}
} //Prueba
import java.io.Serializable;

public class Calculadora implements Serializable {

    private int num1;
    private int num2;

    private long resultado;

    private int operacion;

    public Calculadora(int num1, int num2, int operacion) {
        this.num1 = num1;
        this.num2 = num2;
        this.operacion = operacion;//1-suma 2-resta 3-multi 4-division
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public long getResultado() {
        return resultado;
    }

    public void setResultado(long resultado) {
        this.resultado = resultado;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }
}

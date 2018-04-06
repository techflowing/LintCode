/**
 * 计算圆的周长和面积
 */
public class E_764_Calculate {
    public double[] calculate(int r) {
        float pi = 3.14f;
        double[] a = new double[2];
        a[0] = 2 * pi * r;
        a[1] = pi * r * r;
        return a;
    }
}

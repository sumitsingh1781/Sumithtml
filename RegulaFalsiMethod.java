public class RegulaFalsiMethod {

    
    static double f(double x) {
        return Math.pow(x, 3) - 4 * x - 9;
    }

    static Double regulaFalsi(double a, double b, double tol, int maxIter) {
        if (f(a) * f(b) >= 0) {
            return null;
        }

        double c = 0;

        for (int i = 0; i < maxIter; i++) {
            c = b - (f(b) * (b - a)) / (f(b) - f(a));

            if (Math.abs(f(c)) < tol) {
                return c;
            }

            if (f(a) * f(c) < 0) {
                b = c;
            } else {
                a = c;
            }
        }
        return c;
    }

    public static void main(String[] args) {

        double a = 2;
        double b = 3;
        double tol = 1e-6;
        int maxIter = 50;

        Double root = regulaFalsi(a, b, tol, maxIter);

        if (root != null) {
            System.out.printf("Approximate Root = %.6f%n", root);
        } else {
            System.out.println("Root not found");
        }
    }
}

class MyFibonacci {
    public static double fastExponentiation(double base, long exponent) {
        double result = 1;

        while(exponent > 0) {
            if((exponent & 1) == 1) {
                result *= base;
            }

            base *= base;
            exponent >>= 1;
        }

        return result;
    }

    public int getFibonacciOfN(int n) {
        double sqrt5 = Math.sqrt(5);
        
        double phi = ((1 + sqrt5) / 2);

        int result = (int)Math.round((fastExponentiation(phi, n) + fastExponentiation(1 - phi, n)) / sqrt5);

        return result;
    }
}

class Fibonacci {
    //Time Complexity = O(log(n)), Space Complexity = O(1)
    public int getFibonacciOfN(int n) {
        double sqrt5 = Math.sqrt(5);
        
        double phi = (1 + sqrt5) / 2;
        double psi = (1 - sqrt5) / 2;

        int res = (int)Math.round((Math.pow(phi, n) + Math.pow(psi, n)) / sqrt5);

        return res;
    }
}

public class BinetFormula {
    public static void main(String[] args) {
        Fibonacci obj1 = new Fibonacci();
        System.out.println(obj1.getFibonacciOfN(5));

        MyFibonacci obj2 = new MyFibonacci();
        System.out.println(obj2.getFibonacciOfN(5));
    }
}

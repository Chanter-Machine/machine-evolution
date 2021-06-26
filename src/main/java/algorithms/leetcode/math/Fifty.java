package algorithms.leetcode.math;

public class Fifty {

    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }else{
            double result = x;
            int pow = 0;
            if(n>0){
                pow = n;
                return calc2(x, pow);
            }else{
                pow = -1*n;
                return 1/calc2(x,pow);
            }
        }
    }

    public double calc(double x, int pow){
        double result = 1.0;

        for(int i=0;i<pow;i++){
            result *= x;
        }

        return result;
    }

    public double calc2(double x, int pow){
        if(pow==0){
            return 1.0;
        }else if(pow ==1){
            return x;
        }
        else{
            int mid = pow/2;
            double temp = calc(x, mid);
            if(pow%2==0){
                return temp*temp;
            }else{
                return temp*temp*x;
            }
        }

    }


// ---------------------------------------
    public static void main(String[] args) {
        Fifty fifty = new Fifty();
        System.out.println(fifty.myPow2(2.0, 10));
    }
    public double myPow2(double x, int n) {
        long b = n;
        return calc2(x, b);
    }
    public double calc2(double x, long n) {
        if (x== 1.0) {
            return 1.0;
        }
        if(x == 0.0) {
            return 0.0;
        }
        if(n == 0) {
            return 1.0;
        }else if(n == 1){
            return x;
        }else if(n>1) {
            double result = 1.0;
            double tempResult = calc2(x, n/2);
            if(n%2 == 0){
                result = tempResult * tempResult;
            }else{
                result = tempResult * tempResult*x;
            }


            return result;
        }else {
            return 1/calc2(x, -1*n);
        }
    }


}

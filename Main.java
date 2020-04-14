public class Main {
    
    public static int grav = 10; 

    public static void main(String[] rtl)
        
        {

            Counter system = new Counter(90,50,10,0.2,0.3,0.4,70);
            double v1 = system.fric1;
            double v2 = system.fric2;
            double v3 = system.fric3;
            double M1= system.M1;
            double M2 = system.M2;
            double M3 = system.M3;
            double F = system.F;
            System.out.println("M1 = " + M1 + ", M2 = " + M2 + ", M3 = " + M3 + ", v1 = " + v1 + ", v2 = " + v2 + ", v3 = " + v3 + ", F = " + F);
            
            for (int i = 1; i<=100; i+=10)
            {
                System.out.println("For t = "+ i);
                points(M1,M2,M3,v1,v2,v3,F,i);
            }
        }
        
    public static void points(double M1, double M2, double M3, double v1, double v2, double v3, double F, double t)
        {
            double acc1;
            double acc2;
            double acc3;
            double T;
            double x1, x2, x3, y3;

            T = ((1+v3)/(M1+M3)*(-v1*grav*(M1+M2)-F)+grav*(1-v2))/(1/(M1+M3)*(1+v1+v3+v1*v3)+1.0/M2+1.0/M3);

            acc1 = (-F-v1*(M1*grav+M2*grav+T)-T)/(M1+M3);
            acc2 = (T+v2*M2*grav)/M2;
            acc3 = (T - M3*grav - v3*M3*acc1) / M3;

            x1 = acc1*t*t/2;
            x2 = acc2*t*t/2;
            x3 = x1;
            
            y3 =  acc3*t*t/2;

            System.out.println("x of M1 :"+x1);
            System.out.println("x of M2 :"+x2);
            System.out.println("x of M3 :"+x3);
            System.out.println("y of M3 :"+y3);
            System.out.println("y of M1 and M2 stay the same");
        }
}

class Counter {

    public static int Mmin = 0; 
    public static int Mmax = 100 ;

    public static double fAtLeast = 0;
    public static double fAtMost = 0.5;


    public static int Fmin = -300; 
    public static int Fmax = 300; 

    public static int grav = 10; 


    public int M1;
    public int M2;
    public int M3;
    public int F;
    public double fric1;
    public double fric2;
    public double fric3;

    public Counter(int M1,int M2,int M3, double fric1,double fric2,double fric3, int F)
    {
        if(M1 <= Mmax && M1> Mmin )
            this.M1 = M1;
        else {
            System.out.println("Input Valid value");
            return;
        }
        if(M2 <= Mmax && M2> Mmin )
            this.M2 = M2;
        else {
            System.out.println("Input Valid value");
            return;
        }
        if(M3 <= Mmax && M3> Mmin )
            this.M3 = M3;
        else {
            System.out.println("Input Valid value");
            return;
        }
        if(fric1 <= fAtMost && fric1 >= fAtLeast )
            this.fric1 = fric1;
        else {
            System.out.println("Input Valid value");
            return;
        }
        if(fric2 <= fAtMost && fric2 >= fAtLeast )
            this.fric2 = fric2;
        else {
            System.out.println("Input Valid value");
            return;
        }
        if(fric3 <= fAtMost && fric3 >= fAtLeast )
            this.fric3 = fric3;
        else {
            System.out.println("Input Valid value");
            return;
        }
        if(F <= Fmax && F >= Fmin )
            this.F = F;
        else {
            System.out.println("Input Valid value");
        }
    }
}

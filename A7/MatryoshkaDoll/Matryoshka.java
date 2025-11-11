import java.awt.Color;

public class Matryoshka {
    public static void drawFace(double a, double b, double r){
        StdDraw.setPenColor(Color.black);
        StdDraw.filledCircle(a-((1.0/5.0)*r),b+((1.0/6.0)*r),r*(1.0/10.0));
        StdDraw.filledCircle(a+((1.0/5.0)*r),b+((1.0/6.0)*r),r*(1.0/10.0));
        StdDraw.line(a-((1.0/8.0)*r),b-((1.0/6.0)*r),a+((1.0/8.0)*r),b-((1.0/6.0)*r));
        StdDraw.arc(a,b-((1.0/6.0)*r),((1.0/8.0)*r),180,360);
    }

    public static void drawDoll(double x, double y, double z){
        StdDraw.setPenColor(Color.black);
        StdDraw.circle(x, y, z);
        double d = z / 2.0;
        double e = y + z + d;
        StdDraw.circle(x, e, d);
        drawFace(x, e, z);
    }

    public static void stackDolls(double a, double b, double c, int d){
        if (d <= 0) return;
        drawDoll(a, b, c);
        double e = c * 5.0 / 7.0;
        double f = a + c + e;
        stackDolls(f, b, e, d - 1);
    }

    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        stackDolls(0.1, 0.1, 0.1, n);
    }
}
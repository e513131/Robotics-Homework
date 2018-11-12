public class Quadrilateral extends Polygon{
    public Quadrilateral(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4){
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.x3=x3;
        this.y3=y3;
        this.x4=x4;
        this.x4=x4;
        this.y4=y4;
    }

    public double area(double x1, double y1, double x2, double y2, double x3, double y3){
        double lace1 = (x1*y2)+(x2*y3)+(x3*y4)+(x4*y1);
        double lace2 = (y1*x2)+(y2*x3)+(y3*x4)+(y4*x1);

        double diff = Math.abs(lace1-lace2);

        return diff/2;
    }

    double x1, y1, x2, y2, x3, y3, x4, y4;
}
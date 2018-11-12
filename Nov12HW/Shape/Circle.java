public class Circle extends Shape2D{
    public Circle(double radius){
        this.radius=radius;
    }

    public double circum(double radius){
        return 2*Math.PI*radius;
    }

    public double area(double radius){
        return Math.PI*radius*radius;
    }

    double radius;
}
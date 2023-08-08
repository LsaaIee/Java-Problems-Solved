class Circle{
    double rad = 0;
    final double PI = 3.14;
    
    public Circle(double r){
        setRad(r);
    }
    public void setRad(double r){
        if (r < 0){
            rad = 0;
            return;
        }
        rad = r;
    }
    public double getArea(){
        return (rad*rad)*PI;
    }
}

class UnsafeCircle{
    public static void main(String args[]){
        Circle c = new Circle(1.5);
        System.out.println(c.getArea());
        
        c.setRad(2.5);
        System.out.println(c.getArea());
        c.setRad(-3.3);
        System.out.println(c.getArea());
        c.rad = -4.5; // r can't be less than 0. method setRad(double r) exists to check if r is a negative number. 
                      // Although instance variable has accessed like this and the data is wrong, compiler can't catch this mistake. 
                      // Therefore, we seperate data private and public. 
        System.out.println(c.getArea());
    }
}

/*=========================================================================================================================================================================*/

class Circle{
    private double rad = 0;
    final double PI = 3.14;
    
    public Circle(double r){
        setRad(r);
    }
    public void setRad(double r){
        if (r < 0){
            rad = 0;
            return;
        }
        rad = r;
    }
    public double getRad(){
        return rad;
    }
    public double getArea(){
        return (rad*rad)*PI;
    }
}

class UnsafeCircle{
    public static void main(String args[]){
        Circle c = new Circle(1.5);
        System.out.println(c.getArea());
        
        c.setRad(2.5);
        System.out.println(c.getArea());
        c.setRad(-3.3);
        System.out.println(c.getArea());
        c.rad = -4.5; // thanks to getRad(), compiler catches the mistake from here
        System.out.println(c.getArea());
    }
}

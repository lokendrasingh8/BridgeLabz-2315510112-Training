class Circle {
    private double radius;

    public Circle() {
        this(1.0); // default radius
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    void display() {
        System.out.println("Circle radius: " + radius);
    }
}

public class Demo {
    public static void main(String[] args) {
        //get shape factory
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);
        //get an object of Shape Rectangle
        Shape rectangleShape = shapeFactory("RECTANGLE");
        //call draw method of Shape Rectangle
        rectangleShape.draw();
    }
}
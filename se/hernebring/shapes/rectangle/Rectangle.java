package se.hernebring.shapes.rectangle;
public class Rectangle{
    private double width,height;

    /**Constructor init values 1 */
    public Rectangle(){
        width=1.0;
        height=1.0;
    }

    /**@param width Double Width of the rectangle
     * @param height Double Height of the rectangle
     */
    public Rectangle(double width, double height){
        this.width=width;
        this.height=height;
    }

    /** @return String with all instance variables*/
    @Override
    public String toString(){
        return "width:\t"+width+"\nheight:\t"+height+"\n";
    }
}
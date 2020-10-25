package se.hernebring.age;
public class Person {
    private String firstName,lastName;
    private int age;

    /**Simple constructor give null, null, 0 */
    public Person(){}

    /** @param firstName Persons first name String
     * @param lastName Persons last name String
     * @param age Persons age int
    */
    public Person(String firstName,String lastName, int age){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }

    @Override
    public String toString(){
        return firstName+" "+lastName+", age: "+age+"\n";
    }
}

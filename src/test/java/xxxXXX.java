class xxxXXX {

    {
        System.out.println("1 " + this);
    }
    String driver = "MyFirstValue";

    public xxxXXX(String driver) {
        this.driver = driver;
        System.out.println("2 " + this);
    }

    public String toString() {
        return "I'm from toString method "+driver;
    }

    public static void main(String... args) {
        System.out.println("3 " + new xxxXXX("MySecondValue"));
    }
}
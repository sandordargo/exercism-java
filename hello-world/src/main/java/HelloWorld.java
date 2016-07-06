
public class HelloWorld {
    static public String hello(String name) {
        if (name == null || name.isEmpty()) {
            return hello();
        }
        return "Hello, " + name + "!";
    }

    static private String hello() {
        return "Hello, World!";
    }
}

class MyResource implements AutoCloseable {

    public MyResource() {
        System.out.println("Resource opened.");
    }

    public void useResource() {
        System.out.println("Using resource...");

        throw new RuntimeException(
                "Something went wrong inside try block."
        );
    }

    @Override
    public void close() {
        System.out.println("Resource closed.");
    }
}

public class ResourceDemo {

    public static void main(String[] args) {

        try (MyResource resource = new MyResource()) {

            resource.useResource();

        } catch (RuntimeException e) {

            System.out.println(
                    "Error: " + e.getMessage()
            );
        }

        System.out.println("Program ended.");
    }
}
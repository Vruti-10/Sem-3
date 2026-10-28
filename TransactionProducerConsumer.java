class TransactionBuffer {

    int[] buffer = new int[3];
    int count = 0;
    int in = 0;
    int out = 0;

    synchronized void produce(int transaction) throws InterruptedException {

        while (count == buffer.length) {
            wait();
        }

        buffer[in] = transaction;
        in = (in + 1) % buffer.length;
        count++;

        System.out.println("Transaction added: " + transaction);

        notify();
    }

    synchronized int consume() throws InterruptedException {

        while (count == 0) {
            wait();
        }

        int transaction = buffer[out];
        out = (out + 1) % buffer.length;
        count--;

        System.out.println("Transaction processed: " + transaction);

        notify();

        return transaction;
    }
}

public class TransactionProducerConsumer {

    public static void main(String[] args) {

        TransactionBuffer buffer = new TransactionBuffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i * 100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
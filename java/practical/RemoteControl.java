interface Switchable {

    void on();

    void off();

   
    default void toggle() {
        on();
    }
}


class Fan implements Switchable {

    public void on() {
        System.out.println("Fan is ON");
    }

    public void off() {
        System.out.println("Fan is OFF");
    }
}


class Light implements Switchable {

    public void on() {
        System.out.println("Light is ON");
    }

    public void off() {
        System.out.println("Light is OFF");
    }
}


@FunctionalInterface
interface SwitchRule {
    boolean maySwitchOn(Switchable device, int hour);
}

public class RemoteControl {

    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        System.out.println("---- Toggling Devices ----");

        for (Switchable device : devices) {
            device.toggle();
        }

       
        SwitchRule rule1 = new SwitchRule() {

            public boolean maySwitchOn(Switchable device, int hour) {

                
                return hour >= 6 && hour <= 22;
            }
        };

       
        SwitchRule rule2 = (device, hour) -> hour >= 6 && hour <= 22;

        int hour = 10;

        System.out.println("\n---- Switch Rule ----");

        System.out.println("Anonymous class: "
                + rule1.maySwitchOn(devices[0], hour));

        System.out.println("Lambda: "
                + rule2.maySwitchOn(devices[1], hour));
    }
}
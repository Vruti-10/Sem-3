public class ParkingLot {

    private int twoWheelers;
    private int fourWheelers;

    private final int twoCap;
    private final int fourCap;

    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
    }

    public boolean park(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                return true;
            }

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                return true;
            }
        }

        System.out.println("Full");
        return false;
    }

    public void leave(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers > 0)
                twoWheelers--;

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers > 0)
                fourWheelers--;
        }
    }

    public static long getRevenue() {
        return revenue;
    }

    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(2, 2);

        System.out.println("Park two: " + lot.park("two"));
        System.out.println("Park two: " + lot.park("two"));

        System.out.println("Park two: " + lot.park("two"));

        System.out.println("Park four: " + lot.park("four"));
        System.out.println("Park four: " + lot.park("four"));

        System.out.println("Park four: " + lot.park("four"));

        lot.leave("two");

        System.out.println("Park two: " + lot.park("two"));

        System.out.println("Two wheelers: " + lot.twoWheelers);
        System.out.println("Four wheelers: " + lot.fourWheelers);
        System.out.println("Revenue: " + ParkingLot.getRevenue());
    }
}




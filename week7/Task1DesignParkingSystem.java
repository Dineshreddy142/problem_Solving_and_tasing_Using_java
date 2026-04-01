import java.util.Scanner;

public class Task1DesignParkingSystem {
    static class ParkingSystem {
        private final int[] slots = new int[4];

        public ParkingSystem(int big, int medium, int small) {
            slots[1] = big;
            slots[2] = medium;
            slots[3] = small;
        }

        public boolean addCar(int carType) {
            if (slots[carType] == 0) {
                return false;
            }
            slots[carType]--;
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) {
            return;
        }

        int big = scanner.nextInt();
        int medium = scanner.nextInt();
        int small = scanner.nextInt();
        int q = scanner.nextInt();

        ParkingSystem system = new ParkingSystem(big, medium, small);
        for (int i = 0; i < q; i++) {
            int carType = scanner.nextInt();
            System.out.println(system.addCar(carType));
        }
    }
}

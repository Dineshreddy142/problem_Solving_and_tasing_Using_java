public class Task2JavaMethodOverridingSuper {
    static class BiCycle {
        String defineMe() {
            return "a vehicle with pedals.";
        }
    }

    static class MotorCycle extends BiCycle {
        @Override
        String defineMe() {
            return "a cycle with an engine.";
        }

        MotorCycle() {
            System.out.println("Hello I am a motorcycle, I am " + defineMe());
            String temp = super.defineMe();
            System.out.println("My ancestor is a cycle who is " + temp);
        }
    }

    public static void main(String[] args) {
        new MotorCycle();
    }
}

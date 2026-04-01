import java.util.Scanner;

public class Task8JavaFactoryPattern {
    interface Food {
        String getType();
    }

    static class Pizza implements Food {
        @Override
        public String getType() {
            return "Someone ordered a Fast Food!";
        }
    }

    static class Cake implements Food {
        @Override
        public String getType() {
            return "Someone ordered a Dessert!";
        }
    }

    static class FoodFactory {
        public Food getFood(String order) {
            if (order.equalsIgnoreCase("pizza")) {
                return new Pizza();
            }
            if (order.equalsIgnoreCase("cake")) {
                return new Cake();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = sc.next();

        FoodFactory foodFactory = new FoodFactory();
        Food food = foodFactory.getFood(order);

        if (food != null) {
            System.out.println("The factory returned class " + food.getClass().getSimpleName());
            System.out.println(food.getType());
        }
    }
}

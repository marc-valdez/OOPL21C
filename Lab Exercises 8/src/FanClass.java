public class FanClass {
    private static final byte SLOW = 1;
    private static final byte MEDIUM = 2;
    private static final byte FAST = 3;
    private final double radius;
    private final String color;
    private final int speed;
    private boolean on;

    public FanClass() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5.0;
        this.color = "blue";
    }

    public static void main(String[] args) {
        FanClass fan = new FanClass();
        fan.DisplayInfo();

        System.out.println();

        fan.on = true;
        fan.DisplayInfo();
    }

    public void DisplayInfo() {
        if (on) {
            System.out.println("Fan Speed: " + speed + "\nColor: " + color + "\nRadius: " + radius);
        } else {
            System.out.println("Color: " + color + "\nRadius: " + radius + "\nfan is off");
        }
    }
}

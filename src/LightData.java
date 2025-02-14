public class LightData {
    private int x, y;
    private int width, height;
    private boolean on_off;

    // Constructor
    public LightData(int x, int y, int width, int height, boolean on_off) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.on_off = on_off;
    }

    // Setter
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setOn_off(boolean on_off) {
        this.on_off = on_off;
    }

    // Getter
    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean getOn_off() {
        return this.on_off;
    }
}
public class LightData {
    private int x, y;
    private int width, height;
    private boolean isActive;

    // Constructor
    public LightData(int x, int y, int width, int height, boolean isActive) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isActive = isActive;
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

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
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

    public boolean getIsActive() {
        return this.isActive;
    }
}

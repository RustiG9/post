package model;

public class Setting {
    private int startX = 40; /// вынести в настройки
    private int startY = 80; /// вынести в настройки
    private int startToX = 500; /// вынести в настройки
    private int startToY = 500; /// вынести в настройки

    public int getStartX() {


        return startX;
    }

    public void setStartX(int startX) {
        this.startX = startX;
    }

    public int getStartY() {
        return startY;
    }

    public void setStartY(int startY) {
        this.startY = startY;
    }

    public int getStartToX() {
        return startToX;
    }

    public void setStartToX(int startToX) {
        this.startToX = startToX;
    }

    public int getStartToY() {
        return startToY;
    }

    public void setStartToY(int startToY) {
        this.startToY = startToY;
    }
}

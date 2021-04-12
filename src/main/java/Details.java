public enum Details {
    HEAD(0),
    BODY(0),
    LEFT_ARM(0),
    RIGHT_ARM(0),
    LEFT_LEG(0),
    RIGHT_LEG(0),
    CPU(0),
    RAM(0),
    HDD(0);

    private int count;
    public static final int SIZE = Details.values().length;
    public static final Details[] VALUE = values();


    Details(int count) {
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void incrimination() {
        this.count++;
    }

    public static Details getRandomDetail() {
        return VALUE[(int) (Math.random() * SIZE)];
    }

}

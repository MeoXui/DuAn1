package poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass;

public class GridItem {
    private String gridName;
    private String gridDes;
    private int gridIcon;

    public String getGridName() {
        return gridName;
    }

    public String getGridDes() {
        return gridDes;
    }

    public int getGridIcon() {
        return gridIcon;
    }

    public GridItem(String gridName, String gridDes, int gridIcon) {
        this.gridName = gridName;
        this.gridDes = gridDes;
        this.gridIcon = gridIcon;
    }
}

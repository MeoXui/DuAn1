package poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass;

public class NganhHang {
    private int idNganhHang;
    private String tenNganhHang;
    private int trangThai;

    public int getIdNganhHang() {
        return idNganhHang;
    }

    public String getTenNganhHang() {
        return tenNganhHang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public NganhHang(int idNganhHang, String tenNganhHang, int trangThai) {
        this.idNganhHang = idNganhHang;
        this.tenNganhHang = tenNganhHang;
        this.trangThai = trangThai;
    }
}

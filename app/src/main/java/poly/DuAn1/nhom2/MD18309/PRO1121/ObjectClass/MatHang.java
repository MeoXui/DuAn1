package poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass;

public class MatHang {
    private String idMatHang;
    private String idNhaCungCap;
    private String idNganhHang;
    private String donViTinh;
    private int giaMatHang;
    private int soLuongMatHang;

    public String getIdMatHang() {
        return idMatHang;
    }

    public String getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public String getIdNganhHang() {
        return idNganhHang;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public int getGiaMatHang() {
        return giaMatHang;
    }

    public int getSoLuongMatHang() {
        return soLuongMatHang;
    }

    public MatHang(String idMatHang, String idNhaCungCap, String idNganhHang, String donViTinh, int giaMatHang, int soLuongMatHang) {
        this.idMatHang = idMatHang;
        this.idNhaCungCap = idNhaCungCap;
        this.idNganhHang = idNganhHang;
        this.donViTinh = donViTinh;
        this.giaMatHang = giaMatHang;
        this.soLuongMatHang = soLuongMatHang;
    }
}

package poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass;

public class MatHang {
    private int idMatHang;
    private int idNhaCungCap;
    private int idNganhHang;
    private String tenMatHang;
    private String donViTinh;
    private int giaNhapMatHang;
    private int giaMatHang;
    private float soLuongMatHang;
    private int trangThai;

    public int getIdMatHang() {
        return idMatHang;
    }
    public int getIdNhaCungCap() {
        return idNhaCungCap;
    }

    public int getIdNganhHang() {
        return idNganhHang;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public int getGiaMatHang() {
        return giaMatHang;
    }

    public float getSoLuongMatHang() {
        return soLuongMatHang;
    }

    public int getGiaNhapMatHang() {
        return giaNhapMatHang;
    }

    public String getTenMatHang() {
        return tenMatHang;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public MatHang(int idMatHang, int idNhaCungCap, int idNganhHang, String tenMatHang, float soLuongMatHang, String donViTinh, int giaNhapMatHang, int giaMatHang, int trangThai) {
        this.idMatHang = idMatHang;
        this.idNhaCungCap = idNhaCungCap;
        this.idNganhHang = idNganhHang;
        this.tenMatHang = tenMatHang;
        this.donViTinh = donViTinh;
        this.giaNhapMatHang = giaNhapMatHang;
        this.giaMatHang = giaMatHang;
        this.soLuongMatHang = soLuongMatHang;
        this.trangThai = trangThai;
    }
}

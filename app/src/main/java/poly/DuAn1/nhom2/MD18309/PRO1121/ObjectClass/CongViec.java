package poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass;

public class CongViec {
    private int idCV;
    private String idQuanLy;
    private String idNhanVien;
    private String tieuDe;
    private String moTa;
    private String thoiHan;
    private int trangThai;

    public int getIdCV() {
        return idCV;
    }

    public String getIdQuanLy() {
        return idQuanLy;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public String getMoTa() {
        return moTa;
    }

    public String getThoiHan() {
        return thoiHan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public CongViec(int idCV, String idQuanLy, String idNhanVien, String tieuDe, String moTa, String thoiHan, int trangThai) {
        this.idCV = idCV;
        this.idQuanLy = idQuanLy;
        this.idNhanVien = idNhanVien;
        this.tieuDe = tieuDe;
        this.moTa = moTa;
        this.thoiHan = thoiHan;
        this.trangThai = trangThai;
    }
}

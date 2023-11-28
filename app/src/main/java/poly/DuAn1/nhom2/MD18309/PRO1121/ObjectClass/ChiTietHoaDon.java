package poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass;

public class ChiTietHoaDon {
    private int idCTHD;
    private int idHD;
    private int idMH;
    private int soLuong;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(int idCTHD, int idHD, int idMH, int soLuong) {
        this.idCTHD = idCTHD;
        this.idHD = idHD;
        this.idMH = idMH;
        this.soLuong = soLuong;
    }

    public int getIdCTHD() {
        return idCTHD;
    }

    public void setIdCTHD(int idCTHD) {
        this.idCTHD = idCTHD;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public int getIdMH() {
        return idMH;
    }

    public void setIdMH(int idMH) {
        this.idMH = idMH;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}

package poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass;

public class KhachHang {
    private String idKH;
    private String HoTenKH;
    private String phoneKH;
    private String addressKH;

    public String getIdKH() {
        return idKH;
    }

    public String getHoTenKH() {
        return HoTenKH;
    }

    public String getPhoneKH() {
        return phoneKH;
    }

    public String getAddressKH() {
        return addressKH;
    }

    public KhachHang(String idKH, String hoTenKH, String phoneKH, String addressKH) {
        this.idKH = idKH;
        HoTenKH = hoTenKH;
        this.phoneKH = phoneKH;
        this.addressKH = addressKH;
    }
}

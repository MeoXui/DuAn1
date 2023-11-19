package poly.DuAn1.nhom2.MD18309.PRO1121.ObjectClass;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    private String userName;
    private String passWord;
    private String role;
    private String hoTen;
    private String phone;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TaiKhoan(String userName, String passWord, String role, String hoTen, String phone, String email) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
        this.hoTen = hoTen;
        this.phone = phone;
        this.email = email;
    }

    public TaiKhoan(String role, String hoTen, String phone, String email) {
        this.role = role;
        this.hoTen = hoTen;
        this.phone = phone;
        this.email = email;
    }
}

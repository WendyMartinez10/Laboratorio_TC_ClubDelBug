/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Social_Worker;

/**
 *
 * @author gipsy
 */
public class Social_Worker {
    private String idCedula;
    private String name;
    private String email;
    private String phone;
    private String district;

    public String getIdCedula() {
        return idCedula;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDistrict() {
        return district;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Social_Worker(String idCedula, String name, String email, String phone, String district) {
        this.idCedula = idCedula;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.district = district;
    }
    
}

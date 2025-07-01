/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
   
package Victims;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author USER
 */

public class Victim {
  private String id;
    private String idHash;
    private String name;
    private String hash_name;
    private LocalDate birthdate;
    private String gender;
    private String email;
    private String phone;
    private String address;

    public Victim(String name, LocalDate birthdate, String gender, String email, String phone, String address) {
        this.name = name;
        this.hash_name = generateHash(name);
        this.id = generateId(name);
        this.idHash = generateHash(this.id);
        this.birthdate = birthdate;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    private String generateId(String name) {
        String base = name.toLowerCase().replaceAll("\\s+", "");
        String timestamp = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return base + "_" + timestamp;
    }

    private String generateHash(String input) {
        MessageDigest md = MessageDigestHolder.instance;
        if (md == null || input == null) return "";

        byte[] hashBytes = md.digest(input.getBytes());
        StringBuilder hex = new StringBuilder();
        for (byte b : hashBytes) {
            hex.append(String.format("%02x", b));
        }

        String hash = hex.toString();
        return hash.matches("^[a-f0-9]{64}$") ? hash : "";
    }

    private static class MessageDigestHolder {
        private static final MessageDigest instance;
        static {
            MessageDigest temp = null;
            try {
                temp = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException ignored) {}
            instance = temp;
        }
    }

    public String getIdHash() {
        return idHash;
    }

    public String getNameHash() {
        return hash_name;
    }

    public String getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public int calculateAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    private String getEmail() { 
        return email; 
    }
    
    private String getPhone() {
        return phone;
    }
    
    private String getAddress() {
        return address; 
    }

    @Override
    public String toString() {
        return "Victim: " + "id=" + id + ", idHash=" + idHash + ", name=" + name + ", hash_name=" + hash_name + ", birthdate=" + birthdate + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", address=" + address;
    }
    
}

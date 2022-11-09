package laborator.trei.unitatidecazare;

import androidx.room.Entity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import android.os.Bundle;

import java.io.Serializable;

// this is the table in the database
@Entity(tableName = "HOTELS_TABLE", indices = {@Index(value = {"hotel_name"}, unique = true)})
public class HotelTable implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    @ColumnInfo(name = "hotel_name")
    String hotel_name;

    @ColumnInfo(name = "hotel_phone")
    String hotel_phone;

    @ColumnInfo(name = "hotel_website")
    String hotel_website;

    @ColumnInfo(name = "hotel_address")
    String hotel_address;

    // Getters and Setters


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_phone() {
        return hotel_phone;
    }

    public void setHotel_phone(String hotel_phone) {
        this.hotel_phone = hotel_phone;
    }

    public String getHotel_website() {
        return hotel_website;
    }

    public void setHotel_website(String hotel_website) {
        this.hotel_website = hotel_website;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }
}

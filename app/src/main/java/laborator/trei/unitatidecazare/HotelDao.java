package laborator.trei.unitatidecazare;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HotelDao {

    // Insert query
    @Insert(onConflict = REPLACE)
    void insert(HotelTable mainData);

    //Delete query
    @Delete
    void delete(HotelTable mainData);

    // Delete all query
    @Delete
    void reset(List<HotelTable> mainData);

    //Update query
    @Query("UPDATE HOTELS_TABLE SET hotel_name = :sText WHERE ID = :sID")
    void update(int sID, String sText);

    // Get all
    @Query("SELECT * FROM HOTELS_TABLE")
    List<HotelTable> getAll();

    //Get phone number based on name
    @Query("SELECT hotel_phone FROM HOTELS_TABLE WHERE hotel_name = :sName")
    String getPhone(String sName);

    //Get website based on name
    @Query("SELECT hotel_website FROM HOTELS_TABLE WHERE hotel_name = :sName")
    String getWebsite(String sName);

    //Get address
    @Query("SELECT hotel_address FROM HOTELS_TABLE WHERE hotel_name = :sName")
    String getAddress(String sName);
}

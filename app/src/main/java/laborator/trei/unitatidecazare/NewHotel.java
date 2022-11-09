package laborator.trei.unitatidecazare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// View for when you add a new hotel
public class NewHotel extends AppCompatActivity {

    EditText hotel_name,hotel_phone, hotel_website, hotel_address;
    Button bt_save_new_hotel, bt_cancel_new_hotel;
    HotelsDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hotel);

        hotel_name = findViewById(R.id.hotel_name);
        hotel_phone = findViewById(R.id.hotel_phone);
        hotel_website = findViewById(R.id.hotel_website);
        hotel_address = findViewById(R.id.hotel_address);
        bt_save_new_hotel = findViewById(R.id.bt_save_new_hotel);
        bt_cancel_new_hotel = findViewById(R.id.bt_cancel_new_hotel);


        database = HotelsDatabase.getDatabase();

        bt_save_new_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hotel_name_string = hotel_name.getText().toString().trim();
                String hotel_phone_string = hotel_phone.getText().toString().trim();
                String hotel_website_string = hotel_website.getText().toString().trim();
                String hotel_address_string = hotel_address.getText().toString().trim();
                if((!hotel_name_string.equals("")) && 
                        (!hotel_phone_string.equals("")) &&
                        (!hotel_website_string.equals("")) &&
                        (!hotel_address_string.equals(""))){
                    HotelTable entry = new HotelTable();
                    entry.setHotel_name(hotel_name_string);
                    entry.setHotel_phone(hotel_phone_string);
                    entry.setHotel_website(hotel_website_string);

                    //create string for address location
                    String correct_address = "geo:" + hotel_address_string + "?z=14" ;
                    entry.setHotel_address(correct_address);

                    database.hotelDao().insert(entry);
                    hotel_name.setText("");
                    hotel_phone.setText("");
                    hotel_website.setText("");
                    hotel_address.setText("");
                }
            }
        });

        bt_cancel_new_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hotel_name.setText("");
                hotel_phone.setText("");
                hotel_website.setText("");
                hotel_address.setText("");
            }
        });
    }
}
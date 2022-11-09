package laborator.trei.unitatidecazare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


// View for all the hotels
public class ListHotels extends AppCompatActivity {

    ListView list_view;
    FloatingActionButton bt_add_new_hotel;
    List<HotelTable> hotel_list_all = new ArrayList<>();

    static HotelsDatabase database;
    HotelsBaseAdapter hotelsBaseAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_all_hotels);

        list_view = findViewById(R.id.list_view);
        bt_add_new_hotel = findViewById(R.id.bt_add_new_hotel);

        database = HotelsDatabase.getInstance(this);
        hotel_list_all = database.hotelDao().getAll();

        hotelsBaseAdapter = new HotelsBaseAdapter(getApplicationContext(),hotel_list_all,database);
        list_view.setAdapter(hotelsBaseAdapter);
    }



    public void goToNewHotel(View view){

            Intent intent = new Intent(this, NewHotel.class);
            startActivity(intent);
        }

}
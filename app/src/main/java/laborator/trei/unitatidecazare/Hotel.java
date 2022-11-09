package laborator.trei.unitatidecazare;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// this is the item from list view
public class Hotel extends AppCompatActivity {

    TextView hotel_name_view;
    Button bt_access_maps, bt_access_website;
    Button bt_call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        hotel_name_view = findViewById(R.id.hotel_name_view);
        bt_access_maps = findViewById(R.id.bt_access_maps);
        bt_call = findViewById(R.id.bt_call);
        bt_access_website = findViewById(R.id.bt_access_website);

    }

}
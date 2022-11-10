package laborator.trei.unitatidecazare;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// here is the adapter for the ListView
public class HotelsBaseAdapter extends BaseAdapter {

    Context context;
    List<HotelTable> hotel_table_entries = new ArrayList<>();
    LayoutInflater layoutInflater;

    Button bt_call, bt_access_maps, bt_access_website;
    TextView hotel_name_view;
    HotelsDatabase database;


    public HotelsBaseAdapter(Context context, List<HotelTable> hotel_entries, HotelsDatabase database)
    {
        this.context = context;
        this.hotel_table_entries = hotel_entries;
        this.layoutInflater = LayoutInflater.from(context);
        this.database = database;
    }

    @Override
    public int getCount() {
        return hotel_table_entries.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = layoutInflater.inflate(R.layout.activity_hotel, null);
        bt_call = (Button) view.findViewById(R.id.bt_call);
        bt_access_maps = (Button) view.findViewById(R.id.bt_access_maps);
        bt_access_website = (Button) view.findViewById(R.id.bt_access_website);
        hotel_name_view = (TextView) view.findViewById(R.id.hotel_name_view);

        hotel_name_view.setText(hotel_table_entries.get(i).getHotel_name());

        bt_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri number = Uri.parse(database.hotelDao().getPhone(hotel_table_entries.get(i).getHotel_name()));
                Intent callIntent = new Intent(Intent.ACTION_CALL, number);
                System.out.println("Trying to call to... " + hotel_table_entries.get(i).getHotel_name() + " "
                + "with phone number... " + database.hotelDao().getPhone(hotel_table_entries.get(i).getHotel_name()));
                try{
                    context.startActivity(callIntent);
                } catch (ActivityNotFoundException e){
                    System.out.println("Enter Exception in Call service...");
                }

            }
        });

        bt_access_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri location = Uri.parse(database.hotelDao().getAddress(hotel_name_view.getText().toString()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
                try{
                    context.startActivity(mapIntent);
                } catch (ActivityNotFoundException e){}
            }
        });

        bt_access_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri webpage = Uri.parse(database.hotelDao().getWebsite(hotel_name_view.getText().toString()));
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                try{
                    context.startActivity(webIntent);
                } catch (ActivityNotFoundException e){}
            }
        });

        return view;
    }
}

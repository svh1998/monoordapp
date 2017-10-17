package com.example.svanh.testproject.Reserveringen;

        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.util.Log;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ListAdapter;
        import android.widget.ListView;
        import android.widget.SimpleAdapter;
        import android.widget.Toast;

        import com.example.svanh.testproject.R;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class Mijn_Reserveringen extends AppCompatActivity implements LoadJSONTask.Listener, AdapterView.OnItemClickListener {

    private ListView mListView;


    private List<HashMap<String, String>> mAndroidMapList = new ArrayList<>();

    private static final String KEY_id = "id";
    private static final String KEY_room_id = "room_id";
    private static final String KEY_reservation_time_start = "reservation_time_start";
    private static final String KEY_reservation_time_end = "reservation_time_end";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mijn__reserveringen);

        mListView = (ListView) findViewById(R.id.list_view);
        mListView.setOnItemClickListener(this);
        Log.d("stage", "oncreate");
        new LoadJSONTask(this).execute();
    }

    @Override
    public void onLoaded(List<AndroidVersion> androidList) {
        Log.d("stage", "onload android");
        for (AndroidVersion server_response : androidList) {
            Log.d("stage", "for loop");
            HashMap<String, String> map = new HashMap<>();

            map.put(KEY_id, server_response.get_id());
            map.put(KEY_room_id, server_response.getRoom_id());
            map.put(KEY_reservation_time_start, server_response.getReservation_time_start());
            map.put(KEY_reservation_time_end, server_response.getReservation_time_end());
            Log.d("var", server_response.getReservation_time_end());
            Log.d("stage", "add map list");


            mAndroidMapList.add(map);
        }

        loadListView();
    }

    @Override
    public void onError() {
        Toast.makeText(this, "Error !", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, mAndroidMapList.get(i).get(KEY_id), Toast.LENGTH_LONG).show();
    }

    private void loadListView() {

        ListAdapter adapter = new SimpleAdapter(Mijn_Reserveringen.this, mAndroidMapList, R.layout.list_item,
                new String[] { KEY_room_id, KEY_reservation_time_start, KEY_reservation_time_end },
                new int[] { R.id.room_id,R.id.reservation_time_start, R.id.reservation_time_end});

        mListView.setAdapter(adapter);

    }
}

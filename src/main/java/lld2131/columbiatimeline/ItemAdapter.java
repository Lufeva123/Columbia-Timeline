package lld2131.columbiatimeline;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ItemAdapter extends ArrayAdapter<Item> {


    public ItemAdapter(Context context, List<Item> items ) {

        super(context, 0,  items);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;

        if (listView == null) {

            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        Item item = (Item) getItem(position);

        TextView title = (TextView) listView.findViewById(R.id.title);
        title.setText(item.getTitle());

        TextView date = (TextView) listView.findViewById(R.id.date);
        date.setText(item.getDate());

        return listView;
    }
}


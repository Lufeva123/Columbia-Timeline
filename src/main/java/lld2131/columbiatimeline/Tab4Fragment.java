package lld2131.columbiatimeline;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Tab4Fragment extends Fragment {

    private ItemAdapter adapter;

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.feed, container, false);


        listView = (ListView) rootView.findViewById(R.id.list_view);

        adapter = new ItemAdapter(getActivity(), addItems());


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Item itemClicked = (Item) parent.getItemAtPosition(position);

                if(itemClicked.getUrl() != "") {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(itemClicked.getUrl()));

                    startActivity(intent);
                }

            }
        });



        listView.setAdapter(adapter);

        return rootView;
    }

    private ArrayList<Item> addItems() {

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("The Black Student's Organization is formed", "1976", ""));
        items.add(new Item("Columbia College admits women", "1983", "https://www.college.columbia.edu/cct/archive/jul_aug09/features1"));
        items.add(new Item("Alfred Lerner Hall opens", "1999", "http://www.wikicu.com/Alfred_Lerner_Hall"));
        items.add(new Item("Lee C. Bollinger becomes president", "2002", "https://president.columbia.edu/content/about-president"));

        return items;

    }
}

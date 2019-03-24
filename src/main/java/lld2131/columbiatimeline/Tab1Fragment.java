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

public class Tab1Fragment extends Fragment {

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
        items.add(new Item("King's College founded by King George II","1754", "http://www.wikicu.com/University_Charter"));
        items.add(new Item("King's College moves to Park Place","1760", "http://www.wikicu.com/College_Hall"));
        items.add(new Item("King's College begins awarding the MD degree","1767", "https://250.ps.columbia.edu/featured-stories/ps-early-years-1767-1928"));
        items.add(new Item("Revolutionary War and end of instruction","1776", "https://www.warmemorial.columbia.edu/wars/-revolutionary-war"));

        return items;

    }
}

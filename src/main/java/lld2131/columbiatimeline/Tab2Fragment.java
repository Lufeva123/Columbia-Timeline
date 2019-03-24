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

public class Tab2Fragment extends Fragment {

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
        items.add(new Item("King's College reopens as Columbia College", "1784", "https://www.college.columbia.edu/about/history"));
        items.add(new Item("Columbia College graduates its first class", "1786", "https://babel.hathitrust.org/cgi/pt?id=uc1.b4525470;view=1up;seq=1011"));
        items.add(new Item("James Kent offers a course on American Law", "1794", ""));
        items.add(new Item("First student-run literary society established", "1802", "http://www.columbia.edu/cu/philo/History/"));
        items.add(new Item("The Riotous Commencement takes place", "1811", "http://spectatorarchive.library.columbia.edu/cgi-bin/columbia?a=d&d=cs19241118-01.2.7"));
        items.add(new Item("State of New York donates Elgin Botanical Garden", "1814", "https://www.nybg.org/blogs/science-talk/2014/07/rockefeller-center-botanical-history-underfoot/"));
        items.add(new Item("Nonclassical curriculum in response to NYU opening", "1830", ""));
        items.add(new Item("Development on Elgin Botanical Garden begins", "1855", "https://www.nybg.org/blogs/science-talk/2014/07/rockefeller-center-botanical-history-underfoot/"));
        items.add(new Item("Columbia moves to Midtown campus", "1857", "http://www.wikicu.com/Midtown_campus"));

        return items;

    }
}

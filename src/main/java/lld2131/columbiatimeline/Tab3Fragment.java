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

public class Tab3Fragment extends Fragment {

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
        items.add(new Item("Columbia Law School is founded", "1858", "https://www.law.columbia.edu/"));
        items.add(new Item("Columbia School of Mines is founded", "1864", "https://engineering.columbia.edu/about/history"));
        items.add(new Item("Columbia Spectator is founded", "1877", "http://www.wikicu.com/Columbia_Daily_Spectator"));
        items.add(new Item("The precursor to the GSAS", "1880", "https://gsas.columbia.edu/our-intellectual-community/brief-history-gsas"));
        items.add(new Item("The School of Architecture is founded", "1881", ""));
        items.add(new Item("Barnard College opens for classes", "1889", "https://barnard.edu/about-barnard/history"));
        items.add(new Item("Acquisition of plot in Morningside Heights", "1892", "http://www.wikicu.com/History_of_the_Morningside_Heights_campus"));
        items.add(new Item("Architectural plans for new campus displayed at World Fair", "1893", "http://www.wikicu.com/History_of_the_Morningside_Heights_campus"));
        items.add(new Item("Columbia moves to Morningside Heights", "1897", "http://www.wikicu.com/History_of_the_Morningside_Heights_campus"));
        items.add(new Item("Affiliation arrangements with Barnard", "1900", "https://barnard.edu/about-barnard/history"));
        items.add(new Item("Alma Matter statue takes her seat in front of Low Library", "1903", ""));
        items.add(new Item("NYC subway system engineered by Columbia trustee", "1904", "http://c250.columbia.edu/c250_celebrates/remarkable_columbians/william_barclay_parsons.html"));
        items.add(new Item("School of Journalism founded", "1912", "https://journalism.columbia.edu/columbia-journalism-school"));
        items.add(new Item("Contemporary Civilization course offered, marking beginning of Core", "1919", "https://www.college.columbia.edu/core/content/contemporary-civilization"));
        items.add(new Item("Baker Field Stadium is completed", "1923", "http://www.wikicu.com/Baker_Athletic_Complex"));
        items.add(new Item("Columbia leases the site for Rockefeller Center", "1929", ""));
        items.add(new Item("Construction of the future Butler Library", "1933", "https://library.columbia.edu/locations/butler/about.html"));
        items.add(new Item("The University Seminars are founded", "1945", "http://universityseminars.columbia.edu/about-us/history/"));
        items.add(new Item("The School of International Affairs is founded", "1946", "https://sipa.columbia.edu/experience-sipa/about-sipa/mission-history"));
        items.add(new Item("Government approval for gym in Morningside Park", "1960", "https://untappedcities.com/2013/10/08/nyc-that-never-was-gym-morningside-park-sparks-1968-columbia-university-protests-shutdown/"));
        items.add(new Item("Columbia actively recruit black applicants", "1964", "https://untappedcities.com/2013/10/08/nyc-that-never-was-gym-morningside-park-sparks-1968-columbia-university-protests-shutdown/"));
        items.add(new Item("1968 Protests", "1968", "http://www.wikicu.com/1968_protests"));

        return items;

    }

}

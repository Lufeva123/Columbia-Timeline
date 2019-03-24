package lld2131.columbiatimeline;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setUpViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setBackgroundColor(getResources().getColor(R.color.tabLayoutColor));
        tabLayout.setTabTextColors(getResources().getColor(R.color.tabLayoutTitleColorUnselected), getResources().getColor(R.color.tabLayoutTitleColorSelected));


    }

    private void setUpViewPager(ViewPager viewPager) {

        ItemFragmentPagerAdapter itemFragmentPagerAdapter = new ItemFragmentPagerAdapter(getSupportFragmentManager());
        itemFragmentPagerAdapter.addFragment(new Tab1Fragment(), "King's College");
        itemFragmentPagerAdapter.addFragment(new Tab2Fragment(), "Columbia College");
        itemFragmentPagerAdapter.addFragment(new Tab3Fragment(), "Early Columbia University");
        itemFragmentPagerAdapter.addFragment(new Tab4Fragment(), "Current Columbia University");

        viewPager.setAdapter(itemFragmentPagerAdapter);
    }
}

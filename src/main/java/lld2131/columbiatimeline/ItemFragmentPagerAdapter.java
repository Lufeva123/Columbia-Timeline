package lld2131.columbiatimeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemFragmentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> tabTitles = new ArrayList<>();

    public ItemFragmentPagerAdapter(FragmentManager fm) {
        super(fm);

    }

    public void addFragment(Fragment fragment, String title) {

        fragments.add(fragment);
        tabTitles.add(title);

    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);

    }

    @Override
    public int getCount() {

        return fragments.size();

    }


    @Override
    public CharSequence getPageTitle(int position) {

        return tabTitles.get(position);

    }
}

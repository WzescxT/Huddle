package com.wzes.huddle.homepage;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.OnMenuItemClickListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.wzes.huddle.R;
import com.wzes.huddle.adapter.TeamAdapter;
import com.wzes.huddle.team.TeamHotFragment;
import com.wzes.huddle.team.TeamNearFragment;
import com.wzes.huddle.team.TeamNewFragment;
import com.wzes.huddle.team.TeamRecFragment;

public class TeamFragment extends Fragment {
    private TeamAdapter teamAdapter;
    private TeamHotFragment teamHotFragment;
    private TeamNearFragment teamNearFragment;
    private TeamNewFragment teamNewFragment;
    private TeamRecFragment teamRecFragment;
    private Toolbar toolbar;

    private static TeamFragment teamFragment;
    private TeamFragment(){
        teamFragment = new TeamFragment();
    }

    public static TeamFragment newInstance() {
        if(teamFragment == null){
            teamFragment = new TeamFragment();
        }
        return teamFragment;
    }

    class C09091 implements OnMenuItemClickListener {
        C09091() {
        }

        public boolean onMenuItemClick(MenuItem item) {
            if (!(item.getItemId() == R.id.team_add_study || item.getItemId() == R.id.team_add_plan || item.getItemId() == R.id.team_add_life || item.getItemId() != R.id.team_add_journey)) {
            }
            return true;
        }
    }


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.team_add, menu);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        ViewPager pager = (ViewPager) view.findViewById(R.id.team_pager);
        this.teamHotFragment = new TeamHotFragment();
        this.teamNewFragment = new TeamNewFragment();
        this.teamRecFragment = new TeamRecFragment();
        this.teamNearFragment = new TeamNearFragment();
        this.teamAdapter = new TeamAdapter(getChildFragmentManager(), getContext(), this.teamNewFragment, this.teamRecFragment, this.teamHotFragment, this.teamNearFragment);
        pager.setAdapter(this.teamAdapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.team_tabs);
        tabLayout.setupWithViewPager(pager);
        tabLayout.getTabAt(0).select();
        this.toolbar = (Toolbar) view.findViewById(R.id.team_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(this.toolbar);
        this.toolbar.setOnMenuItemClickListener(new C09091());
        setHasOptionsMenu(true);
        return view;
    }
}

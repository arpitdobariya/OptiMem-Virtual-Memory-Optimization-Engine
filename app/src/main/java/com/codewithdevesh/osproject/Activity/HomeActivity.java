package com.codewithdevesh.osproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.codewithdevesh.osproject.Fragments.AlgorithmFragment;
import com.codewithdevesh.osproject.Fragments.ProfileFragment;
import com.codewithdevesh.osproject.Fragments.TheoryFragment;
import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.ActivityHomeBinding;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class HomeActivity extends AppCompatActivity {
    private ActivityHomeBinding binding;
    private FragmentManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_home);


        binding.navBar.setItemSelected(R.id.m_algorithm,true);
        manager = getSupportFragmentManager();
        AlgorithmFragment fragment = new AlgorithmFragment();
        manager.beginTransaction().replace(R.id.parent_container,fragment).commit();

        binding.navBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            final AlgorithmFragment algorithmFragment = new AlgorithmFragment();
            final TheoryFragment theoryFragment = new TheoryFragment();
            final ProfileFragment profileFragment = new ProfileFragment();
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.m_algorithm:
                        getSupportFragmentManager().beginTransaction().replace(R.id.parent_container,algorithmFragment).commit();
                        break;
                    case R.id.m_theory:
                        getSupportFragmentManager().beginTransaction().replace(R.id.parent_container,theoryFragment).commit();
                        break;
                    case R.id.m_aboutUs:
                        getSupportFragmentManager().beginTransaction().replace(R.id.parent_container,profileFragment).commit();
                        break;
                }
            }
        });
    }
}
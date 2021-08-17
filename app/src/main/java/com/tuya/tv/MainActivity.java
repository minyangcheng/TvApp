package com.tuya.tv;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.tuya.tv.my.MyGridFragment;
import com.tuya.tv.my.MyMainFragment;

/*
 * Main Activity class that loads {@link MainFragment}.
 */
public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_browse_fragment, new MyGridFragment())
                    .commitNow();
        }
    }
}
package com.ravit.android.aroundtheclock;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class WorkdayActivity extends AppCompatActivity {

    private static final String TAG = "WorkdayActivity";
    private static final String KEY_CURRENT_DATE = "current_date";

    private Calendar mCurrentDate;
    private SimpleDateFormat mFormatter;

    private Calendar getCurrentDate(int year, int month, int day) {
        Calendar currentDate;
        currentDate = Calendar.getInstance();
        currentDate.set(Calendar.YEAR, year);
        currentDate.set(Calendar.MONTH, month);
        currentDate.set(Calendar.DAY_OF_MONTH, day);

        return currentDate;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workday);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
        mCurrentDate = getCurrentDate(2005, 10, 1);
        mFormatter = new SimpleDateFormat("dd.MM.yyyy");

        if (fragment == null) {
            fragment = WorkdayFragment.newInstance(mFormatter.format(mCurrentDate.getTime()));
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, fragment)
                    .commit();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workday, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        mCurrentDate = getCurrentDate(2015, 10, 1);
        mFormatter = new SimpleDateFormat("dd.MM.yyyy");
        savedInstanceState.putString(KEY_CURRENT_DATE, mFormatter.format(mCurrentDate.getTime()));

    }
}

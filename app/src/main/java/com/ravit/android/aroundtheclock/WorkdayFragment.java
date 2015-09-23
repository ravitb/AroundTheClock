package com.ravit.android.aroundtheclock;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkdayFragment extends Fragment {

    private static final String KEY_CURRENT_DATE = "current_date";

    private Workday mWorkday;
    private TextView mTitleField;
    private Calendar mCalendar;
    private SimpleDateFormat mFormatter = new SimpleDateFormat("dd.MM.yyyy");

    private String mCurrentDate;

    public WorkdayFragment() {
        // Required empty public constructor
    }

    public static WorkdayFragment newInstance(String currentDate) {
        WorkdayFragment fragmentWorkday = new WorkdayFragment();
        Bundle args = new Bundle();
        args.putString(KEY_CURRENT_DATE, currentDate);
        fragmentWorkday.setArguments(args);
        return fragmentWorkday;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String calendar = getArguments().getString(KEY_CURRENT_DATE, "");

        mCalendar = Calendar.getInstance();

        try {
            mFormatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            mCalendar.setTime(mFormatter.parse(calendar));
        } catch (ParseException e) {
            //handle exception

//            mCalendar.set(Calendar.YEAR, 2013);
//            mCalendar.set(Calendar.MONTH, 6);
//            mCalendar.set(Calendar.DAY_OF_MONTH, 17);
        }

        mWorkday = new Workday(mCalendar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_workday, container, false);

        mTitleField = (TextView)v.findViewById(R.id.workday_title);

        mFormatter = new SimpleDateFormat("dd.MM.yyyy");

        mTitleField.setText(mFormatter.format(mCalendar.getTime()));
        return v;
    }
}

package com.ravit.android.aroundtheclock;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class WorkdayFragment extends Fragment {

    public enum EntryType {
        START,
        END
    }

    private static final String KEY_CURRENT_DATE = "current_date";
	private static final String DIALOG_TIME = "timePicker";
	private static final String DIALOG_DATE = "date";


	private Workday mWorkday;
    private TextView mTitleField;
    private Calendar mCalendar;
    private SimpleDateFormat mFormatter;

    private Button mButtonStart;
    private Button mButtonEnd;

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

        mFormatter = new SimpleDateFormat("dd.MM.yyyy");
        String calendar = getArguments().getString(KEY_CURRENT_DATE, "");
        mCalendar = Calendar.getInstance();

        try {
            mFormatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            mCalendar.setTime(mFormatter.parse(calendar));
        } catch (ParseException e) {
            e.printStackTrace();
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
        mTitleField.setText(mFormatter.format(mCalendar.getTime()));

        mButtonStart = (Button)v.findViewById(R.id.start_workday);
        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
				TimePickerFragment dialog = new TimePickerFragment();
				dialog.show(getActivity().getFragmentManager(), DIALOG_TIME);
            }
        });

        mButtonEnd = (Button)v.findViewById(R.id.end_workday);
        mButtonEnd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				TimePickerFragment dialog = new TimePickerFragment();
				dialog.show(getActivity().getFragmentManager(), DIALOG_TIME);
			}
		});

        return v;
    }
}

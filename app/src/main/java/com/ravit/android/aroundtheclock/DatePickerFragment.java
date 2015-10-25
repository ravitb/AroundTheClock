package com.ravit.android.aroundtheclock;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;

/**
 * A simple {@link Fragment} subclass.
 */
public class DatePickerFragment extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedStateInstance) {
		return new AlertDialog.Builder(getActivity())
				.setTitle(R.string.workday_title)
				.setPositiveButton(android.R.string.ok, null)
				.create();
	}

}
package com.iskrembilen.quasseldroid.gui.fragments;

import com.iskrembilen.quasseldroid.gui.LoginActivity;
import com.iskrembilen.quasseldroid.gui.fragments.ConnectingDialog.Callbacks;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ConnectingDialog extends DialogFragment {
	public interface Callbacks {
		public void onCanceled();

	}
	private Callbacks callbacks;

	public  static ConnectingDialog newInstance() {
		return new ConnectingDialog();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if (!(activity instanceof Callbacks)) {
			throw new ClassCastException("Activity must implement fragment's callbacks.");
		}

		callbacks = (Callbacks) activity;
	}
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		ProgressDialog prog = new ProgressDialog(getActivity());
		prog.setMessage("Connecting...");
		setCancelable(true);
		return prog;
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		super.onCancel(dialog);
		callbacks.onCanceled();
	}
}

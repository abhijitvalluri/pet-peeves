package com.abhijitvalluri.android.petpeeves;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * CrimeImageFragment displays the crime image in all its gory detail
 */
public class CrimeImageFragment extends DialogFragment {

    private static final String ARG_PHOTO_FILE = "photoFile";

    private ImageView mEnlargedPhotoView;

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        File photoFile = (File) getArguments().getSerializable(ARG_PHOTO_FILE);

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.crime_image_view, null);

        mEnlargedPhotoView = (ImageView) view.findViewById(R.id.crime_photo_enlarged);
        if (photoFile != null) {
            Bitmap bitmap = Utils.getInstance(getActivity()).getScaledBitmap(
                    photoFile.getPath(), getActivity());
            mEnlargedPhotoView.setImageBitmap(bitmap);
        }

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.crime_photo_enlarged_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .create();
    }

    public static CrimeImageFragment newInstance(File photoFile) {
        // photoFile must be non-null.
        if (photoFile == null) {
            return null;
        }

        Bundle args = new Bundle();
        args.putSerializable(ARG_PHOTO_FILE, photoFile);

        CrimeImageFragment fragment = new CrimeImageFragment();
        fragment.setArguments(args);
        return fragment;
    }
}

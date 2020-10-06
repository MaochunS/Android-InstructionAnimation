package com.maochun.instructionanimation;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;


public class EnableDevSettingModeInstructionDialog {

    private AlertDialog mAlertDialog = null;
    private EnableDevSettingInstruDlgCallback mCallback = null;

    public void show(Context context, EnableDevSettingInstruDlgCallback callback) {

        mCallback = callback;
        mAlertDialog = new AlertDialog.Builder(context).create();
        View loadView = LayoutInflater.from(context).inflate(R.layout.dialog_enable_dev_setting_mode, null);

        Button skipBtn = loadView.findViewById(R.id.button_skip);
        skipBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mCallback!=null)
                   mCallback.onSkipButtonClicked();

                dismiss();
            }
        });

        ImageView imageViewForAni = loadView.findViewById(R.id.imageView_instructions);
        imageViewForAni.setBackgroundResource(R.anim.enable_dev_setting);

        AnimationDrawable frameAnimation = (AnimationDrawable) imageViewForAni.getBackground();
        frameAnimation.start();

        mAlertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //mAlertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(ContextCompat.getColor(context, R.color.colorUpdateFWProgressBk)));
        mAlertDialog.setView(loadView, 0, 0, 0, 0);
        mAlertDialog.setCanceledOnTouchOutside(true);

        try {
            mAlertDialog.show();
        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public void dismiss(){
        if (mAlertDialog != null) {
            mAlertDialog.dismiss();
        }
    }
}

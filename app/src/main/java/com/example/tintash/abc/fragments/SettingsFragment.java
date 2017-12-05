package com.example.tintash.abc.fragments;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tintash.abc.R;
import com.example.tintash.abc.data.entities.Setting;
import com.example.tintash.abc.data.fetchers.SettingFetcher;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Tintash on 12/2/2017.
 */

public class SettingsFragment extends BaseFragment {

    @BindView(R.id.fajrEdit) TextView fajrEditButton;
    @BindView(R.id.zuharEdit) TextView zuharEditButton;
    @BindView(R.id.asarEdit) TextView asarEditButton;
    @BindView(R.id.maghribEdit) TextView maghribEditButton;
    @BindView(R.id.ishaEdit) TextView ishaEditButton;
    @BindView(R.id.jumahEdit) TextView jummahEditButton;

    @BindView(R.id.fajr_time) TextView fajrTime;
    @BindView(R.id.zuhar_time) TextView zuharTime;
    @BindView(R.id.asar_time) TextView asarTime;
    @BindView(R.id.maghrib_time) TextView maghribTime;
    @BindView(R.id.isha_time) TextView ishaTime;

    @BindView(R.id.edit_textview_cusstom_msg) TextView textViewEditCustomMsg;
    @BindView(R.id.edit_textView_namaz_msg) TextView textViewEditNamazMsg;
    @BindView(R.id.edit_textView_namaz_time_msg) TextView textViewEditNamazTime;
    @BindView(R.id.edit_textview_viberate_time) TextView textViewViberateTime;

    @BindView(R.id.edit_namaz_msg) EditText editTextNamazMsg;
    @BindView(R.id.edit_custom_msg) EditText editTextCustomMsg;
    @BindView(R.id.edit_viberate_time) EditText editTextTime;

    @BindView(R.id.btn_save_custom_msg) Button saveCustomMsgBtn;
    @BindView(R.id.btn_save_namaz_msg) Button saveNamazMsgBtn;
    @BindView(R.id.btn_save_viberate_time_msg) Button saveTimeBtn;

    @BindView(R.id.checkbox_enable_custom_msg) CheckBox checkBoxCustom;
    @BindView(R.id.checkbox_enable_namaz_msg) CheckBox checkBoxNamaz;

    @BindView(R.id.namaz_time_layout) LinearLayout namazLayout;

    private Setting setting = new Setting();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.settings_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        prepareview(view);

        SettingFetcher settingFetcher = new SettingFetcher(this,getActivity());

//        LiveData<List<Setting>> settingLiveData = settingFetcher.getSettings();
//
//        settingLiveData.observe(this, new Observer<List<Setting>>() {
//            @Override
//            public void onChanged(@Nullable List<Setting> settings) {
//                if(!settings.isEmpty())
//                    setting=settings.get(0);
//            }
//        });
    }

    private void prepareview(View view){

        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "fontawesome-webfont.ttf" );
        fajrEditButton.setTypeface(font);
        zuharEditButton.setTypeface(font);
        asarEditButton.setTypeface(font);
        maghribEditButton.setTypeface(font);
        ishaEditButton.setTypeface(font);
        jummahEditButton.setTypeface(font);

        textViewEditCustomMsg.setTypeface(font);
        textViewEditNamazMsg.setTypeface(font);
        textViewEditNamazTime.setTypeface(font);
        textViewViberateTime.setTypeface(font);
    }

    @OnClick(R.id.edit_textView_namaz_msg)
    public void enableDisableNamazMsgSection(){

        if(saveNamazMsgBtn.getVisibility()==View.VISIBLE){
            editTextNamazMsg.setEnabled(false);
            checkBoxNamaz.setEnabled(false);
            saveNamazMsgBtn.setVisibility(View.GONE);
        }else {
            editTextNamazMsg.setEnabled(true);
            checkBoxNamaz.setEnabled(true);
            saveNamazMsgBtn.setVisibility(View.VISIBLE);
        }

    }

    @OnClick(R.id.edit_textview_cusstom_msg)
    public void enableDisableCustomMsgSection(){

        if(saveCustomMsgBtn.getVisibility()==View.VISIBLE){
            editTextCustomMsg.setEnabled(false);
            checkBoxCustom.setEnabled(false);
            saveCustomMsgBtn.setVisibility(View.GONE);
        }else {
            editTextCustomMsg.setEnabled(true);
            checkBoxCustom.setEnabled(true);
            saveCustomMsgBtn.setVisibility(View.VISIBLE);
        }

    }

    @OnClick(R.id.edit_textView_namaz_time_msg)
    public void enableDisableNamazTimeLayout(){

        if(namazLayout.getVisibility()==View.VISIBLE)
            namazLayout.setVisibility(View.GONE);
        else
            namazLayout.setVisibility(View.VISIBLE);
    }

    @OnClick(R.id.edit_textview_viberate_time)
    public void enableDisableViberateTimeSection(){

        if(saveTimeBtn.getVisibility()==View.VISIBLE){
            saveTimeBtn.setVisibility(View.GONE);
            editTextTime.setEnabled(false);
        }else {
            saveTimeBtn.setVisibility(View.VISIBLE);
            editTextTime.setEnabled(true);
        }
    }
}

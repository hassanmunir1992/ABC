package com.example.tintash.abc.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Tintash on 12/5/2017.
 */

@Entity(tableName = "setting")
public class Setting extends EntityModel {

    @Ignore
    public static final String TABLE_NAME = "setting";

    @Ignore
    public static final String COLUMN_ID = "_id";

    @Ignore
    public static final String COLUMN_NAMAZ_MESSAGE = "namaz_message";

    @Ignore
    public static final String COLUMN_NAMAZ_MSG_ENABLE_DISABLE = "namaz_msg_enable_disable";

    @Ignore
    public static final String COLUMN_CUSTOM_MESSAGE = "custom_message";

    @Ignore
    public static final String COLUMN_CUSTOM_MSG_ENABLE_DISABLE = "custom_msg_enable_disable";

    @Ignore
    public static final String COLUMN_VIBERATE_TIME = "viberate_time";

    @ColumnInfo(name = COLUMN_ID)
    @PrimaryKey()
    private int _id;

    @ColumnInfo(name = COLUMN_NAMAZ_MESSAGE)
    private String namaz_msg;

    @ColumnInfo(name = COLUMN_NAMAZ_MSG_ENABLE_DISABLE)
    private int namaz_msg_enable_disable;

    @ColumnInfo(name = COLUMN_CUSTOM_MESSAGE)
    private String custom_msg;

    @ColumnInfo(name = COLUMN_CUSTOM_MSG_ENABLE_DISABLE)
    private int custom_msg_enble_disable;

    @ColumnInfo(name = COLUMN_VIBERATE_TIME)
    private int viberate_time;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getNamaz_msg() {
        return namaz_msg;
    }

    public void setNamaz_msg(String namaz_msg) { // 1 enable 0 disable.
        this.namaz_msg = namaz_msg;
    }

    public int getNamaz_msg_enable_disable() { // 1 enable 0 disable.
        return namaz_msg_enable_disable;
    }

    public void setNamaz_msg_enable_disable(int namaz_msg_enable_disable) { // 1 enable 0 disable.
        this.namaz_msg_enable_disable = namaz_msg_enable_disable;
    }

    public String getCustom_msg() { // 1 enable 0 disable.
        return custom_msg;
    }

    public void setCustom_msg(String custom_msg) {
        this.custom_msg = custom_msg;
    }

    public int getCustom_msg_enble_disable() {
        return custom_msg_enble_disable;
    }

    public void setCustom_msg_enble_disable(int custom_msg_enble_disable) {
        this.custom_msg_enble_disable = custom_msg_enble_disable;
    }

    public int getViberate_time() {
        return viberate_time;
    }

    public void setViberate_time(int viberate_time) {
        this.viberate_time = viberate_time;
    }


}

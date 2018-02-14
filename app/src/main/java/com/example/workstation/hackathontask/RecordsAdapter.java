package com.example.workstation.hackathontask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.workstation.hackathontask.model.Record;

import java.util.List;

/**
 * Created by workstation on 11.02.2018.
 */
public class RecordsAdapter extends BaseAdapter {

    private Context mContext;
    private List<Record> recordList;

    public RecordsAdapter(Context mContext, List<Record> recordList) {

        this.mContext = mContext;
        this.recordList = recordList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.custom_records_row,viewGroup);




        return null;



    }
}

package com.e.contactmanager;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {

    Activity myActivity;
    ArrayList<BaseContact> myContacts;


    public PersonAdapter(Activity myActivity, ArrayList<BaseContact> myContacts) {
        this.myActivity = myActivity;
        this.myContacts = myContacts;
    }

    @Override
    public int getCount() {
        return myContacts.size();
    }

    @Override
    public BaseContact getItem(int position) {
        return myContacts.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View onePersonLine;

        LayoutInflater inflater = (LayoutInflater) myActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        onePersonLine = inflater.inflate(R.layout.single_contact_list, viewGroup, false);

        TextView scl_tv_NameView = onePersonLine.findViewById(R.id.scl_tv_NameView);
        TextView scl_tv_PhoneView = onePersonLine.findViewById(R.id.scl_tv_PhoneView);
        TextView scl_tv_EmailView = onePersonLine.findViewById(R.id.scl_tv_EmailView);
        TextView scl_tv_AddressView = onePersonLine.findViewById(R.id.scl_tv_AddressView);
        ImageView scl_iv_ContactImage = onePersonLine.findViewById(R.id.scl_iv__ContactImage);

        BaseContact p = this.getItem(i);

        scl_tv_NameView.setText("Jeff");
        scl_tv_PhoneView.setText("888-888-8888");
        scl_tv_EmailView.setText("example@yahoo.com");
        scl_tv_AddressView.setText("1234 indigo way San Diago, Ca 93127-0320 and then some thing extra for you");

        int resource_icon_numbers[] = {
                R.drawable.default_user_icon,
        };

        scl_iv_ContactImage.setImageResource(resource_icon_numbers[0]);

        return onePersonLine;
    }
}

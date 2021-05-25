package com.example.practicerecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactVH> {
    Context context;
    ArrayList<Contact> contactArrayList;
    OnItemClickListener onItemClickListener;

    public ContactAdapter(Context context, ArrayList<Contact> contactArrayList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.contactArrayList = contactArrayList;
        this.onItemClickListener = onItemClickListener;
    }

    interface OnItemClickListener {
        void setOnUserCallClick(Contact contact);
    }

    @NonNull
    @Override
    public ContactVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_item, parent, false);

        ContactVH contactVH = new ContactVH(view);
        return contactVH;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactVH holder, int position) {

        Contact contact = contactArrayList.get(position);
        holder.txtName.setText(contact.name);
        holder.txtPhone.setText(contact.phone);
        switch (contact.avatar)
        {
            case 0: holder.imgAvatar.setImageResource(R.drawable.icon_female1); break;
            case 1: holder.imgAvatar.setImageResource(R.drawable.icon_female2); break;
            case 2: holder.imgAvatar.setImageResource(R.drawable.icon_male1); break;
            case 3: holder.imgAvatar.setImageResource(R.drawable.icon_male2); break;
        }

        holder.txtName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contact.name, Toast.LENGTH_SHORT).show();
            }
        });

        holder.txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contact.phone, Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contact.phone, Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, contact.name, Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Call or Message", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public static class ContactVH extends RecyclerView.ViewHolder {

        TextView txtName, txtPhone;
        ImageView imgAvatar, imgCall, imgMessage;

        public ContactVH(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            imgCall = itemView.findViewById(R.id.imgCall);
            imgMessage = itemView.findViewById(R.id.imgMessage);
        }
    }
}

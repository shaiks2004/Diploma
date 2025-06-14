package com.gromagz.education.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.gromagz.education.Models.internship_model;
import com.gromagz.education.R;

import java.util.List;
public class InternshipAdapter extends RecyclerView.Adapter<InternshipAdapter.ViewHolder> {



    private Context context;
    private List<internship_model> internshipList;

    // Constructor
    public InternshipAdapter(Context context, List<internship_model> internshipList) {
        this.context = context;
        this.internshipList = internshipList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.internship_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        internship_model model = internshipList.get(position);

        holder.companyName.setText(model.getCompany());
        holder.internshipTitle.setText(model.getTitle());
        holder.amount.setText(model.getAmount());
        holder.lastDate.setText(model.getLastDate());
        holder.eligibility.setText(model.getEligibility());

        // Optional: Handle Apply Now button click
        holder.applyNow.setOnClickListener(v -> {
            // TODO: Handle apply action
        });
    }

    @Override
    public int getItemCount() {
        return internshipList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView companyName, internshipTitle, amount, lastDate, eligibility;
        Button applyNow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            companyName = itemView.findViewById(R.id.companyName);
            internshipTitle = itemView.findViewById(R.id.internshipTitle);
            amount = itemView.findViewById(R.id.amount);
            lastDate = itemView.findViewById(R.id.lastDate);
            eligibility = itemView.findViewById(R.id.eligibility);
            applyNow = itemView.findViewById(R.id.applyNow);
        }
    }
}

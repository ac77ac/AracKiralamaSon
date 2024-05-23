package com.example.arackiralama;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder>{
    private List<CarModel.Car> mData;
    private static OnItemClickListener mListener;
    public void clear() {
        mData.clear();
    }

    public CarAdapter(List<CarModel.Car> data){
        mData=data;
    }
    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.car_single_item,parent,false);
        return new ViewHolder(view);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull CarAdapter.ViewHolder holder, int position) {
        CarModel.Car car=mData.get(position);
        holder.brandTextView.setText(car.getBrand());
        holder.modelTextView.setText(car.getModel());
        holder.yearTextView.setText(car.getYear());
        holder.colorTextView.setText(car.getColor());
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setCars(List<CarModel.Car> cars) {
        mData=cars;
        notifyDataSetChanged();
    }

    public List<CarModel.Car> getCars() {
        return mData;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView brandTextView;
        TextView modelTextView;
        TextView yearTextView;
        TextView colorTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            brandTextView = itemView.findViewById(R.id.text_brand);
            modelTextView = itemView.findViewById(R.id.text_model);
            yearTextView = itemView.findViewById(R.id.text_year);
            colorTextView = itemView.findViewById(R.id.text_color);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}


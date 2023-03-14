package com.example.atm;
//目前沒用了

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//連接要顯示的data和recycleView的溝通橋樑
public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    private final String[] functions;
    private View inflater;
    TextView viewItems;//items顯示位置


    public RecycleViewAdapter(Context context){
        this.context=context;
        functions=context.getResources().getStringArray(R.array.functions);
    }


//想成是一個儲存View的地方
    public class MyViewHolder extends RecyclerView.ViewHolder{//    ViewHolder為RecycleView的內部類別

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //在itemView中找尋id
            viewItems= itemView.findViewById(android.R.id.text1);//系統內建

        }
    }









    //因為RecycleViewAdapter繼承的Adapter是抽象累，所以要實作他底下的三個方法
    @NonNull
    @Override
    //建立ViewHolder實體，顯示資料之前會去呼叫他
    //MyViewHolder 在上面已經定義他繼承 RecyclerView.ViewHolder
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //simple_list_item_1.xml為內建的layout
        inflater= LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(inflater) ;

        return myViewHolder;
    }

    @Override
    //設定每一個格子裡要顯示的資料
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        holder.viewItems.setText(functions[position]);//holder是啥？？？？可以不用誒
        viewItems.setText(functions[position]);
    }

    @Override
    public int getItemCount() {
        return functions.length;
    }//如果沒有extent的話，他就是一個平凡的class，而不是Adapter

}

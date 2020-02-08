package com.example.myadapater2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.language.MainActivity;
import com.example.language.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myview>
{
    Context context;
    ArrayList<Model> al=new ArrayList<>();
    String c = "https://www.tutorialspoint.com/cprogramming/index.htm";
    String cplus = "https://www.tutorialspoint.com/cplusplus/index.htm";
    String java = "https://www.tutorialspoint.com/java/index.htm";
    String html = "https://www.tutorialspoint.com/html/index.htm";
    String css = "https://www.tutorialspoint.com/css/index.htm";
    String javascript = "https://www.tutorialspoint.com/javascript/index.htm";
    String python = "https://www.tutorialspoint.com/python/index.htm";
    String R_language = "https://www.tutorialspoint.com/r/index.htm";
    String swift = "https://www.tutorialspoint.com/swift/index.htm";
    String php = "https://www.tutorialspoint.com/php/index.htm";
    String ccs = "https://www.tutorialsteacher.com/csharp/csharp-tutorials";
    String Rubby = "https://www.tutorialspoint.com/ruby/index.htm";
    public MyAdapter(Context context, ArrayList<Model> al)
    {
        this.context=context;
        this.al=al;
    }
    @NonNull
    @Override
    public Myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v= LayoutInflater.from(context).inflate(R.layout.recycler_design,parent,false);
        return new Myview(v,context,c,cplus,java,html,css,javascript,python,R_language,swift,php,ccs,Rubby);
    }
    @Override
    public void onBindViewHolder(@NonNull Myview holder, int position)
    {
        Model m=al.get(position);
        holder.textView.setText(m.getText());
        Picasso.with(context)
                .load(m.image)
                .into(holder.imageView);
    }
    @Override
    public int getItemCount()
    {
        return al.size();
    }
    class Myview extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imageView;
        TextView textView;
        Context context;
        String c,cplus,java,html,css,javascript,python,R_language,swift,php,ccs,Rubby;

        public Myview(@NonNull View itemView,Context context,
                      String c,String cplus,String java,
        String html,String css,String javascript,
        String python,String R_language,String swift,
        String php,String ccs,String Rubby)
        {
            super(itemView);

            imageView=itemView.findViewById(R.id.i1);
            textView=itemView.findViewById(R.id.t1);
            itemView.setOnClickListener(this);
            this.context=context;
            this.c=c;
            this.cplus=cplus;
            this.java=java;
            this.html=html;
            this.css=css;
            this.javascript=javascript;
            this.python=python;
            this.R_language=R_language;
            this.swift=swift;
            this.php=php;
            this.ccs=ccs;
            this.Rubby=Rubby;
        }

        @Override
        public void onClick(View v) {

            switch (getAdapterPosition()){

                case 0:
                    Intent intent = new Intent(context,secoundactivity.class);
                    intent.putExtra("c",c);
                    context.startActivity(intent);
                    break;
                case 1:
                    Intent intent1 = new Intent(context,secoundactivity.class);
                    intent1.putExtra("cplus",cplus);
                    context.startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(context,secoundactivity.class);
                    intent2.putExtra("java",java);
                    context.startActivity(intent2);
                    break;
                case 3:
                    Intent intent3 = new Intent(context,secoundactivity.class);
                    intent3.putExtra("html",html);
                    context.startActivity(intent3);
                    break;
                case 4:
                    Intent intent4 = new Intent(context,secoundactivity.class);
                    intent4.putExtra("css",css);
                    context.startActivity(intent4);
                    break;
                case 5:
                    Intent intent5 = new Intent(context,secoundactivity.class);
                    intent5.putExtra("javascript",javascript);
                    context.startActivity(intent5);
                    break;
                case 6:
                    Intent intent6 = new Intent(context,secoundactivity.class);
                    intent6.putExtra("python",python);
                    context.startActivity(intent6);
                    break;
                case 7:
                    Intent intent7 = new Intent(context,secoundactivity.class);
                    intent7.putExtra("R_language",R_language);
                    context.startActivity(intent7);
                    break;
                case 8:
                    Intent intent8 = new Intent(context,secoundactivity.class);
                    intent8.putExtra("swift",swift);
                    context.startActivity(intent8);
                    break;
                case 9:
                    Intent intent9 = new Intent(context,secoundactivity.class);
                    intent9.putExtra("php",php);
                    context.startActivity(intent9);
                    break;
                case 10:
                    Intent intent10 = new Intent(context,secoundactivity.class);
                    intent10.putExtra("ccs",ccs);
                    context.startActivity(intent10);
                    break;
                case 11:
                    Intent intent11 = new Intent(context,secoundactivity.class);
                    intent11.putExtra("Rubby",Rubby);
                    context.startActivity(intent11);
                    break;
            }
        }
    }
}
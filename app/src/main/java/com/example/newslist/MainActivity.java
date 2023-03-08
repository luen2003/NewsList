package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView list;

    String[] maintitle ={
            "Github","VnExpress",
            "Vietnamnet","Bao moi",
            "Bao Tuoi tre",
    };

    String[] subtitle ={
            "My github page","VnExpress Page",
            "Vietnamnet Page","Bao moi Page",
            "Bao tuoi tre Page",
    };
    String[] urls = {
            "https://raw.githack.com/luen2003/CSSWebsite/master/index.htm?fbclid=IwAR3RtWe10UQY4t4v8Zhuicph_M8dfLTlgZUVGXiRYx2DRev7yZzew7Hpfxo",
            "https://vnexpress.net/",
            "https://vietnamnet.vn/",
            "https://baomoi.com/",
            "https://tuoitre.vn/",
    };

    Integer[] imgid={
            R.drawable.news,R.drawable.news,
            R.drawable.news,R.drawable.news,
            R.drawable.news,
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyListAdapter adapter=new MyListAdapter(this, maintitle, subtitle,imgid,urls);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                // TODO Auto-generated method stub
                    //Toast.makeText(getApplicationContext(),"Place Your First Option Code",Toast.LENGTH_SHORT).show();
                    Intent openLinksIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urls[position]));
                startActivity(openLinksIntent);
            }
        });
    }
}
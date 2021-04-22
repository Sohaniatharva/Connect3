package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import androidx.gridlayout.widget.GridLayout;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.channels.DatagramChannel;

public class MainActivity extends AppCompatActivity {
    int tag[]={0,0,0,0,0,0,0,0,0};
    int game[]={0,-1,0,0,-1,0,-1,0,-1};
    boolean start=true;
    int active_player=1,name=1,chance=0;
    public void playAgain(View view) {
        TextView textview = (TextView) findViewById(R.id.textView1);
        textview.setVisibility(View.INVISIBLE);
        tag = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        game = new int[]{0, -1, 0, 0, -1, 0, -1, 0, -1};
        start=true;active_player=1;name=1;chance=0;
        GridLayout gridLayout=(GridLayout)findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++) {
            ImageView child = (ImageView)gridLayout.getChildAt(i);
            child.setImageDrawable(null);
        }

        Button button=(Button)findViewById(R.id.button);
        button.setVisibility(View.INVISIBLE);

    }
    public void fade(View view)
    {
        if(tag[Integer.parseInt(view.getTag().toString())-1]==0 && start)
        {
                if(active_player==1) {
                    ImageView imageView = (ImageView) view;
                    imageView.setTranslationY(-1000);
                    imageView.animate().translationYBy(1000).rotation(3600).setDuration(200);
                    imageView.setImageResource(R.drawable.red);
                    tag[Integer.parseInt(view.getTag().toString()) - 1] = 1;
                    active_player=2;name=1;
                    game[Integer.parseInt(view.getTag().toString()) - 1] = 1;
                }
                else
                {
                    ImageView imageView = (ImageView) view;
                    imageView.setTranslationY(-1000);
                    imageView.animate().translationYBy(1000).rotation(3600).setDuration(200);
                    imageView.setImageResource(R.drawable.yellow);
                    tag[Integer.parseInt(view.getTag().toString()) - 1] = 1;
                    active_player=1;name=2;
                    game[Integer.parseInt(view.getTag().toString()) - 1] = 2;
                }
        }
        else;
        chance++;
        if(        (game[0]==game[1] && game[0]==game[2])
                || (game[3]==game[4] && game[3]==game[5])
                || (game[6]==game[7] && game[6]==game[8])
                || (game[0]==game[3] && game[0]==game[6])
                || (game[1]==game[4] && game[1]==game[7])
                || (game[2]==game[5] && game[2]==game[8])
                || (game[0]==game[4] && game[0]==game[8])
                || (game[2]==game[4] && game[2]==game[6]))
        {
            Button button=(Button)findViewById(R.id.button);
            button.setTranslationY(-1000);
            button.animate().translationY(30).setDuration(200);
            button.setVisibility(View.VISIBLE);
            TextView textview=(TextView)findViewById(R.id.textView1);
            textview.setText("Player "+ name + " won...!!!");
            textview.setVisibility(View.VISIBLE);
            start=false;

        }
        else if(chance==9)
        {
            Button button=(Button)findViewById(R.id.button);
            button.setTranslationY(-1000);
            button.animate().translationY(30).setDuration(200);
            button.setVisibility(View.VISIBLE);
            TextView textview=(TextView)findViewById(R.id.textView1);
            textview.setText("DRAW...!!!");
            textview.setVisibility(View.VISIBLE);
            start=false;
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

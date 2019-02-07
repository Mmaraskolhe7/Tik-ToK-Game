package com.manoj.tiktok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count=0;
    int l=0;
    int[] vacant={2,2,2,2,2,2,2,2,2};
    int[][] winningpo={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    String win;
    boolean gameOver ;

    boolean flag=true; ;

public void appear(View view){
    ImageView counter = (ImageView) view;
    TextView message = (TextView) findViewById(R.id.messageId);
    int tapno= Integer.parseInt(counter.getTag().toString());
    if(vacant[tapno]==2&&flag){
        vacant[tapno]=count;
    if(count==0)
    {counter.setImageResource(R.drawable.red);
    count=1;}
    else
    {counter.setImageResource(R.drawable.yellow);
    count=0 ;}

    counter.animate().alpha(0f);
    counter.animate().alphaBy(1f).rotation(360f).setDuration(200);
    for(int i=0;i<8;i++){
      if(vacant[winningpo[i][0]]==vacant[winningpo[i][1]]&&vacant[winningpo[i][1]]==vacant[winningpo[i][2]]&&vacant[winningpo[i][1]]!=2) {
          if(vacant[winningpo[i][1]]==0) win="Red";
          else win = "Yellow";

          message.setText("Congrats "+win+" has won!");
          LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
          layout.setVisibility(View.VISIBLE);
          flag =false;

      }
      else{gameOver =true;
      for(int j=0;j<9;j++){
          if(vacant[j]==2) gameOver=false;

          }

      }
      if(gameOver){
          message.setText("Game Drawn!");
          LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
          layout.setVisibility(View.VISIBLE);
          flag =false;
      }
    }

    }



}
public void playAgain(View view){ flag =true;
  LinearLayout layout = (LinearLayout) findViewById(R.id.layout2);
  layout.setVisibility(View.INVISIBLE);
 count=0;
   for(int i=0;i<9;i++)
   {vacant[i]=2;}
    System.out.println("Manoj maraskolhe");
  GridLayout gridLayout=(GridLayout)  findViewById(R.id.mainLayout);

   for(int i=0;i<gridLayout.getChildCount();i++){
       ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
   }








}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

package com.example.android.anr;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void BubbleSort(int[] numbers){
        int n = numbers.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (numbers[j] > numbers[j+1])
                {
                    // swap temp and arr[i]
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
    }

    public void slowProcess(){
        //save start time
        long startTime = System.nanoTime();

        //create a toast msg
        Context context = getApplicationContext();
        CharSequence text = "The process on main thread ended.";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);

        //create int array
        int[] numbers = new int[70000];
        int k = 0;
        for(int i = numbers.length-1; i >= 0; i--){
            numbers[k++] = i;
        }

        //BubbleSort O(n^2)
        BubbleSort(numbers);



        //save end time
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        double seconds = (double)totalTime / 1_000_000_000.00;

        //show toast when sort finish
        TextView textView = findViewById(R.id.totalTimeID);
        textView.setText(Double.toString(seconds) + " sec");
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button button = findViewById(R.id.buttonID);
        button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                //Code here executes on main thread after user presses button

                slowProcess();
            }
        });
    }



}

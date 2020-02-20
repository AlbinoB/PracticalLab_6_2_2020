package com.mitwpu.practicallab_6_2_2020;

import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Change_Background_Image_Activity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButtonTom;
    RadioButton radioButtonJerry;

    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change__background__image_);

        radioGroup=(RadioGroup)findViewById(R.id.radioGroupId);

        radioButtonTom=(RadioButton)findViewById(R.id.radioButtonTom);

        radioButtonJerry=(RadioButton)findViewById(R.id.radioButtonJerry);

        constraintLayout=(ConstraintLayout)findViewById(R.id.backgroudId);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.radioButtonTom : {
                        constraintLayout.setBackgroundResource(R.drawable.tom);
                        break;
                    }
                    case R.id.radioButtonJerry : {
                        constraintLayout.setBackgroundResource(R.drawable.jerry);

                        break;
                    }
                }
            }
        });

    }
}

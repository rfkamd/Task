package com.task.app.views.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.task.app.BR;
import com.task.app.R;
import com.task.app.databinding.ActivityDetailsBinding;
import com.task.app.models.General;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        General data = (General) getIntent().getSerializableExtra("data");
        binding.setVariable(BR.generalType, data);
    }
}

package com.task.app.views.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.task.app.R;
import com.task.app.databinding.ActivityMainBinding;
import com.task.app.models.Announcement;
import com.task.app.network.DataManager;
import com.task.app.network.ResponseListener;
import com.task.app.views.adapters.ItemClick;
import com.task.app.views.adapters.NewsAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String url = "http://94.56.199.34/EMC/IPDP/ipdpb.ashx?TemplateName=Promotions_ipad.htm&p=Common.Announcements&Handler=News&AppName=EMC&Type=News&F=J";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        getAnnouncements();
    }

    SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            getAnnouncements();
        }
    };

    private void getAnnouncements() {
        binding.swipeRefreshLayout.setRefreshing(true);
        DataManager.getAnnouncements(url, callback);
    }

    ResponseListener callback = new ResponseListener() {
        @Override
        public void onApiResponse(List<Announcement> announcements) {
            binding.swipeRefreshLayout.setRefreshing(false);
            initRecyclerView(announcements);
        }

        @Override
        public void onApiResponseFailure(Throwable throwable) {
            binding.swipeRefreshLayout.setRefreshing(false);
            showToast(throwable.getMessage());
        }

    };

    private void initRecyclerView(List<Announcement> announcements) {
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        NewsAdapter adapter = new NewsAdapter(announcements, itemClickListener);
        binding.recyclerView.setAdapter(adapter);
    }

    ItemClick itemClickListener = new ItemClick() {
        @Override
        public void onItemClickListener(Announcement announcement) {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("data", announcement.announcementHtml);
            startActivityForResult(intent, 1);
        }
    };

    private void showToast(String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

}

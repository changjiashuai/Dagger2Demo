package io.github.changjiashuai.dagger2demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        DemoApplication.component().inject(this);
    }

    public void gotoReposList(View view){
        startActivity(new Intent(this, ReposListActivity.class));
    }
}

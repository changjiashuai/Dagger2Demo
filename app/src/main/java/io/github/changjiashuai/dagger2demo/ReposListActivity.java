package io.github.changjiashuai.dagger2demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.changjiashuai.dagger2demo.services.GithubService;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ReposListActivity extends AppCompatActivity {

    @Bind(R.id.repos_rv_list)
    RecyclerView mRvList;

    @Inject
    GithubService mGithubService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos_list);
        ButterKnife.bind(this);
        DemoApplication.component().inject(this);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mLinearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvList.setLayoutManager(mLinearLayoutManager);

        ListAdapter adapter = new ListAdapter();
        mRvList.setAdapter(adapter);
        loadData(adapter);
    }

    private void loadData(ListAdapter adapter){
        mGithubService.getRepoData("changjiashuai")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(adapter::setRepos);
    }
}

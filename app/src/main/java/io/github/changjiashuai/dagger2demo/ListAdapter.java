package io.github.changjiashuai.dagger2demo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/2/20 17:12.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.RepoViewHolder> {

    private ArrayList<Repo> mRepos;

    public ListAdapter() {
        this.mRepos = new ArrayList<>();
    }

    public void setRepos(ArrayList<Repo> mRepos) {
        this.mRepos = mRepos;
        notifyItemInserted(mRepos.size()-1);
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_repo, parent, false);
        return new RepoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.bindTo(mRepos.get(position));
    }

    @Override
    public int getItemCount() {
        return mRepos.size();
    }

    public static class RepoViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.item_tv_repo_name)
        TextView mTvRepoName;
        @Bind(R.id.item_tv_repo_detail)
        TextView mTvRepoDetail;

        public RepoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindTo(Repo repo){
            mTvRepoName.setText(repo.name);
            mTvRepoDetail.setText(String.valueOf(repo.description + "("+repo.language+")"));
        }
    }

    public static class Repo {
        public String name;
        public String description;
        public String language;
    }
}

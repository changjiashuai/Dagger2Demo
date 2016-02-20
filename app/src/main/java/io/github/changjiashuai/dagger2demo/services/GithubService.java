package io.github.changjiashuai.dagger2demo.services;

import java.util.ArrayList;

import io.github.changjiashuai.dagger2demo.ListAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/2/20 17:11.
 */
public interface GithubService {
    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}/repos")
    Observable<ArrayList<ListAdapter.Repo>> getRepoData(@Path("user") String user);
}

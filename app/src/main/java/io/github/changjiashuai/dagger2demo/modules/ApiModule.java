package io.github.changjiashuai.dagger2demo.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.github.changjiashuai.dagger2demo.services.GithubService;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/2/20 17:02.
 *
 * 接口 Module
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    protected GithubService provideGithubService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GithubService.ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(GithubService.class);
    }
}

package io.github.changjiashuai.dagger2demo;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/2/20 16:56.
 *
 * Dagger2的图接口
 */
public interface DemoGraph {
    void inject(MainActivity mainActivity);//注入MainActivity
    void inject(ReposListActivity reposListActivity);//注入RepoListActivity
}

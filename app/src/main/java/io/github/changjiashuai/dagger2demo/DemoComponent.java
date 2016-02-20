package io.github.changjiashuai.dagger2demo;

import javax.inject.Singleton;

import dagger.Component;
import io.github.changjiashuai.dagger2demo.modules.ApiModule;
import io.github.changjiashuai.dagger2demo.modules.MainModule;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 16/2/20 17:00.
 *
 * 组件配置
 */
@Singleton
@Component(modules = {MainModule.class, ApiModule.class})
public interface DemoComponent extends DemoGraph {
    final class Initializer{
        private Initializer() {
        }

        //初始化组件
        public static DemoComponent init(DemoApplication demoApplication){
            return DaggerDemoComponent.builder()
                    .mainModule(new MainModule(demoApplication))
                    .build();
        }
    }
}

package layout.di.components

import com.example.myapplication.App
import layout.di.modules.ActivityInjectorsModule
import layout.di.modules.FragmentInjectorsModule
import layout.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityInjectorsModule::class,
    FragmentInjectorsModule::class,
    AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)

}
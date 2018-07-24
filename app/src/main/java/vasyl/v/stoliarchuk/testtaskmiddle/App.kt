package vasyl.v.stoliarchuk.testtaskmiddle

import dagger.android.support.DaggerApplication
import vasyl.v.stoliarchuk.testtaskmiddle.di.component.DaggerAppComponent

class App : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .build()
}
package com.charlezz.finalarchitecture.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.charlezz.finalarchitecture.App
import com.charlezz.finalarchitecture.AppConstants
import com.charlezz.finalarchitecture.data.AppDataManager
import com.charlezz.finalarchitecture.data.DataManager
import com.charlezz.finalarchitecture.data.local.AppDBHelper
import com.charlezz.finalarchitecture.data.local.AppDatabase
import com.charlezz.finalarchitecture.data.local.AppExecutors
import com.charlezz.finalarchitecture.data.local.DBHelper
import com.charlezz.finalarchitecture.data.pref.AppPreferencesHelper
import com.charlezz.finalarchitecture.data.pref.PreferencesHelper
import com.charlezz.finalarchitecture.data.remote.ApiHelper
import com.charlezz.finalarchitecture.data.remote.AppApiHelper
import com.charlezz.finalarchitecture.di.annotation.DatabaseInfo
import com.charlezz.finalarchitecture.di.annotation.PreferenceInfo
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    val TAG = AppModule::class.java.simpleName

    @Provides
    @Singleton
    fun provideAppContext(app: App): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideApplication(app: App): Application {
        return app
    }

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context, @DatabaseInfo dbName: String): AppDatabase {
        return Room
                .databaseBuilder(context, AppDatabase::class.java, dbName)
                .fallbackToDestructiveMigration()
                .build()
    }

    @Provides
    @Singleton
    fun provideDBHelper(appDBHelper: AppDBHelper): DBHelper {
        return appDBHelper
    }


    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }

    @Provides
    @PreferenceInfo
    fun providePreferenceName(): String {
        return AppConstants.PREF_NAME
    }

    @Provides
    @DatabaseInfo
    fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    fun provideAppExecutor(): AppExecutors {
        return AppExecutors()
    }

}
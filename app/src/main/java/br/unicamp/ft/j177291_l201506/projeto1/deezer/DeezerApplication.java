package br.unicamp.ft.j177291_l201506.projeto1.model;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.deezer.sdk.network.connect.DeezerConnect;

import br.unicamp.ft.j177291_l201506.projeto1.R;
import br.unicamp.ft.j177291_l201506.projeto1.model.DataSourceFactory;


public class DeezerApplication extends Application {
    private ApiRequestFactory mApiRequestFactory;
    private Handler mHandler;
    private DataSourceFactory mDataSourceFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        DeezerConnect deezerConnect = DeezerConnect.forApp(getString(R.string.deezer_app_id))
                .withContext(this)
                .build();
        mApiRequestFactory = new ApiRequestFactory(deezerConnect);
        mHandler = new Handler(Looper.getMainLooper());
        mDataSourceFactory = new DataSourceFactory(this);
    }

    public ApiRequestFactory getApiRequestFactory(){
        return mApiRequestFactory;
    }

    public Handler getDefaultHandler() {
        return mHandler;
    }

    public DataSourceFactory getDataSourceFactory() {
        return mDataSourceFactory;
    }
}


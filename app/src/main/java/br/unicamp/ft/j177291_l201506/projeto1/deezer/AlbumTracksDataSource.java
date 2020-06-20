
package br.unicamp.ft.j177291_l201506.projeto1.deezer;

import android.content.Context;

import com.deezer.sdk.model.Album;
import com.deezer.sdk.model.Track;

import java.util.ArrayList;

public class AlbumTracksDataSource extends DataSource<Track>{
    private ArrayList<Track> mTracks;
    private final Album mAlbum;

    public AlbumTracksDataSource(Context context, Album album) {
        super(context);
        mAlbum = album;
        mTracks = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    @Override
    public Track getItem(int position) {
        return mTracks.get(position);
    }

    @Override
    public void fetchData() {
        mApiRequestFactory.newAlbumTracksRequest(mAlbum.getId(), new ApiRequestFactory.RequestCallback() {
            @Override
            public void onRequestSuccess(Object result) {
                mTracks = (ArrayList<Track>) result;
                notifyDataLoaded();
            }

            @Override
            public void onRequestFailed(Exception exception) {
                notifyError(exception.getMessage());
            }
        });
    }

    public Album getAlbum() {
        return mAlbum;
    }
}
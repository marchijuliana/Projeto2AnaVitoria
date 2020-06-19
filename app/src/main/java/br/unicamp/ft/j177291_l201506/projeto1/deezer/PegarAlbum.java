package br.unicamp.ft.j177291_l201506.projeto1.model;

import com.deezer.sdk.model.Album;
import com.deezer.sdk.network.request.DeezerRequest;
import com.deezer.sdk.network.request.DeezerRequestFactory;
import com.deezer.sdk.network.request.event.JsonRequestListener;
import com.deezer.sdk.network.request.event.RequestListener;

import java.util.List;

public class PegarAlbum {
    // the request listener
    RequestListener listener = new JsonRequestListener() {

        public void onResult(Object result, Object requestId) {
            List<Album> albums = (List<Album>) result;

            // do something with the albums
        }

        public void onUnparsedResult(String requestResponse, Object requestId) {}

        public void onException(Exception e, Object requestId) {}
    };

    // create the request
    long artistId = 7765128;
    DeezerRequest request = DeezerRequestFactory.requestArtistAlbums(artistId);

    // set a requestId, that will be passed on the listener's callback methods
    request.setId("myRequest");

    // launch the request asynchronously
    deezerConnect.requestAsync(request, listener);
}

package tablayout;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.hiepnd.musicplayer.PlayMusicActivity;
import com.hiepnd.musicplayer.R;

import java.util.ArrayList;

import adapter.SongAdapter;
import model.SongModel;

/**
 * Created by hiepn on 8/22/2017.
 */

public class SongFragment extends Fragment {
    TextView tvNameSongNotification, tvArtistNotification;
    private ListView lvSong;
    private ArrayList<SongModel> mListSong = new ArrayList<>();
    private SongAdapter adapter;
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.layout_song_fragment, container, false);
        initView();
        return mRootView;
    }

    private void initView() {
        if (mListSong.size() == 0) {
            mListSong = getAllAudioFromDevice(getActivity());
        }
        adapter = new SongAdapter(getActivity(), mListSong, R.layout.item_song);
        lvSong = mRootView.findViewById(R.id.lvSong);
        lvSong.setAdapter(adapter);
        lvSong.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), PlayMusicActivity.class);
                intent.putExtra("MusicName", mListSong.get(position).getName());
                intent.putExtra("Duration", mListSong.get(position).getDuration());
                startActivity(intent);
            }
        });
    }

    public ArrayList<SongModel> getAllAudioFromDevice(final Context context) {
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Audio.AudioColumns.DATA,
                MediaStore.Audio.AudioColumns.ALBUM,
                MediaStore.Audio.ArtistColumns.ARTIST,
                MediaStore.Audio.AudioColumns.DURATION,
        };
        Cursor c = context.getContentResolver().query(uri, projection, null, null, null);

        if (c != null) {
            while (c.moveToNext()) {

                SongModel songModel = new SongModel();
                String path = c.getString(0);
                String album = c.getString(1);
                String artist = c.getString(2);
                String duration = c.getString(3);
                String name = path.substring(path.lastIndexOf("/") + 1);

                songModel.setName(name);
                songModel.setAlbum(album);
                songModel.setArtist(artist);
                songModel.setPath(path);
                songModel.setDuration(duration);

                //Log.e("Name :" + name, " Album :" + album);
                //Log.e("Path :" + path, " Artist :" + artist);

                mListSong.add(songModel);
            }
            c.close();
        }

        return mListSong;
    }

}

package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hiepnd.musicplayer.R;

import java.util.ArrayList;

import model.SongModel;

/**
 * Created by hiepn on 8/22/2017.
 */

public class SongAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<SongModel> mListSong;
    private int mInflater;

    public SongAdapter(Context context, ArrayList<SongModel> mListSong, int mInflater) {
        this.context = context;
        this.mListSong = mListSong;
        this.mInflater = mInflater;
    }

    @Override
    public int getCount() {
        return mListSong.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mInflater,null);
            viewHolder = new ViewHolder();
            viewHolder.imvImage = convertView.findViewById(R.id.imvImage);
            viewHolder.tvNameSong = convertView.findViewById(R.id.tvNameSong);
            viewHolder.tvArtist = convertView.findViewById(R.id.tvArtist);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SongModel songModel = mListSong.get(position);
        //viewHolder.imvImage.setImageResource(songModel.getImage());
        viewHolder.tvNameSong.setText(songModel.getName());
        viewHolder.tvArtist.setText(songModel.getArtist());
        return convertView;
    }

    private class ViewHolder {
        ImageView imvImage;
        TextView tvNameSong;
        TextView tvArtist;
    }
}

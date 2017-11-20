package com.huwei.sweetmusicplayer.business.ui.itemviews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huwei.sweetmusicplayer.R;
import com.huwei.sweetmusicplayer.business.models.ArtistInfo;

import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * @author jerry
 * @date 2016/01/15
 */
@EViewGroup(R.layout.card_artist)
public class ArtistItemView extends LinearLayout implements IRecycleViewItem<ArtistInfo> {

    @ViewById
    TextView tv_title, tv_numsongs;
    @ViewById
    ImageView iv_artist;

    public ArtistItemView(Context context) {
        this(context, null);
    }

    public ArtistItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void bind(ArtistInfo artistInfo) {
        Glide.with(getContext()).load(artistInfo.getAlbumArtPic()).into(iv_artist);
        tv_title.setText(artistInfo.getArtist());
        tv_numsongs.setText(artistInfo.getNumSongs()+"首");
    }
}
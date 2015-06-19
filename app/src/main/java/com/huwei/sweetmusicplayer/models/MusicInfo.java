package com.huwei.sweetmusicplayer.models;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 

import android.os.Parcel;
import android.os.Parcelable;

import com.huwei.sweetmusicplayer.util.CharacterParser;
import com.huwei.sweetmusicplayer.util.TimeUtil;

/**
 * Entity mapped to table MUSIC_INFO.
 */
public class MusicInfo implements Parcelable {

    private Long songId;
    private Long albumId;
    private String title;
    private String artist;
    private Integer duration;
    private String path;
    private Boolean favorite;

    public MusicInfo() {
    }

    public MusicInfo(Long songId) {
        this.songId = songId;
    }

    public MusicInfo(Long songId, Long albumId, String title, String artist, Integer duration, String path, Boolean favorite) {
        this.songId = songId;
        this.albumId = albumId;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.path = path;
        this.favorite = favorite;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(Boolean favorite) {
        this.favorite = favorite;
    }

    /**
     *
     * define by myself
     */
    public static final Byte ISFAVORITE=1;
    public static final Byte NOTFAVORITE=0;

    public MusicInfo(Parcel parcel){
        super();

        this.songId=parcel.readLong();
        this.albumId=parcel.readLong();
        this.title=parcel.readString();
        this.artist = parcel.readString();
        this.duration = parcel.readInt();
        this.path = parcel.readString();
        this.favorite = parcel.readByte()==ISFAVORITE;
    }

    public String getDurationStr(){
        return TimeUtil.mill2mmss(duration);
    }

    /**
     * 获取title的首字母
     * @return
     */
    public String getKeyofTitle(){
        return CharacterParser.getFirstUpperLetter(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
//        this.songId=parcel.readInt();
//        this.albumId=parcel.readInt();
//        this.title=parcel.readString();
//        this.artist = parcel.readString();
//        this.duration = parcel.readInt();
//        this.path = parcel.readString();
//        this.favorite = parcel.readByte()==ISFAVORITE;
        dest.writeLong(songId);
        dest.writeLong(albumId);
        dest.writeString(title);
        dest.writeString(artist);
        dest.writeInt(duration);
        dest.writeString(path);
        dest.writeByte(favorite ? ISFAVORITE : NOTFAVORITE);
    }

    public static final Creator<MusicInfo> CREATOR = new Creator<MusicInfo>(){
        @Override
        public MusicInfo createFromParcel(Parcel parcel) {
            return new MusicInfo(parcel);
        }

        @Override
        public MusicInfo[] newArray(int size) {
            return new MusicInfo[size];
        }
    };
}
/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.suaji.testtv;

import java.util.ArrayList;
import java.util.List;

public final class MovieList {
    public static final String MOVIE_CATEGORY[] = {
            "LIVE TV"
    };

    private static List<Movie> list;
    private static long count = 0;

    public static List<Movie> getList() {
        if (list == null) {
            list = setupMovies();
        }
        return list;
    }

    public static List<Movie> setupMovies() {
        list = new ArrayList<>();
        String title[] = {
                "TV IKIM",
                "TV1",
                "TV2",
                "TV3",
                "NTV7",
                "8TV",
                "TV9",
                "OKEY",
                "TVI",
                "1NEWS",
                "BERNAMA",
                "AWANI",
                "ARENA",
                "PARLIMEN"
        };

        String description = "SIARAN PERCUMA "
                + "(FREE TO AIR)";
        String studio[] = {
                "TV IKIM", "TV1", "TV2", "TV3", "NTV7", "8TV", "TV9", "OKEY", "TVI",
                "1NEWS", "BERNAMA", "AWANI", "ARENA", "PARLIMEN",
        };
        String videoUrl[] = {
                "http://edge.vediostream.com/abr/tvikim/playlist.m3u8", //IKIM
                "http://rtm-live.glueapi.io/smil:rtmch001.smil/chunklist_b1064000_sleng.m3u8", //TV1
                "http://rtm-live.glueapi.io/smil:rtmch002/chunklist_b1064000_sleng.m3u8", //TV2
                "http://stream-01.sg1.dailymotion.com/dm/3/x6qp375/live-1.m3u8", //TV3
                "http://stream-03.sg1.dailymotion.com/dm/dm/3/x6qp6ou/live.m3u8", //NTV7
                "http://stream-02.sg1.dailymotion.com/dm/3/x6qud17/live-1.m3u8", //8TV
                "http://stream-02.sg1.dailymotion.com/dm/3/x6qqja6/live.m3u8", //TV9
                "http://rtm-live.glueapi.io/smil:rtmch003.smil/chunklist_b1064000_sleng.m3u8", //OKEY
                "http://rtm-live.glueapi.io/smil:rtmch004/chunklist_b1040000_sleng.m3u8", //TVI
                "http://rtm-live.glueapi.io/smil:rtmch006/chunklist_b1040000_sleng.m3u8", //1NEWS
                "http://stream2.1malaysiaiptv.com/mylive/smil:bernama2_all.smil/playlist.m3u8", //BERNAMA
                "http://bcoveliveios-i.akamaihd.net/hls/live/225864/4508222217001/master.m3u8", //AWANI
                "http://playbackn5.aotg-video.astro.com.my/CH1/master_ARENA_8.m3u8", //ARENA
                "http://rtm-live.glueapi.io/smil:rtmch007/chunklist_b1040000_sleng.m3u8", //PARLIMEN
        };
        String bgImageUrl[] = {
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/ikimtv_webos.jpg",
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tv1_webos.jpg",
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tv2_webos.jpg",
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tv3a_webos.jpg",
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/ntv7_webos.jpg",
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/8tva_webos.jpg",
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tv9a_webos.jpg",
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/okey_webos.jpg", //OKEY
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tvi_webos.jpg", //TVI
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/1new_webos.jpg", //1NEWS
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/bernamatv_webos.jpg", //BERNAMA
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/awani_webos.jpg", //AWANI
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/arena_webos.jpg", //ARENA
                "https://1raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/parlimen_webos.jpg", //PARLIMEN
        };
        String cardImageUrl[] = {
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/ikimtv_webos.jpg",
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tv1_webos.jpg",
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tv2_webos.jpg",
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tv3a_webos.jpg",
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/ntv7_webos.jpg",
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/8tva_webos.jpg",
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tv9a_webos.jpg",
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/okey_webos.jpg", //OKEY
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/tvi_webos.jpg", //TVI
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/1new_webos.jpg", //1NEWS
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/bernamatv_webos.jpg", //BERNAMA
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/awani_webos.jpg", //AWANI
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/arena_webos.jpg", //ARENA
                "https://raw.githubusercontent.com/suaji/webOS_OSE/master/fta%20icons/parlimen_webos.jpg", //PARLIMEN
        };

        for (int index = 0; index < title.length; ++index) {
            list.add(
                    buildMovieInfo(
                            title[index],
                            description,
                            studio[index],
                            videoUrl[index],
                            cardImageUrl[index],
                            bgImageUrl[index]));
        }

        return list;
    }

    private static Movie buildMovieInfo(
            String title,
            String description,
            String studio,
            String videoUrl,
            String cardImageUrl,
            String backgroundImageUrl) {
        Movie movie = new Movie();
        movie.setId(count++);
        movie.setTitle(title);
        movie.setDescription(description);
        movie.setStudio(studio);
        movie.setCardImageUrl(cardImageUrl);
        movie.setBackgroundImageUrl(backgroundImageUrl);
        movie.setVideoUrl(videoUrl);
        return movie;
    }
}
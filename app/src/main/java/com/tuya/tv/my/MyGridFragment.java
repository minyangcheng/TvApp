package com.tuya.tv.my;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;

import com.tuya.tv.CardPresenter;
import com.tuya.tv.Movie;
import com.tuya.tv.MovieList;

import java.util.Collections;
import java.util.List;

public class MyGridFragment extends RowsSupportFragment {

    private ArrayObjectAdapter mainAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        view.setBackgroundColor(Color.parseColor("#ffffff"));
        init();
    }

    private void init() {
        CardPresenter cardPresenter = new CardPresenter();
        List<Movie> list = MovieList.setupMovies();

        ListRowPresenter listRowPresenter = new ListRowPresenter();
        mainAdapter = new ArrayObjectAdapter(listRowPresenter);

        int i;
        for (i = 0; i < 6; i++) {
            if (i != 0) {
                Collections.shuffle(list);
            }
            ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(cardPresenter);
            for (int j = 0; j < 15; j++) {
                listRowAdapter.add(list.get(j % 5));
            }

            HeaderItem header = new HeaderItem(MovieList.MOVIE_CATEGORY[i]);
            mainAdapter.add(new ListRow(header, listRowAdapter));
        }
        setAdapter(mainAdapter);
    }

}

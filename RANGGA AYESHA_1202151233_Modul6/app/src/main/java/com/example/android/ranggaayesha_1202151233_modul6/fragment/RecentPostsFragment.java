package com.example.android.ranggaayesha_1202151233_modul6.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;


public class RecentPostsFragment extends PostListFragment {
    public RecentPostsFragment(){}

    @Override

    public Query getQuery(DatabaseReference databaseReference) {

        // [START recent_posts_query]

        //Memberikan batasan dari jumlah post terbaru yang akan ditampilkan ==100

        Query recentPostsQuery = databaseReference.child("posts")           //menampilkan postingan terbaru

                .limitToFirst(100);

        // [END recent_posts_query]

        return recentPostsQuery;

    }
}

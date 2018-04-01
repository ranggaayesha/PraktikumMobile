package com.example.android.ranggaayesha_1202151233_modul6.fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;


public class MyTopPostsFragment extends PostListFragment {
    public MyTopPostsFragment() {}



    @Override

    public Query getQuery(DatabaseReference databaseReference) {

        // [START my_top_posts_query]

        //Mengurutkan daftar post yang dimiliki berdasarkan jumlah bintang yang diberikan

        String myUserId = getUid();

        Query myTopPostsQuery = databaseReference.child("user-posts").child(myUserId)           //memberikan nama database untuk postingan dari akun yang sedang dipakai

                .orderByChild("starCount");         //akan melihat jumlah bintang yang ada pada postingan

        // [END my_top_posts_query]

        return myTopPostsQuery;

    }
}

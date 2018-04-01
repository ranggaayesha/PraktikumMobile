package com.example.android.ranggaayesha_1202151233_modul6;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.ranggaayesha_1202151233_modul6.model.Post;
import com.example.android.ranggaayesha_1202151233_modul6.model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class PostFoto extends AppCompatActivity {

    private static final String TAG = "NewPostActivity";

    private static final String REQUIRED = "Required";

    String imgDecodableString;

    // [START declare_database_ref]

    private DatabaseReference mDatabase;

    // [END declare_database_ref]



    private EditText mTitleField;

    private EditText mBodyField;

    private Button btnChoose;

    ImageView imageView;

    private FloatingActionButton mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_foto);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mTitleField = findViewById(R.id.field_title);

        mBodyField = findViewById(R.id.field_body);

        mSubmitButton = findViewById(R.id.fab_submit_post);

        btnChoose = findViewById(R.id.choose);

        imageView = findViewById(R.id.gambar);

        btnChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK,
//                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
//                intent.setType("image/*");
//                intent.putExtra("crop", "true");
//                intent.putExtra("scale", true);
//                intent.putExtra("outputX", 256);
//                intent.putExtra("outputY", 256);
//                intent.putExtra("aspectX", 1);
//                intent.putExtra("aspectY", 1);
//                intent.putExtra("return-data", true);
//                startActivityForResult(intent, 1);

                Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, 1);
            }
        });



        mSubmitButton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                submitPost();

            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == 1 && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();

                // Set the Image in ImageView after decoding the String
                imageView.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }

    private void submitPost() {
        final String title = mTitleField.getText().toString();

        final String body = mBodyField.getText().toString();



        // Title is required

        if (TextUtils.isEmpty(title)) {

            mTitleField.setError(REQUIRED);

            return;

        }



        // Body is required

        if (TextUtils.isEmpty(body)) {

            mBodyField.setError(REQUIRED);

            return;

        }

        setEditingEnabled(false);

        Toast.makeText(this, "Posting...", Toast.LENGTH_SHORT).show();

        FirebaseUser current_user = FirebaseAuth.getInstance().getCurrentUser();

        final String userId = current_user.getUid();

        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(

                new ValueEventListener() {

                    @Override

                    public void onDataChange(DataSnapshot dataSnapshot) {

                        // Get user value

                        User user = dataSnapshot.getValue(User.class);



                        // [START_EXCLUDE]

                        if (user == null) {

                            // User is null, error out

                            Log.e(TAG, "User " + userId + " is unexpectedly null");

                            Toast.makeText(PostFoto.this,

                                    "Error: could not fetch user.",

                                    Toast.LENGTH_SHORT).show();

                        } else {

                            // Write new post

                            writeNewPost(userId, user.username, title, body);

                        }



                        // Finish this Activity, back to the stream

                        setEditingEnabled(true);

                        finish();

                        // [END_EXCLUDE]

                    }



                    @Override

                    public void onCancelled(DatabaseError databaseError) {

                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());

                        // [START_EXCLUDE]

                        setEditingEnabled(true);

                        // [END_EXCLUDE]

                    }

                });


    }

    private void setEditingEnabled(boolean b) {
        mTitleField.setEnabled(b);

        mBodyField.setEnabled(b);

        if (b) {

            mSubmitButton.setVisibility(View.VISIBLE);

        } else {

            mSubmitButton.setVisibility(View.GONE);

        }
    }

    private void writeNewPost(String userId, String username, String title, String body) {

        // Create new post at /user-posts/$userid/$postid and at

        // /posts/$postid simultaneously

        String key = mDatabase.child("posts").push().getKey();

        Post post = new Post(userId, username, title, body);

        Map<String, Object> postValues = post.toMap();



        Map<String, Object> childUpdates = new HashMap<>();

        childUpdates.put("/posts/" + key, postValues);

        childUpdates.put("/user-posts/" + userId + "/" + key, postValues);



        mDatabase.updateChildren(childUpdates);

    }
}

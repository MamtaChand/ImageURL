package com.example.imageurl;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView theImage;
    Button theHulk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theImage = findViewById(R.id.theImage);
        theHulk = findViewById(R.id.theHulk);

//        final String imgURL  = "https://images.pexels.com/photos/1386604/pexels-photo-1386604.jpeg";

        // Image link from internet
        new DownLoadImageTask(theImage)
                .execute("https://softwarica.edu.np/wp-content/uploads/2019/02/Kiran-Rana.jpg");

        theHulk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("*/*");
                startActivityForResult(intent, 7);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub

        switch(requestCode){

            case 7:

                if(resultCode==RESULT_OK){

                    Uri selectedImageUri = data.getData();
                    theImage.setImageURI(selectedImageUri);
                }
                break;

        }
    }
}

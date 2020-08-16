package com.philip.finaltest;

import androidx.appcompat.app.AppCompatActivity;


import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.QRCodeDetector;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);

        if (!OpenCVLoader.initDebug()) {
            Log.d("Philip", "dead");
        } else {
            Log.d("Philip", " alive");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap;
                Bitmap bitmap2;
                bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
                bitmap2 = ((BitmapDrawable)imageView2.getDrawable()).getBitmap();
                Mat mat = new Mat(); //import
                Mat mat2 = new Mat();
                Utils.bitmapToMat(bitmap, mat);
                Utils.bitmapToMat(bitmap2, mat2);
                QRCodeDetector qrCodeDetector = new QRCodeDetector();
                String result = qrCodeDetector.detectAndDecode(mat);

                Log.d("MainActivity", "OnClick" + result);
                //result:500,250 327,488 48,397 48,103 327,12 500,250
                String[] lines = result.split(  " ");
                Log.d("MainActivity", "gg" + lines.toString());
                String pointA = result.split(" ")[0];
                Log.d("MainActivity", "OnClick" + pointA);
                String pointB = result.split(" ")[1];
                Log.d("MainActivity", "OnClick" + pointB);
                String pointC = result.split(" ")[2];
                Log.d("MainActivity", "OnClick" + pointC);
                String pointD = result.split(" ")[3];
                Log.d("MainActivity", "OnClick" + pointD);
                String pointE = result.split(" ")[4];
                Log.d("MainActivity", "OnClick" + pointE);
                String pointF = result.split(" ")[5];
                Log.d("MainActivity", "OnClick" + pointF);

                //for(int i = 0 ; i< lines.length ; i++) {
                    //String line = lines[i];
                    //Log.d("MainActivity", "gg" + line);

                    String xA = pointA.split(",")[0];
                    Log.d("MainActivity", "OnClick" + xA);
                    String yA = pointA.split(",")[1];
                    Log.d("MainActivity", "OnClick" + yA);

                    String xB = pointB.split(",")[0];
                    Log.d("MainActivity", "OnClick" + xB);
                    String yB = pointB.split(",")[1];
                    Log.d("MainActivity", "OnClick" + yB);

                    String xC = pointC.split(",")[0];
                    Log.d("MainActivity", "OnClick" + xB);
                    String yC = pointC.split(",")[1];
                    Log.d("MainActivity", "OnClick" + yB);

                    String xD = pointD.split(",")[0];
                    Log.d("MainActivity", "OnClick" + xB);
                    String yD = pointD.split(",")[1];
                    Log.d("MainActivity", "OnClick" + yB);

                    String xE = pointE.split(",")[0];
                    Log.d("MainActivity", "OnClick" + xB);
                    String yE = pointE.split(",")[1];
                    Log.d("MainActivity", "OnClick" + yB);

                    String xF = pointF.split(",")[0];
                    Log.d("MainActivity", "OnClick" + xB);
                    String yF = pointF.split(",")[1];
                    Log.d("MainActivity", "OnClick" + yB);



                    Point point1 = new Point(Double.valueOf(xA), Double.valueOf(yA));
                    Point point2 = new Point(Double.valueOf(xB), Double.valueOf(yB));
                    Point point3 = new Point(Double.valueOf(xC), Double.valueOf(yC));
                    Point point4 = new Point(Double.valueOf(xD), Double.valueOf(yD));
                    Point point5 = new Point(Double.valueOf(xE), Double.valueOf(yE));
                    Point point6 = new Point(Double.valueOf(xF), Double.valueOf(yF));

                    drawLine(mat2, point1, point2);
                    drawLine(mat2, point2, point3);
                drawLine(mat2, point3, point4);
                drawLine(mat2, point4, point5);
                drawLine(mat2, point5, point6);


                //}
               Utils.matToBitmap(mat,bitmap);
            imageView.setImageBitmap(bitmap);
                Utils.matToBitmap(mat2,bitmap2);
                imageView2.setImageBitmap(bitmap2);

            }
        });


    }
    void drawLine(Mat mat2, Point point1, Point point6) {
        Scalar color = new Scalar(255, 0, 0, 255);
        Imgproc.line(mat2, point1, point6, color, 5);

    }
    }

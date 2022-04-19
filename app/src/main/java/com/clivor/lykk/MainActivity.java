package com.clivor.lykk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.clivor.lykk.db.Entity;
import com.clivor.lykk.db.PointsDataBase;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int w;
    private int h;
    private Display display;
    private ImageView imageViewPers, imageViewSave, imageViewList, imageViewRegulations;
    private ConstraintLayout constrain;
    ArrayList<ImageView> arrayListImages;
    private int size;
    private TextView textViewPoints;
    private int counter = 0;
    String saveNeme = null;
    boolean stop = false;
    PointsDataBase pointsDataBase;
    Entity entity;
    ArrayList<Entity> arrayListEntity;
    ArrayList<Points> arrayListPoints;
    Points points;
    PointsAdapter pointsAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(1024);
        arrayListPoints = new ArrayList<>();

        new Thread(new Runnable() {
            @Override
            public void run() {
                pointsDataBase = Room.databaseBuilder(getApplicationContext(),
                        PointsDataBase.class, "points").build();
            }
        }).start();

        display = getWindowManager().getDefaultDisplay();
        w = display.getWidth();
        h = display.getHeight();
        imageViewPers = findViewById(R.id.imageViewPers);
        constrain = findViewById(R.id.constrain);
        textViewPoints = findViewById(R.id.textViewPoints);
        imageViewSave = findViewById(R.id.imageViewSave);
        imageViewList = findViewById(R.id.imageViewList);

        imageViewRegulations = findViewById(R.id.imageViewRegulations);
        size = w / 10;
        arrayListImages = new ArrayList<>();

        imageViewSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop = true;
                LayoutInflater layoutInflate = LayoutInflater.from(MainActivity.this);
                View viewSave = layoutInflate.inflate(R.layout.save, null);
                TextView textView = viewSave.findViewById(R.id.textViewSaveee);
                EditText editText = viewSave.findViewById(R.id.editTextTextPersonName);
                editText.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                        saveNeme = editable.toString();
                        Log.d("weq", saveNeme);
                    }
                });
                textView.setText("points: " + counter);
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Save")
                        .setView(viewSave)
                        .setPositiveButton(android.R.string.ok, null)
                        .setNegativeButton(android.R.string.cancel, null)
                        .create();

                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

                    @Override
                    public void onShow(DialogInterface dialogInterface) {

                        Button button = ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {


                                if (saveNeme != null) {
                                    new Thread(new Runnable() {
                                        @Override
                                        public void run() {
                                            String ss = String.valueOf(counter);
                                            entity = new Entity(saveNeme, ss);
                                            pointsDataBase.daoTab().entity(entity);
                                        }
                                    }).start();
                                    if (arrayListPoints.size() > 0) {
                                        for (int i = 0; i < arrayListPoints.size(); i++) {
                                            arrayListPoints.remove(i);
                                        }
                                        if (arrayListEntity.size() > 0) {
                                            for (int i = 0; i < arrayListEntity.size(); i++) {
                                                arrayListEntity.remove(i);
                                            }
                                        }
                                    }
                                    stop = false;
                                    runGame();
                                    alertDialog.dismiss();

                                } else {

                                    Toast toast = Toast.makeText(getApplicationContext(), "Enter your name", Toast.LENGTH_SHORT);
                                    toast.show();
                                }
                            }
                        });
                    }
                });

                alertDialog.show();


            }
        });

        imageViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop = true;
                LayoutInflater layoutInflate = LayoutInflater.from(MainActivity.this);
                View viewList = layoutInflate.inflate(R.layout.list, null);
                recyclerView = viewList.findViewById(R.id.recyclerViewwew);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.hasFixedSize();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            int size = pointsDataBase.daoTab().getEntity().size();

                            for (int i = 0; i < size; i++) {

                                arrayListEntity = (ArrayList<Entity>) pointsDataBase.daoTab().getEntity();
                                points = new Points();
                                points.setPoints(String.valueOf(arrayListEntity.get(i).getPoints()));
                                points.setName(arrayListEntity.get(i).getName());
                                arrayListPoints.add(points);

                            }


                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {

                                    pointsAdapter = new PointsAdapter(MainActivity.this, arrayListPoints);
                                    recyclerView.setAdapter(pointsAdapter);

                                }
                            });

                        } catch (Exception e) {

                        }
                    }
                }).start();

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Saved records")
                        .setView(viewList)
                        .setPositiveButton(android.R.string.ok, null)
                        .create();


                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

                    @Override
                    public void onShow(DialogInterface dialogInterface) {

                        Button button = ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE);
                        button.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                stop = false;
                                runGame();
                                alertDialog.dismiss();
                            }
                        });
                    }
                });

                alertDialog.show();
            }
        });


        imageViewRegulations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stop = true;
                LayoutInflater layoutInflater = LayoutInflater.from(MainActivity.this);
                View viewRegulations = layoutInflater.inflate(R.layout.regulations, null);

                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                        .setView(viewRegulations)
                        .setTitle("Regulations")
                        .setPositiveButton(android.R.string.ok, null)
                        .create();

                alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {

                    @Override
                    public void onShow(DialogInterface dialogInterface) {

                        Button button = ((AlertDialog) alertDialog).getButton(AlertDialog.BUTTON_POSITIVE);
                        button.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(View view) {

                                stop = false;
                                runGame();
                                alertDialog.dismiss();

                            }
                        });
                    }
                });
                alertDialog.show();


            }
        });

        runGame();


        constrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        imageViewPers.setY(imageViewPers.getY() - 105);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                if (stop == true) {
                                    runGame();
                                    stop = false;
                                }
                            }
                        });

                    }
                }).start();
            }
        });
    }

    private void runGame() {
        Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                if (h / 2 > imageViewPers.getY()) {
                    imageViewPers.setY(imageViewPers.getY() + 55);
                }

                if (!stop) {
                    handler.postDelayed(this::run, 200);
                }

            }
        });

        handler.post(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                ImageView imageView = new ImageView(MainActivity.this);
                ConstraintLayout.LayoutParams constraintsImages = new ConstraintLayout.LayoutParams(size, size);
                imageView.setLayoutParams(constraintsImages);
                constrain.addView(imageView, constraintsImages);
                int t = random.nextInt(7);
                switch (t) {
                    case 0:
                        imageView.setImageResource(R.drawable.slot1);
                        imageView.setTag(1);
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.slot2);
                        imageView.setTag(1);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.slot3);
                        imageView.setTag(1);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.slot4);
                        imageView.setTag(1);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.slot5);
                        imageView.setTag(3);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.slot6);
                        imageView.setTag(2);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.slot7);
                        imageView.setTag(1);
                        break;
                }

                int r = random.nextInt(3);
                switch (r) {
                    case 0:
                        imageView.setY(0);
                        break;
                    case 1:
                        imageView.setY(h / 2 - size);
                        break;
                    case 2:
                        imageView.setY(h - (size + size));
                        break;
                }

                imageView.setX(0);
                arrayListImages.add(imageView);
                if (!stop) {
                    handler.postDelayed(this::run, 1000);
                }

            }
        });


        handler.post(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < arrayListImages.size(); i++) {
                    ImageView imageView = arrayListImages.get(i);
                    imageView.setX(imageView.getX() + 25);
                    Rect myViewRect = new Rect();
                    imageView.getHitRect(myViewRect);

                    Rect otherViewRect1 = new Rect();
                    imageViewPers.getHitRect(otherViewRect1);

                    if (Rect.intersects(myViewRect, otherViewRect1)) {
                        arrayListImages.remove(imageView);
                        constrain.removeView(imageView);
                        Log.d("weq", imageView.getTag().toString());
                        if (imageView.getTag().toString().equals("2")) {
                            counter -= 10;
                        } else if (imageView.getTag().toString().equals("3")) {
                            counter += 5;
                        } else {
                            counter++;
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textViewPoints.setText(" Your points: " + counter);
                            }
                        });

                    }

                    if (imageView.getX() > w) {
                        arrayListImages.remove(imageView);
                        constrain.removeView(imageView);
                    }
                }

                if (!stop) {
                    handler.postDelayed(this::run, 100);
                }

            }
        });
    }
}
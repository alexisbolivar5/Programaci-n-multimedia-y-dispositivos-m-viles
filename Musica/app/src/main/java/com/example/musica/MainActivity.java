package com.example.musica;

import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    private MediaPlayer mediaPlayer;
    private Button bPlay;
    private Button bPause;
    private Button bStop;
    private Button bCarga;
    private Button bRelease;
    private Button bSeek;
    private SoundPool soundPool;

    private Button btnSoundPool1;
    private Button btnSoundPool2;
    private Button btnSoundPool3;
    private Button btnSoundPool4;
    private TextView tvTiempo;
    private SeekBar seekBar;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button bPlay = (Button) findViewById(R.id.bPlay);
        Button bPause = (Button) findViewById(R.id.bPause);
        Button bStop = (Button) findViewById(R.id.bStop);
        Button bCarga = (Button) findViewById(R.id.bCarga);
        Button bRelease = (Button) findViewById(R.id.bRelease);
        Button bSeek = (Button) findViewById(R.id.bSeek);
        mediaPlayer = MediaPlayer.create(this, R.raw.never);
        Button btnSoundPool1 = findViewById(R.id.btnSoundPool1);
        Button btnSoundPool2 = findViewById(R.id.btnSoundPool2);
        Button btnSoundPool3 = findViewById(R.id.btnSoundPool3);
        Button btnSoundPool4 = findViewById(R.id.btnSoundPool4);

        SeekBar seekBar = findViewById(R.id.seekBar);
        tvTiempo = findViewById(R.id.tvTiempo);


        bPlay.setOnClickListener(new View.OnClickListener() {
       @Override
        public void onClick(View v) {

           mediaPlayer.start();
       }
        });

        bPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {

                mediaPlayer.stop();
            }
            });
        bCarga.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        });
        bRelease.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {

                mediaPlayer.release();
            }
        });
        bSeek.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View v) {

                mediaPlayer.seekTo(10000);
            }
        });



        bSeek.setOnClickListener ( v -> {
            int p = Integer.parseInt(bSeek.getText().toString());
            mediaPlayer.seekTo(p);
        });


        mediaPlayer.setOnPreparedListener(mp -> {
            seekBar.setMax(mediaPlayer.getDuration());
            tvTiempo.setText("00:00");
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public  void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }




            @Override public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        Handler handler = new Handler();
        Runnable actualizar = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());

                //Pongo el tiempo en el TextView
                int minutos = mediaPlayer.getCurrentPosition() / 1000 / 60;
                int segundos = mediaPlayer.getCurrentPosition() / 1000 % 60;
                String tiempo = String.format("%02d:%02d", minutos, segundos);
                tvTiempo.setText(tiempo);

                //Configuro la actualización dentro de un segundo
                handler.postDelayed(this, 1000);
            }
        };
        handler.post(actualizar);


        soundPool = new SoundPool.Builder().setMaxStreams(10).build();

        int sonido1 = soundPool.load( this, R.raw.pom, 1);
        int sonido2 = soundPool.load( this, R.raw.pun, 1);
        int sonido3 = soundPool.load( this, R.raw.pam, 1);
        int sonido4 = soundPool.load( this, R.raw.pin, 1);


        btnSoundPool1.setOnClickListener(new View.OnClickListener() {
                                             @Override
                                             public void onClick(View v) {
                                                 soundPool.play(sonido1, 1, 1, 1, 0, 1);
                                             }
                                         });

      btnSoundPool2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick (View v){
                soundPool.play(sonido2, 1, 1, 1, 0, 1);
            }
            });

btnSoundPool3.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                soundPool.play(sonido3, 1, 1, 1, 0, 1);
            }
            } );

btnSoundPool4.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
    soundPool.play(sonido4, 1,1,1,0,1);
}
        });






    }
}
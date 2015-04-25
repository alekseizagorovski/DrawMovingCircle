package ee.alekseizagorovski.drawmovingcircle;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;


public class MainActivity extends Activity {


    private DrawScene drawScene;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);



            SharedPreferences preferences = getPreferences(MODE_PRIVATE);
            int startX = preferences.getInt("start X", 50);
            int startY = preferences.getInt("start Y", 50);

            drawScene = new DrawScene(this, startX, startY);
            setContentView(drawScene);

        }



        @Override
        protected void onStop() {
            super.onStop();


            SharedPreferences preferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("startX", drawScene.getCurrentX());
            editor.putInt("startY", drawScene.getCurrentY());
            editor.commit();

        }
}








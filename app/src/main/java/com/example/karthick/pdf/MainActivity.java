package com.example.karthick.pdf;

import com.joanzapata.pdfview.PDFView;
import com.joanzapata.pdfview.listener.OnPageChangeListener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;


public class MainActivity extends Activity implements OnPageChangeListener {

        private Button btn;
        private PDFView pdfView;

        private Context ctx ;
      /*  private void reinitPdfView(){
                ViewGroup group = (ViewGroup) mPdfView.getParent();
                group.removeView(mPdfView);
                mPdfView = null;
                mPdfView = new PDFView(this, null);
                mPdfView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                group.addView(mPdfView);
        }*/
        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                ctx=this;
                final String pdfName= Environment.getExternalStorageDirectory()+"/m1.pdf";
                setTitle(pdfName);
                ctx = this;
                btn = (Button) findViewById(R.id.button1);

                btn.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                                Log.d("Click", "Clicked");
                                pdfView.fromAsset(pdfName)
                                        .onPageChange((MainActivity)ctx)
                                        .load();
                        }
                });

                pdfView = (PDFView) findViewById(R.id.pdfView);
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menu_main, menu);
                return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();

                //noinspection SimplifiableIfStatement
                if (id == R.id.action_settings) {
                        return true;
                }

                return super.onOptionsItemSelected(item);
        }

        @Override
        public void onPageChanged(int i, int i1) {

        }
}

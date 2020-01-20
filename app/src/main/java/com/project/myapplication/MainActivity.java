package com.project.myapplication;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import static com.project.myapplication.FeedreaderDBHelper.database_version;
import static com.project.myapplication.Readfromphones.rowsizephone;
import static com.project.myapplication.read_from_file_second.rowsizepeople;
import static com.project.myapplication.Readfromcars.rowsizecars;
import static com.project.myapplication.Readfromhomes.rowsizehome;
import static com.project.myapplication.Readfromaccounts.rowsizeaccount;
import static com.project.myapplication.Readfromcalls.rowsizecalls;
import static com.project.myapplication.Readfromtransactions.rowsizetransactions;
import static com.project.myapplication.Readfromownership.rowsizeownership;
import static com.project.myapplication.Readfromrelationships.rowsizerealationships;
public class MainActivity extends AppCompatActivity {
    public static int sizepeople=0;
    public static int sizephone=0;
    public static int sizecars=0;
    public static int sizehome=0;
    public static int sizeaccounts=0;
    public static int sizecalls=0;
    public static int sizetransactions=0;
    public static int sizeownerships=0;
    public static int sizerelationships=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        read_from_file_second.i=0;
        Readfromphones.i=0;
        Readfromcars.i=0;
        Readfromcalls.i=0;
        Readfromtransactions.i=0;
        Readfromrelationships.i=0;
            readfilepeople();
            readfilephones();
            readfilecars();
            readfilehomes();
            readfileaccounts();
            readfilecalls();
            readfiletransactions();
            readfileownerships();
            readfilerelationships();
    }
    public void readfilepeople(){
        read_from_file_second readfromsecond=new read_from_file_second();
        InputStream inputStream = getResources().openRawResource(R.raw.people);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizepeople=5001;
            try {
                bufferedReader.readLine();
                while ( (line = bufferedReader.readLine()) != null) {
                    sizepeople++;
                    line=line.replace('"','*');
                    line=line.replace("*,*","_");
                    line=line.replace("*","_");
                    line=line.replace(',',' ');
                    String [] token=line.split("_");
                    readfromsecond.setFirstname(token[1]);
                    readfromsecond.setLastname(token[2]);
                    readfromsecond.setNationalecode(token[3]);
                    readfromsecond.setBirthday(token[4]);
                    readfromsecond.setCity(token[5]);
                    readfromsecond.setWork(token[6]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
          public void readfilephones(){
          Readfromphones readfromphones=new Readfromphones();
          InputStream inputStream=getResources().openRawResource(R.raw.phones);
              BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
              String line;
              rowsizephone=46;
              try {
                  while ( (line = bufferedReader.readLine()) != null){
                      sizephone++;
                      line=line.replace('"','-');
                      line=line.replace("-","");
                      String [] token=line.split(",");
                      readfromphones.setNationalcodephone(token[0]);
                      readfromphones.setNumber(token[1]);
                      readfromphones.setOperator(token[2]);
                  }
              }
              catch (IOException e){
                  e.printStackTrace();
              }
          }
    public void readfilecars(){
        Readfromcars readfromcars=new Readfromcars();
        InputStream inputStream=getResources().openRawResource(R.raw.cars);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizecars=126;
        try {
            while ( (line = bufferedReader.readLine()) != null){
                sizecars++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromcars.setCar(token[0]);
                readfromcars.setNationalcode(token[1]);
                readfromcars.setPallet(token[2]);
                readfromcars.setColor(token[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfilehomes(){
        Readfromhomes readfromhomes=new Readfromhomes();
        InputStream inputStream=getResources().openRawResource(R.raw.homes);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizehome=91;
        try {
            while ( (line = bufferedReader.readLine()) != null){
                sizehome++;
                line=line.replace('"','-');
                line=line.replace("-,-","_");
                line=line.replace("-","_");
                line=line.replace(',',' ');
                String [] token=line.split("_");
                readfromhomes.setNationalcode(token[1]);
                readfromhomes.setPrice(token[2]);
                readfromhomes.setPostalcode(token[3]);
                readfromhomes.setSize(token[4]);
                readfromhomes.setAddress(token[5]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfileaccounts(){
        Readfromaccounts readfromaccounts=new Readfromaccounts();
        InputStream inputStream=getResources().openRawResource(R.raw.accounts);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizeaccount=191;
        try {
            while ( (line = bufferedReader.readLine()) != null){
                sizeaccounts++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromaccounts.setNationalcodeaccount(token[0]);
                readfromaccounts.setBankname(token[1]);
                readfromaccounts.setSheba(token[2]);
                readfromaccounts.setAccountnumber(token[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfilecalls(){
        Readfromcalls readfromcalls=new Readfromcalls();
        InputStream inputStream=getResources().openRawResource(R.raw.calls);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizecalls=500;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                sizecalls++;

                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromcalls.setFrom(token[0]);
                readfromcalls.setTo(token[1]);
                readfromcalls.setCallID(token[2]);
                readfromcalls.setDate(token[3]);
                readfromcalls.setDuration(token[4]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfiletransactions(){
        Readfromtransactions readfromtransactions=new Readfromtransactions();
        InputStream inputStream=getResources().openRawResource(R.raw.transactions);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizetransactions=10000;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                sizetransactions++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromtransactions.setFrom(token[0]);
                readfromtransactions.setTo(token[1]);
                readfromtransactions.setTransaction_ID(token[2]);
                readfromtransactions.setDate(token[3]);
                readfromtransactions.setAmount(token[4]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfileownerships(){
        Readfromownership readfromownership=new Readfromownership();
        InputStream inputStream=getResources().openRawResource(R.raw.ownerships);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        String line2 = "";
        int salam=0;
        rowsizeownership=12352;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                sizeownerships++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromownership.setFrom(token[0]);
                readfromownership.setTo(token[1]);
                readfromownership.setOwnershipID(token[2]);
                readfromownership.setDate(token[3]);
                token[3]=token[3].replace("-","");
                token[3]=token[3].replace(" ","");
                salam=Integer.parseInt(token[3]);
                salam=2020-salam/10000;
                readfromownership.setdiffdate(salam);
                readfromownership.setAmount(token[4]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readfilerelationships(){
        Readfromrelationships readfromrelationships=new Readfromrelationships();
        InputStream inputStream=getResources().openRawResource(R.raw.relationships);
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,Charset.forName("UTF-8")));
        String line;
        rowsizerealationships=2001;
        try {
            bufferedReader.readLine();
            while ( (line = bufferedReader.readLine()) != null){
                sizerelationships++;
                line=line.replace('"',' ');
                String [] token=line.split(",");
                readfromrelationships.setFrom(token[0]);
                readfromrelationships.setTo(token[1]);
                readfromrelationships.setRelation(token[2]);
                readfromrelationships.setDate(token[3]);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        FeedreaderDBHelper feedreaderDBHelper1=new FeedreaderDBHelper(this);
        SQLiteDatabase db=feedreaderDBHelper1.getWritableDatabase();
    }
    public void confirmbottom(View view) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SubMenu intentSubmenu =  menu.addSubMenu("phase1");
        intentSubmenu.add("phase1").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(MainActivity.this,phase1Activity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}

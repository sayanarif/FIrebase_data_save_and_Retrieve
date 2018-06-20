package com.example.user.nwp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText name,email;
    private Button btn1;
    private ListView mUserlist;
 DatabaseReference databaseReference;

 private ArrayList<String> mUsernames= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.btn1);
        name=(EditText)findViewById(R.id.nameid);
        email=(EditText)findViewById(R.id.emailid) ;
        mUserlist=(ListView)findViewById(R.id.listid);


        final ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mUsernames);
        mUserlist.setAdapter(arrayAdapter);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
             String value=dataSnapshot.getValue(String.class);
             mUsernames.add(value);
             arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void addData(){

        String Name=name.getText().toString().trim();
        String Email=email.getText().toString().trim();
        SaveData saveData= new  SaveData(Name,Email);
        databaseReference.setValue(saveData);
    }

}



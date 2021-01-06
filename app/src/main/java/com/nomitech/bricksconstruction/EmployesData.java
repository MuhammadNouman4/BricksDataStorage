package com.nomitech.bricksconstruction;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EmployesData extends AppCompatActivity {
Button btninsert, btnupdate, btndelete, btnview;

    SQLHelper helper;
EditText edname, edphone, edaddress, edsalary,edid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employes_data);


        btninsert= findViewById(R.id.insertdata);
        btnupdate= findViewById(R.id.updatedata);
        btndelete= findViewById(R.id.deletedata);
        btnview= findViewById(R.id.viewalldata);

        edname= findViewById(R.id.edname);
        edphone=findViewById(R.id.edphone);
        edaddress=findViewById(R.id.edaddress);
        edsalary=findViewById(R.id.edsalary);
        edid=findViewById(R.id.edid);

    helper=new SQLHelper(this);
    adduser();
viewalldata();
updatedata();
deletedata();




    }
    public void deletedata() {
        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer resul = helper.deletedata(edid.getText().toString());
                if (resul > 0)
                    Toast.makeText(EmployesData.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EmployesData.this, "Not Delet Successfully", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void viewalldata() {
        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = helper.ViewAll();
                if (res.getCount() == 0){
                    showdata("error", "nothing found");
                    return;
                }

                StringBuffer buffer=new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("id :"+ res.getString(0)+"\n");
                    buffer.append("name :"+ res.getString(1)+"\n");
                    buffer.append("phone :"+ res.getString(2)+"\n");
                    buffer.append("address :"+ res.getString(3)+"\n");
                    buffer.append("salary :"+ res.getString(4)+"\n\n");
                }
                showdata("Data",buffer.toString());
            }
        });
    }

    private void adduser() {

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               boolean value= helper.InsertData(edname.getText().toString(),
                       edphone.getText().toString(),edaddress.getText().toString(),
                       edsalary.getText().toString());

               if (value == true)
               {
                   Toast.makeText(EmployesData.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
               }
               else
               {
                   Toast.makeText(EmployesData.this, "Data not Insert Successfully", Toast.LENGTH_SHORT).show();
               }
            }
        });
    }
    public  void showdata(String title, String message)
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        builder.setTitle(title);
        builder.setCancelable(true);


        builder.setMessage(message);

        builder.show();
    }
    private void updatedata() {
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result= helper.updatedata(edid.getText().toString(),
                        edname.getText().toString(),
                        edphone.getText().toString(),
                        edaddress.getText().toString(),
                edsalary.getText().toString());


                if (result==true)
                    Toast.makeText(EmployesData.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EmployesData.this, "Not Update Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
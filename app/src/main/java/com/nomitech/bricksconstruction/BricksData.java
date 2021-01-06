package com.nomitech.bricksconstruction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BricksData extends AppCompatActivity {
    Button btninsert, btnupdate, btndelete, btnview;
SQLliteHelper helper1;

    EditText  edquantity, edqprice,edid;
    TextView edqresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bricks_data);

        btninsert= findViewById(R.id.insertdata);
        btnupdate= findViewById(R.id.updatedata);
        btndelete= findViewById(R.id.deletedata);
        btnview= findViewById(R.id.viewalldata);

        edquantity= findViewById(R.id.edquantity);
        edqprice= findViewById(R.id.edqprice);
        edqresult= findViewById(R.id.edqresult);
        edid=findViewById(R.id.edid);

        helper1=new SQLliteHelper(this);
        adduser();
      //  viewalldata();
       // updatedata();
       // deletedata();


        TextWatcher textWatcher=new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!edquantity.getText().toString().equals("") && !edqprice.getText().toString().equals(""))
                {
                    int temp1 = Integer.parseInt(edquantity.getText().toString());
                    int temp2 = Integer.parseInt(edqprice.getText().toString());

                    edqresult.setText(String.valueOf(temp1 * temp2));

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        edquantity.addTextChangedListener(textWatcher);
        edqprice.addTextChangedListener(textWatcher);



    }

    private void adduser() {
        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean value= helper1.Insert(edquantity.getText().toString(),
                        edqprice.getText().toString());

                if (value == true)
                {
                    Toast.makeText(BricksData.this, "Data Insert Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(BricksData.this, "Data not Insert Successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
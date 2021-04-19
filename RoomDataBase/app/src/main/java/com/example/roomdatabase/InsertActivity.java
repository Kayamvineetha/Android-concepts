package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    EditText roll,name,mail,phno;
    RadioButton umale,ufemale;
    CheckBox utel,ueng,uhin;
    Spinner udept;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        roll=findViewById(R.id.et_rollno);
        name=findViewById(R.id.et_name);
        mail=findViewById(R.id.et_mailid);
        phno=findViewById(R.id.et_phoneno);

        umale=findViewById(R.id.male);
        ufemale=findViewById(R.id.female);

        utel=findViewById(R.id.tel);
        ueng=findViewById(R.id.eng);
        uhin=findViewById(R.id.hin);

        udept=findViewById(R.id.dept);
    }

    public void save(View view) {
        String nam=name.getText().toString();
        String mail_id=mail.getText().toString();
        String roll_no=roll.getText().toString();
        String ph_no=phno.getText().toString();


        if(umale.isChecked()) {
            gender = umale.getText().toString();
        }
            if(ufemale.isChecked())
            {
                gender=ufemale.getText().toString();
            }



        StringBuilder sb=new StringBuilder();
        if(utel.isChecked())
        {
            sb.append(utel.getText().toString()+",");
        }
        if(ueng.isChecked())
        {
            sb.append(ueng.getText().toString()+",");
        }
        if(uhin.isChecked())
        {
            sb.append(uhin.getText().toString()+",");
        }


        String department=udept.getSelectedItem().toString();

        /*Toast.makeText(this, nam+"\n"+mail_id+"\n"+ph_no+"\n"+roll_no+"\n"+gender+"\n"+department+"\n"
                +sb.toString(), Toast.LENGTH_SHORT).show();*/

        Student student=new Student();
        student.setName(nam);
        student.setMailId(mail_id);
        student.setPhoneNumber(ph_no);
        student.setRollNumber(roll_no);
        student.setGender(gender);
        student.setLanguage(sb.toString());
        student.setDepartment(department);
        MainActivity.dataBase.myDao().insertStudent(student);
        Toast.makeText(this, "Data Saved Successfully", Toast.LENGTH_SHORT).show();
        finish();
    }
}

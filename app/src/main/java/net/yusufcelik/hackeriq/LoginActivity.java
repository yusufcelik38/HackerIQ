package net.yusufcelik.hackeriq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onClick(View v)
    {
        if(v.getId()==R.id.loginBtn)
        {
            EditText edtUser,editPass;
            edtUser=(EditText)findViewById(R.id.untxt);
            editPass=(EditText)findViewById(R.id.pstxt);

            if(edtUser.getText().toString().isEmpty()||editPass.getText().toString().isEmpty())
            {
                Toast.makeText(LoginActivity.this, "Username or password is not empty!",
                        Toast.LENGTH_SHORT).show();
            }
            else{
                Intent intent = new Intent(LoginActivity.this,
                        CategoryActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        }
        else if(v.getId()==R.id.goRegisterBtn)
        {
            Intent intent = new Intent(LoginActivity.this,
                    RegisterActivity.class);
            startActivity(intent);
        }
    }
}

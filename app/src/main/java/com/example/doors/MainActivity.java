package com.example.doors;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView enter;
    TextView welcome;
    TextView register;
    EditText email;
    EditText password;
    Button signIn;
    TextView tapHere;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter = findViewById(R.id.enter_);
        welcome = findViewById(R.id.tv_welcome);
        register = findViewById(R.id.tv_register);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.enter_ps);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        signIn = findViewById(R.id.btn_signIn);
        tapHere = findViewById(R.id.ps_fg);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                if(email.getText().length() > 0 && password.getText().length() > 0){
                    signIn.setBackgroundResource(R.drawable.bg_orange);
                } else {
                    signIn.setBackgroundResource(R.drawable.bg_grey);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher);

        signIn.setOnClickListener(v -> {
            String username = email.getText().toString();
            String tvpassword = password.getText().toString();
            if("admin".equals(username) && "admin".equals(tvpassword)){
                Toast.makeText(this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                welcome.setText("Добро пожаловать, " + username + "!");

                welcome.setVisibility(View.VISIBLE);
                register.setVisibility(View.GONE);
                tapHere.setVisibility(View.GONE);
                enter.setVisibility(View.GONE);
                email.setVisibility(View.GONE);
                password.setVisibility(View.GONE);
                signIn.setVisibility(View.GONE);
            } else {
                Toast.makeText(this, "Неправильно ввели пароль или логин", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
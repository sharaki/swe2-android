package com.FCI.SWE.SocialNetwork;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.FCI.SWE.Controllers.Application;
import com.FCI.SWE.Controllers.UserController;

public class HomeActivity extends Activity implements View.OnClickListener {

	TextView helloTextView;
    Button searchRequest;
    EditText Edit;
    Button logout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		Bundle extras = getIntent().getExtras();
		String status = extras.getString("status");
		String name = "",welcome="Hello";
        logout = (Button) findViewById(R.id.Logout);
		if(extras.containsKey("name")){
			name = extras.getString("name");
			welcome = "Welcome " + name;
		}
		helloTextView = (TextView) findViewById(R.id.helloText);
		String text = status + " ... " + welcome;
		helloTextView.setText(text);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent logOutIntent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(logOutIntent);

            }
        });


        searchRequest = (Button) findViewById(R.id.sr);
        searchRequest.setOnClickListener(this);
        Edit = (EditText) findViewById(R.id.et);


	}

    @Override
   public void onClick(View view) {
        UserController controller = Application.getUserController();
        controller.searchService(Edit.getText().toString());
    }
}

package net.androidbootcamp.haiquizapp;

        import android.app.ListActivity;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

public class MenuActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] menuList = {"True/False Questions", "Matching Questions", "Multiple Choice"};
        setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_menu, R.id.logo, menuList));
    }

    //onListItemClick method used to make function to move next screen
    protected void onListItemClick(ListView l, View v, int position, long id){
        switch(position){
            case 0:
                //statements that are executed if position==0
                //startActivity makes new Activity, Intent starts its
                startActivity(new Intent(MenuActivity.this, trueFalseActivity.class));
                break;
            case 1:
                //statements that are executed if position==1
                startActivity(new Intent(MenuActivity.this, matchingActivity.class));
                break;
            case 2:
                //statements that are executed if position==2
                startActivity(new Intent(MenuActivity.this, multipleChoice.class));
                break;
        }
    }
}

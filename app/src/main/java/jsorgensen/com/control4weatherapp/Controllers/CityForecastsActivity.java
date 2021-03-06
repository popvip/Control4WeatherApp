package jsorgensen.com.control4weatherapp.Controllers;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import com.androidnetworking.AndroidNetworking;

import jsorgensen.com.control4weatherapp.R;
import jsorgensen.com.control4weatherapp.Views.CityForecastsFragment;

public class CityForecastsActivity extends AppCompatActivity implements CityForecastsFragment.OnFragmentInteractionListener {

    CityForecastsFragment cityForecastsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_forecasts);

        AndroidNetworking.initialize(getApplicationContext());

        cityForecastsFragment = new CityForecastsFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.flPanel, cityForecastsFragment)
                .commit();

        if(savedInstanceState != null){
            cityForecastsFragment.activityState = savedInstanceState.getBundle("cityForecastsFragment");
        }else{
            cityForecastsFragment.requestData = true;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBundle("cityForecastsFragment", cityForecastsFragment.bundleData());

        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.menu_cities);

        return true;
    }

    public void onAddCityClick(View view){
        cityForecastsFragment.onAddCityClick();
    }

    public void onEditCityClick(View view){
        cityForecastsFragment.onEditCityClick();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

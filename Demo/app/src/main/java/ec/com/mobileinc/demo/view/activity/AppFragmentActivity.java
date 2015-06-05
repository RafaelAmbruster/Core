package ec.com.mobileinc.demo.view.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import com.mikepenz.aboutlibraries.Libs;
import com.mikepenz.aboutlibraries.LibsBuilder;
import com.mikepenz.iconics.typeface.FontAwesome;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import ec.com.mobileinc.demo.R;
import ec.com.mobileinc.demo.log.LogManager;
import ec.com.mobileinc.demo.view.fragment.CoreFragment;
import ec.com.mobileinc.demo.view.maps.MapsFragment;

public class AppFragmentActivity extends AppCompatActivity {

    private Drawer result = null;
    private CoreFragment activeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        result = new DrawerBuilder(this)
                .withRootView(R.id.frame_container)
                .withToolbar(toolbar)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_home).withIdentifier(1).withIcon(FontAwesome.Icon.faw_home),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_settings).withIdentifier(2).withIcon(FontAwesome.Icon.faw_cog),
                        new SecondaryDrawerItem().withName(R.string.title_activity_maps).withIdentifier(3).withIcon(FontAwesome.Icon.faw_map_marker),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIdentifier(4).withIcon(FontAwesome.Icon.faw_github),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIdentifier(5).withIcon(FontAwesome.Icon.faw_bullhorn)
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(AdapterView<?> parent, View view, int position, long id, IDrawerItem drawerItem) {
                        LogManager.getInstance().info("Item", drawerItem.getIdentifier() + "");

                        if (drawerItem != null) {
                            Intent intent = null;
                            if (drawerItem.getIdentifier() == 3) {
                                addFragment(new MapsFragment());
                            } else if (drawerItem.getIdentifier() == 4) {
                                intent = new LibsBuilder()
                                        .withFields(R.string.class.getFields())
                                        .withActivityStyle(Libs.ActivityStyle.LIGHT_DARK_TOOLBAR)
                                        .intent(AppFragmentActivity.this);
                            }

                            if (intent != null) {
                                AppFragmentActivity.this.startActivity(intent);
                            }
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .withShowDrawerOnFirstLaunch(true)
                .build();

        if (savedInstanceState == null) {
            result.setSelectionByIdentifier(1, false);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState = result.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed() {
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    public void addFragment(CoreFragment fragment) {

        if (activeFragment != null)
            activeFragment.onPause();

        activeFragment = fragment;

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentLayout, fragment)
                .commitAllowingStateLoss();
    }

}

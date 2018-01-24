package com.example.dell.learnstackdemo;

import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    CoordinatorLayout myLayout;
    DrawerLayout drawerLayout;
    android.support.v7.widget.Toolbar toolbar;

    ArrayList<String> titleDataSet=new ArrayList<String>();
    ArrayList<String> subtitleDataSet=new ArrayList<String>();
    ArrayList<String> emptyDataSet=new ArrayList<String>();
    int[] imageDataSet={R.drawable.abkhazia, R.drawable.afghanistan, R.drawable.albania, R.drawable.algeria, R.drawable.andorra, R.drawable.angola, R.drawable.anguilla, R.drawable.argentina, R.drawable.armenia, R.drawable.aruba, R.drawable.australia, R.drawable.austria, R.drawable.azerbaijan, R.drawable.bahamas, R.drawable.bahrain, R.drawable.bangladesh, R.drawable.barbados, R.drawable.belarus, R.drawable.belgium, R.drawable.belize, R.drawable.benin, R.drawable.bermuda, R.drawable.bhutan, R.drawable.bolivia, R.drawable.bonaire};

    ViewPager course_image_slider;

    RecyclerView course_scroller,working_scroller;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab=(FloatingActionButton)findViewById(R.id.fab);
        myLayout=(CoordinatorLayout) findViewById(R.id.mylayout);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawerlayout);

        course_scroller=(RecyclerView)findViewById(R.id.course_scroller);
        setCourseScroller(course_scroller);

        working_scroller=(RecyclerView)findViewById(R.id.working_scroller);
        setWorkingScroller(working_scroller);

        course_image_slider=(ViewPager)findViewById(R.id.course_image_slider);

        for(int i=1;i<=25;i++){
            titleDataSet.add("Country : "+i);
            subtitleDataSet.add("This country has a very big name and is very difficult to spell");
            emptyDataSet.add("");
        }
        setViewPager(course_image_slider);
        setToolbar();
        setfab();
        setnavigationdrawer();
    }

    private void setWorkingScroller(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new ItemScrollAdapter(titleDataSet,emptyDataSet,imageDataSet);
        recyclerView.setAdapter(adapter);
    }

    private void setCourseScroller(RecyclerView recyclerView) {
        recyclerView.setHasFixedSize(true);

        layoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new CourseScrollAdapter(titleDataSet,subtitleDataSet,imageDataSet);
        recyclerView.setAdapter(adapter);
    }

    private void setViewPager(ViewPager course_image_slider) {
        ImageSliderAdapter imageSliderAdapter=new ImageSliderAdapter(MainActivity.this,imageDataSet);
        course_image_slider.setAdapter(imageSliderAdapter);
    }

    private void setnavigationdrawer() {
        final NavigationView navigationView=(NavigationView)findViewById(R.id.navigationView);
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Toast.makeText(MainActivity.this,item.getTitle(),Toast.LENGTH_LONG).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    private void setfab() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Floating Action Button Clicked",Toast.LENGTH_LONG).show();
                Snackbar.make(myLayout,"Grenade",Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void setToolbar() {
        toolbar=(android.support.v7.widget.Toolbar)findViewById(R.id.toolbar);
        toolbar.setTitle("Learnstack");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new android.support.v7.widget.Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Snackbar.make(myLayout,item.getTitle()+" Selected",Snackbar.LENGTH_SHORT).show();
                if(item.getItemId()==R.id.delete){
                    Snackbar snackbar=Snackbar.make(myLayout,"File Delete SuccessFully",Snackbar.LENGTH_LONG);
                    snackbar.setAction("Undo", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar.make(myLayout,"File Recovered Successfully",Snackbar.LENGTH_SHORT).show();
                        }
                    });
                    snackbar.show();
                }
                return true;

            }
        });
    }
}

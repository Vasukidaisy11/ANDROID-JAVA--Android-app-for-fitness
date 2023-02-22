package com.example.tall_as_giraffe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    GridView gridExercises;
    String[] exercises_names = {"Bar hanging","Cobra stretch","Calf stretch","Tree pose","Forward spine stretch","Cycling stretch","Forward bend","Wall stretch","Locust pose","Swimming","Rope Skipping","Side planks","Camel pose","Pilates roll over","Jump squates"};
    String[] exercises_description = {"BAR HANGING:\n\n--> Muscles will be stretched out by hanging with the assistance of your hands. \n--> Maintain a straight spine and arms. \n--> Hold the posture for 30 seconds.", "COBRA STRETCH: \n\n--> This exercise is excellent for extending your abdominal and is one of the finest stretches for taller people.\n--> Extend your arms and lift your head toward the ceiling, arching your back as much as you can.\n-->  For 30 seconds, maintain this posture while releasing. "," CALF STRETCH: \n\n--> By performing the Calf Stretch, you may lengthen your calf and back muscles, \n--> Strengthen your back and core muscles, and gain height. \n--> Stretch as much as you can while resting against the wall with both arms at the wall and pushing your left leg backwards.", " TREE POSE: \n\n--> This exercise strengthens your back and core muscles, \n--> Enhances posture and balance, and lengthens your spine to give you more height. \n-->  While standing on your left foot, connect your palms together and raise both arms over your head without bending your elbows.", " FORWARD SPINE STRETCH: \n\n--> This workout aims to strengthen the back, hamstrings, and abs. \n--> From the base of your spine, sit as tall as you can. \n--> To use your leg muscles, extend your arms and grasp through your heels.", " CYCLING: \n\n--> The ideal workout for adolescents to extend their legs and gain a few inches on their bodies is cycling." , " FORWARD BEND: \n\n--> Stretching your legs while sitting on the ground and bending forward to attempt to grab your toes with your hands.\n-->  Maintaining a straight spine, attempt to lay your head on your knees now."," WALL STRETCH: \n\n--> Stretching against a wall can increase flexibility.\n--> Hold on for 20–30 seconds with each stretch.\n--> Complete a total of two to three sets.\n--> Spend a little more time there or do an additional set if it's really constricting."," LOCUST POSE: \n\n--> This exercise strengthens your back while stretching your back muscles and improving spinal mobility.\n--> Exhale while stretching your lower back, bringing your navel in toward your spinal curve, and softly pressing your pubic bone into the floor."," SWIMMING: \n\n--> Swimming is a height-increasing workout that allows you to fully utilise your legs, body, and arms while also building muscular strength."," ROPE SKIPPING:\n\n--> One of those things is jumping.\n-->  The more times you leap, the more likely it is that your legs will get longer.\n--> Make sure both of your legs leave the ground simultaneously and land on it simultaneously as you leap."," SIDE PLANKS: \n\n--> Your legs will get a decent stretch with side planks, which will help them become thinner and taller. \n--> Lay on your right side with your shoulder level with your neck.\n-->  Your left hand should be on your left hip as you extend your legs straight."," CAMEL POSE: \n\n--> One of the best workouts for quickly becoming taller is the camel pose. \n--> Stretching your chest and belly while bending your neck backwards is the goal of this posture.\n--> The stance is excellent for improving posture, strengthening back muscles, and stretching the deep hip flexors.", " PILATES ROLL OVER: \n\n--> This is one of the finest workouts for height gain since it works ligaments, muscles, and bones. \n--> The rollover exercise in pilates is ideal for people of all ages and is much more beneficial than the regular version of this exercise since it stretches out your spine. \n--> Stretch your legs behind you and up until they are parallel to the ground."," JUMP SQUATS:\n\n--> The greatest workouts for height gain involve jumping, such as jump squats.\n--> It helps to increase body height and promotes the conditioning of the lower body's muscles and joints."};
    int[] exercises_images = {R.drawable.bar_hanging,R.drawable.cobra_stretch,R.drawable.calf_stretch,R.drawable.tree_pose,R.drawable.forward_spinr_stretch,R.drawable.cycling,R.drawable.forward_bend,R.drawable.wall_stretch,R.drawable.locust_pose,R.drawable.swimming,R.drawable.rope_skipping,R.drawable.side_planks,R.drawable.camel_pose,R.drawable.pilates_roll_over,R.drawable.jump_squats};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridExercises = findViewById(R.id.gridExercises);

        CustomAdapter customAdapter = new CustomAdapter(exercises_names,exercises_images,this) ;

        gridExercises.setAdapter(customAdapter);
        gridExercises.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView,View view, int i, long l){
                String clickExercises = exercises_description[i];
                int clickImages = exercises_images[i];
                startActivity(new Intent(MainActivity.this,Activity1.class).putExtra("description",clickExercises).putExtra("image",clickImages));
            }
        });
    }

    public class CustomAdapter extends BaseAdapter{
        private String[] exercisesNames;
        private int[] exercisesImages;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] exercisesNames, int[] exercisesImages, Context context) {
            this.exercisesNames = exercisesNames;
            this.exercisesImages = exercisesImages;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return exercisesImages.length;
        }
        @Override
        public Object getItem(int i){
            return null;
        }

        @Override
        public long getItemId(int i){
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){
            if(view == null){
                view = layoutInflater.inflate(R.layout.list_exercises, viewGroup, false);
            }
            TextView name = view.findViewById(R.id.exercisesName);
            ImageView imageview = view.findViewById(R.id.image);

            name.setText(exercisesNames[i]);
            imageview.setImageResource(exercisesImages[i]);

            return view;
        }
    }
}
package csci490.videogametrivia;
import android.annotation.SuppressLint;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

import csci490.videogametrivia.R;
import csci490.videogametrivia.UsernameScreen;

public class StoryActivity extends Activity {
    private ImageSwitcher sw;
    private ImageSwitcher sw1;
    private ImageSwitcher sw2;
    private TextView ed;
    public ArrayList<String> actionArray;
    public ArrayList<String> storyArray;
    public ArrayList<String> mmoArray;
    public ArrayList<Integer> mmoImages;
    public ArrayList<Integer> storyImages;
    public ArrayList<Integer> actionImages;
    public ArrayList<ArrayList<String>> categories;

    public RadioGroup radioGroup;

    public ArrayList wrong;

    public Problem2 problem;

    public int scoreCounter;
    public int storyArrayCounter;
    public int imageCounter;

    private RadioButton radio1;
    private RadioButton radio2;
    private RadioButton radio3;
    private RadioButton radio4;

    private Button answer;
    public TextView score;
    public TextView time;

    public String string;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_activity);

        actionArray = new ArrayList();
        actionArray.add("Aloy");
        actionArray.add("Tetra");
        actionArray.add("Master Chief");
        actionArray.add("Laura Croft");
        actionArray.add("Booker");
        actionArray.add("Link");
        actionArray.add("Dovakiin");
        actionArray.add("Misty");
        actionArray.add("Jack");
        actionArray.add("Cortana");
        actionArray.add("Tali");

        storyArray = new ArrayList<>();
        storyArray.add("Cloud");
        storyArray.add("Roxas");
        storyArray.add("Titus");
        storyArray.add("Ellie");
        storyArray.add("Axel");
        storyArray.add("Chloe");
        storyArray.add("Red");
        storyArray.add("Bigby");
        storyArray.add("Faith");
        storyArray.add("Gordon Freeman");
        storyArray.add("Ike");

        mmoArray = new ArrayList<String>();
        mmoArray.add("Jinx");
        mmoArray.add("Garen");
        mmoArray.add("Tracer");
        mmoArray.add("Mercy");
        mmoArray.add("Arthus");
        mmoArray.add("Kerrigan");
        mmoArray.add("Drow");
        mmoArray.add("Bellona");
        mmoArray.add("Revan");
        mmoArray.add("Cayde 6");
        mmoArray.add("Hanzo");

        categories = new ArrayList<ArrayList<String>>();
        categories.add(actionArray);
        categories.add(storyArray);
        categories.add(mmoArray);

        actionImages = new ArrayList();
        actionImages.add(R.drawable.aloy);
        actionImages.add(R.drawable.tetra);
        actionImages.add(R.drawable.master);
        actionImages.add(R.drawable.traiangle);
        actionImages.add(R.drawable.booker);
        actionImages.add(R.drawable.link);
        actionImages.add(R.drawable.dovahkiin);
        actionImages.add(R.drawable.misty);
        actionImages.add(R.drawable.jack);
        actionImages.add(R.drawable.cortana);
        actionImages.add(R.drawable.tali);

        storyImages = new ArrayList();
        storyImages.add(R.drawable.cloud);
        storyImages.add(R.drawable.roxas);
        storyImages.add(R.drawable.tidus);
        storyImages.add(R.drawable.ellie);
        storyImages.add(R.drawable.axel);
        storyImages.add(R.drawable.chloe);
        storyImages.add(R.drawable.red);
        storyImages.add(R.drawable.bigby);
        storyImages.add(R.drawable.faith);
        storyImages.add(R.drawable.gordon);
        storyImages.add(R.drawable.ike);

        mmoImages = new ArrayList();
        mmoImages.add(R.drawable.jinx);
        mmoImages.add(R.drawable.garen);
        mmoImages.add(R.drawable.tracer);
        mmoImages.add(R.drawable.mercyz);
        mmoImages.add(R.drawable.arthas);
        mmoImages.add(R.drawable.kerrigan);
        mmoImages.add(R.drawable.drow);
        mmoImages.add(R.drawable.bellona);
        mmoImages.add(R.drawable.reven);
        mmoImages.add(R.drawable.cayde);
        mmoImages.add(R.drawable.hanzo);

        radioGroup = findViewById(R.id.radioGroup);
        answer = findViewById(R.id.button);
        scoreCounter = 0;

        storyArrayCounter = 0;

        wrong = new ArrayList();

        score = (TextView)findViewById(R.id.textView3);

        problem = new Problem2();

        //actionArrayCounter = problem.getImage(2);
        // score.setText(String.valueOf(actionArrayCounter));

        //imageCounter = 0;

        problem.generateAnswers(1, storyArray.get(storyArrayCounter), categories );

        radio1 = findViewById(R.id.radioButton1);
        radio2 = findViewById(R.id.radioButton2);
        radio3 = findViewById(R.id.radioButton3);
        radio4 = findViewById(R.id.radioButton4);

        wrong = problem.retrieveAnswers();

        radio1.setText((CharSequence) wrong.get(0));
        radio2.setText((CharSequence) wrong.get(1));
        radio3.setText((CharSequence) wrong.get(2));
        radio4.setText((CharSequence) wrong.get(3));

        answer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(radio1.getText().equals(storyArray.get(storyArrayCounter)))
                {
                    if (radio1.isChecked())
                    {
                        scoreCounter += 10;
                    }
                }

                else if(radio2.getText().equals(storyArray.get(storyArrayCounter)))
                {
                    if (radio2.isChecked())
                    {
                        scoreCounter += 10;
                    }
                }

                else if(radio3.getText().equals(storyArray.get(storyArrayCounter)))
                {
                    if (radio3.isChecked())
                    {
                        scoreCounter += 10;
                    }
                }

                else if (radio4.getText().equals(storyArray.get(storyArrayCounter)))
                {
                    if (radio4.isChecked())
                    {
                        scoreCounter += 10;
                    }
                }
                score.setText(String.valueOf(scoreCounter));

                storyArrayCounter += 1;
                score.setText(String.valueOf(scoreCounter));

                //imageCounter += 1;

                if(storyArrayCounter > 9)
                {
                    Intent intent = new Intent(getApplicationContext(), UsernameScreen.class);
                    intent.putExtra("score", scoreCounter);
                    startActivity(intent);
                }

                else if (storyArrayCounter <= 9)
                {
                    problem.generateAnswers(1, storyArray.get(storyArrayCounter), categories);
                    sw.setImageResource(storyImages.get(storyArrayCounter));

                    wrong = problem.retrieveAnswers();

                    radio1.setText((CharSequence) wrong.get(0));
                    radio2.setText((CharSequence) wrong.get(1));
                    radio3.setText((CharSequence) wrong.get(2));
                    radio4.setText((CharSequence) wrong.get(3));
                }
            }
        });

        sw = findViewById(R.id.imageSwitcher);
        sw1 = findViewById(R.id.imageSwitcher1);
        sw2 = findViewById(R.id.imageSwitcher2);

        sw.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        sw.setImageResource(R.drawable.cloud);

        sw1.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        // sw1.setImageResource(R.drawable.black_square);

        sw2.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        // sw2.setImageResource(R.drawable.black_square);

    }
    private void reset()
    {
        sw1.setImageResource(R.drawable.black_square);
        sw2.setImageResource(R.drawable.black_square);
    }

    public class Problem2 {
        //private Image image;
        public String rightAnswer;
        public String[] wrongAnswers;
        //private Database db;
        public Random rand = new Random();
        public ArrayList<Integer> flipped;

        private ArrayList<Integer> shown;

        public Problem2() {
            rand = new Random();
        }

        private Problem2(String[] answers) {
            rightAnswer = answers[0];
            wrongAnswers = new String[]{answers[1], answers[2], answers[3]};
            flipped = new ArrayList<Integer>();
            shown = new ArrayList<Integer>();
            rand = new Random();
        }

        public void generateAnswers(int category, String correct, ArrayList<ArrayList<String>> categories)
        {
            rightAnswer = correct;

            boolean found = false;
            String incorrectAnswer = null;
            ArrayList<String> thisCat = categories.get(category);
            String holder;
            flipped = new ArrayList<Integer>();

            do
            {
                int index = rand.nextInt(categories.get(category).size());
                holder = thisCat.get(index);
                if(holder != rightAnswer)
                {
                    incorrectAnswer = holder;
                    found = true;
                }
            }while(!found);

            found = false;
            String otherAnswer = null;
            ArrayList<String> thatCat;
            holder = null;
            do
            {
                int in = rand.nextInt(categories.size());
                int dex = rand.nextInt(categories.size());
                thatCat = categories.get(in);
                if(thatCat != thisCat)
                {
                    holder = thatCat.get(dex);
                    otherAnswer = holder;
                    found = true;
                }
            }while(!found);

            found = false;
            String randomAnswer = null;
            ArrayList<String> randomCat;
            holder = null;
            do
            {
                int in = rand.nextInt(categories.size());
                int dex = rand.nextInt(categories.size());
                randomCat = categories.get(in);
                holder = randomCat.get(dex);
                if(holder != rightAnswer && holder != otherAnswer && holder != incorrectAnswer)
                {
                    randomAnswer = holder;
                    found = true;
                }
            }
            while(!found);
            wrongAnswers = new String[] {incorrectAnswer,otherAnswer,randomAnswer};
        }

        public ArrayList<String> retrieveAnswers()
        {
            int first = rand.nextInt(4);
            int second = rand.nextInt(3);
            int third = rand.nextInt(2);

            ArrayList<String> holder = new ArrayList<String>();
            holder.add(rightAnswer);
            holder.add(wrongAnswers[0]);
            holder.add(wrongAnswers[1]);
            holder.add(wrongAnswers[2]);

            ArrayList<String> rtn = new ArrayList<String>();

            rtn.add(holder.get(first));
            holder.remove(first);

            rtn.add(holder.get(second));
            holder.remove(second);

            rtn.add(holder.get(third));
            holder.remove(third);

            rtn.add(holder.get(0));

            return rtn;

        }

        public int flipCard()
        {
            boolean found = false;
            int i;
            do{
                i = rand.nextInt(3);
                if(!flipped.contains(i))
                {
                    found = true;
                }
            }
            while(!found);
            flipped.add(i);
            return i;
        }

        public int getImage(int size)
        {
            boolean found;
            int index;
            do
            {
                index = rand.nextInt(size);
                found = false;
                if(!shown.contains(index))
                {
                    found = true;
                }
            }
            while(!found);
            shown.add(index);
            return index;
        }


        public String getRightAnswer()
        {
            return rightAnswer;
        }

        public String[] getWrongAnswers()
        {
            return wrongAnswers;
        }


        public String toString() {
            String output = "The right answer is: " + rightAnswer + "\n";
            output += "The wrong answers are: ";
            for (String a : wrongAnswers) {
                output += a + ", ";
            }
            return output;
        }
    }
}

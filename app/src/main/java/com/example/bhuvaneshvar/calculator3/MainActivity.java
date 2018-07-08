package com.example.bhuvaneshvar.calculator3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
   private Button onee, two, three ,four,five,six,seven,eight,nine,plus,minus,multip,devide,percen,zero,dot,clear,equal,factorial;
   private TextView info,result;
   private final char ADD = '+';
    private final char DIV = '/';
    private final char MUL = '*';
    private final char MIN = '-';
    private final char PER = '%';
    private final char EQUAL = '=';
    private double val1 = Double.NaN;// for preventing error and accessing second argument
    private double val2;
    private char action;// for holding user action like multiply etc

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlayout();
        // concat the value
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+"0");
            }
        });
        onee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                info.setText(info.getText()+"9");
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if ((info.getText().toString().contains(".")))
                    return;
                else
                {
                    info.setText(info.getText().toString()+".0");
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0)
                {
                    CharSequence chr = info.getText().toString();
                    info.setText(chr.subSequence(0,chr.length()-1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    result.setText(null);
                    info.setText(null);
                }
            }
        });

        // plus button
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                MainActivity ne = new MainActivity();
                if((info.getText().toString())=="")
                {
                    Toast.makeText(MainActivity.this,"Enter Number ",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    methods();
                    action = ADD;
                    result.setText(String.valueOf(val1) + " + ");
                    info.setText(null);
                }
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((info.getText().toString())=="")
                {
                    Toast.makeText(MainActivity.this,"Enter Number ",Toast.LENGTH_SHORT).show();
                    return;
                }
                methods();
                action = MIN;
                result.setText(String.valueOf(val1)+" - ");
                info.setText(null);
            }
        });
        multip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((info.getText().toString())=="")
                {
                    Toast.makeText(MainActivity.this,"Enter Number ",Toast.LENGTH_SHORT).show();
                    return;
                }
                methods();
                action = MUL;
                result.setText(String.valueOf(val1)+" * ");
                info.setText(null);

            }
        });
        devide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((info.getText().toString())=="")
                {
                    Toast.makeText(MainActivity.this,"Enter Number ",Toast.LENGTH_SHORT).show();
                    return;
                }
                methods();
                action = DIV;
                result.setText(String.valueOf(val1)+" / ");
                info.setText(null);

            }
        });
        percen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((info.getText().toString())=="")
                {
                    Toast.makeText(MainActivity.this,"Enter Number ",Toast.LENGTH_SHORT).show();
                    return;
                }
                methods();
                action = PER;
                result.setText(String.valueOf(val1)+String.valueOf(" % "));
                info.setText(null);

            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((info.getText().toString())=="")
                {
                    Toast.makeText(MainActivity.this,"Enter Number ",Toast.LENGTH_SHORT).show();
                    return;
                }
                methods();
                action = EQUAL;
                result.setText(result.getText().toString() + String.valueOf(val2) + " = " + String.valueOf(val1));
                info.setText(null);
            }
        });

        //factorial
        factorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((info.getText().toString())=="")
                {
                    Toast.makeText(MainActivity.this,"Enter Number ",Toast.LENGTH_SHORT).show();
                    return;
                }
                long temp=1;
                    long fact;
                     fact =(Long.parseLong(info.getText().toString()));
                     if (fact<=0)
                     {
                         result.setText(String.valueOf(1));
                         info.setText(null);
                         return;
                     }
                    while(fact>=1)
                    {
                        temp = temp*fact;
                        fact=fact-1;
                    }
                    result.setText(info.getText().toString()+"!  = "+String.valueOf(temp));
                    info.setText(null);
            }
        });

    }
    public void exit(View view)
    {
        val1 = Double.NaN;
        val2 = Double.NaN;
        result.setText(null);
        info.setText(null);

    }
    public void btnlayout()
    {
        zero = (Button)findViewById(R.id.val0);
        onee =(Button)findViewById(R.id.val1);
        two = (Button)findViewById(R.id.val2);
        three = (Button)findViewById(R.id.val3);
        four = (Button)findViewById(R.id.val4);
        five = (Button)findViewById(R.id.val5);
        six = (Button)findViewById(R.id.val6);
        seven = (Button)findViewById(R.id.val7);
        eight = (Button)findViewById(R.id.val8);
        nine = (Button)findViewById(R.id.val9);
        plus = (Button)findViewById(R.id.sum);
        minus = (Button)findViewById(R.id.sub);
        multip = (Button)findViewById(R.id.mul);
        devide = (Button)findViewById(R.id.div);
        percen = (Button)findViewById(R.id.per);
        dot = (Button)findViewById(R.id.dot);
        info = (TextView)findViewById(R.id.control);//niche
        result = (TextView)findViewById(R.id.result);//upr
        clear = (Button)findViewById(R.id.clear);//clear all entry
        equal = (Button)findViewById(R.id.equal);// equals
        factorial = (Button)findViewById(R.id.factorial);//factorial
    }

    private void methods()
    {
        //double  a;
        if(!Double.isNaN(val1))
        {
            val2=Double.parseDouble(info.getText().toString());
                switch (action) {
                    case ADD:
                        val1 = val1 + val2;
                        break;
                    case MIN:
                        val1 = val1 - val2;
                        break;
                    case MUL:
                        val1 = val1 * val2;
                        break;
                    case DIV:
                        if (val2 == 0) {
                            Toast.makeText(MainActivity.this, "Can not divide by zero", Toast.LENGTH_LONG).show();
                            return;
                        } else
                            val1 = val1 / val2;
                        break;
                    case PER:
                        val1 = (val1 * 100) / val2;
                        break;
                    case EQUAL:
                        break;
                    default:
                        break;

                }
            }

        else
        {
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}

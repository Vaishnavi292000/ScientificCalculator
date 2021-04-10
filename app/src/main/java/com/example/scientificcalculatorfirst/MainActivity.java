package com.example.scientificcalculatorfirst;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    HorizontalScrollView hzw;
    TextView values, result;
    Double val1 = 0.0, val2 = 0.0;
    String sign;
    TextView backspace;
    boolean hasdot = false;
    DecimalFormat df = new DecimalFormat("#.#######");
    BigDecimal bd;
    Animation animSlideup;
    int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        values = findViewById(R.id.value);
        result = findViewById(R.id.result);
        backspace = findViewById(R.id.backspace);
        df.setRoundingMode(RoundingMode.CEILING);
        hzw = findViewById(R.id.hzw);

        // load the animation
        animSlideup = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (values.getText().length() > 0)
                    values.setText(values.getText().subSequence(0, values.getText().length() - 1));
            }
        });

        backspace.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                result.startAnimation(animSlideup);
                values.startAnimation(animSlideup);
                values.setText("");
                result.setText("");
                return true;
            }
        });

    }

    public void getFocus() {
        hzw.post(new Runnable() {
            @Override
            public void run() {
                hzw.fullScroll(View.FOCUS_RIGHT);
            }
        });
    }

    public void txt_0(View view) {

        values.setText(values.getText().toString() + "0");
        getFocus();
    }

    public void txt_1(View view) {
        values.setText(values.getText().toString() + "1");
        getFocus();
    }

    public void txt_2(View view) {
        values.setText(values.getText().toString() + "2");
        getFocus();
    }

    public void txt_3(View view) {
        values.setText(values.getText().toString() + "3");
        getFocus();
    }

    public void txt_4(View view) {
        values.setText(values.getText().toString() + "4");
        getFocus();
    }

    public void txt_5(View view) {
        values.setText(values.getText().toString() + "5");
        getFocus();
    }

    public void txt_6(View view) {
        values.setText(values.getText().toString() + "6");
        getFocus();
    }

    public void txt_7(View view) {
        values.setText(values.getText().toString() + "7");
        getFocus();
    }

    public void txt_8(View view) {
        values.setText(values.getText().toString() + "8");
        getFocus();
    }

    public void txt_9(View view) {
        values.setText(values.getText().toString() + "9");
        getFocus();
    }

    public void add(View view) {
        sign = "expression";
        hasdot = false;
        values.setText(values.getText().toString() + "+");
        getFocus();
    }

    public void sub(View view) {
        sign = "expression";
        hasdot = false;
        values.setText(values.getText().toString() + "-");
        getFocus();
    }

    public void multiply(View view) {
        sign = "expression";
        hasdot = false;
        values.setText(values.getText().toString() + "*");
        getFocus();
    }

    public void divide(View view) {
        sign = "expression";
        hasdot = false;
        values.setText(values.getText().toString() + "/");
        getFocus();
    }

    public void plusminus(View view) {
        if (values.getText().length() > 0) {
            int val = Integer.parseInt(values.getText().toString());
            hasdot = false;
            values.setText(((-1) * val) + "");
            getFocus();
        }

    }


    public void root(View view) {
        try {
            val1 = Double.parseDouble(values.getText().toString());
            sign = "root";
            values.setText("\u221a" + values.getText().toString());
            getFocus();
        } catch (Exception e) {
            result.setHint("0");
            values.setHint("0");
        }

    }

    public void nthroot(View view) {
        try {
            val1 = Double.parseDouble(values.getText().toString());
            sign = "nthroot";
            values.setText(values.getText().toString() + " √");
            getFocus();
        } catch (Exception e) {
            result.setHint("0");
            values.setHint("0");
        }
    }

    public void power(View view) {
        if (values.getText().length()>0)
        {
            sign = "expression";
            values.setText(values.getText().toString() + "^");
            getFocus();
        }
        else {
            result.setHint("0");
            values.setHint("0");
        }

    }

    public void factorial(View view) {
        try {
            val1 = Double.parseDouble(values.getText().toString());
            sign = "!";
            values.setText(values.getText().toString() + "!");
            getFocus();
        } catch (Exception e) {
            result.setHint("0");
            values.setHint("0");
        }
    }

    public void sin(View view) {
        sign = "expression";
        flag++;
        values.setText(values.getText().toString() + "sin(");
        getFocus();
    }

    public void cos(View view) {
        sign = "expression";
        flag++;
        values.setText(values.getText().toString() + "cos(");
        getFocus();
    }

    public void tan(View view) {
        sign = "expression";
        flag++;
        values.setText(values.getText().toString() + "tan(");
        getFocus();
    }

    public void sinh(View view) {
        sign = "expression";
        flag++;
        values.setText(values.getText().toString() + "sinh(");
        getFocus();
    }

    public void cosh(View view) {
        sign = "expression";
        flag++;
        values.setText(values.getText().toString() + "cosh(");
        getFocus();
    }

    public void tanh(View view) {
        sign = "expression";
        flag++;
        values.setText(values.getText().toString() + "tanh(");
        getFocus();
    }

    public void percent(View view) {
        try {
            val1 = Double.parseDouble(values.getText().toString());
            sign = "%";
            values.setText(values.getText() + " %");
            getFocus();
        } catch (Exception e) {
            result.setHint("0");
            values.setHint("0");
        }


    }

    public void onebyx(View view) {
        try {
            val1 = Double.parseDouble(values.getText().toString());
            result.setText(df.format(1.0 / val1));
            values.setText("");
            getFocus();
        } catch (Exception e) {
            result.setHint("0");
            values.setHint("0");
        }

    }

    public void log(View view) {
        sign = "expression";
        flag++;
        values.setText(values.getText().toString() + "log10(");
        getFocus();

    }

    public void bracopen(View view) {
        flag++;
        values.setText(values.getText().toString() + "(");
        getFocus();
    }

    public void bracclose(View view) {
        if (flag!=0)
        {
            flag--;
            values.setText(values.getText().toString() + ")");
            getFocus();
        }
    }

    public void ln(View view) {
        sign = "expression";
        flag++;
        values.setText(values.getText().toString() + "log(");
        getFocus();
    }

    public void dot(View view) {
        if (values.getText().length() < 1) {
            hasdot = true;
            values.setText("0.");

        } else if (values.getText().length() > 0 && !hasdot) {
            hasdot = true;
            values.setText(values.getText().toString() + ".");
        }
        getFocus();
    }

    public void pi(View view) {
        sign = "expression";
        if (values.getText().length() < 1) {
            values.setText("3.1415926");
        } else {
            values.setText(values.getText() + "3.1415926");
        }
        getFocus();
    }

    public void expo(View view) {
        sign = "expression";
        if (values.getText().length() < 1) {
            values.setText("2.71828182");
        } else {
            values.setText(values.getText() + "2.71828182");
        }
        getFocus();
    }

    public void bin(View view) {
        try {
            result.setText(Integer.toBinaryString(Integer.parseInt(values.getText().toString())));
            values.setText("");
            getFocus();
        } catch (Exception e) {
            result.setHint("0");
            values.setHint("0");
        }

    }

    public void hex(View view) {
        try {
            result.setText(Integer.toHexString(Integer.parseInt(values.getText().toString())));
            values.setText("");
            getFocus();
        } catch (Exception e) {
            result.setHint("0");
            values.setHint("0");
        }

    }

    public void oct(View view) {
        try {
            result.setText(Integer.toOctalString(Integer.parseInt(values.getText().toString())));
            values.setText("");
            getFocus();
        } catch (Exception e) {
            result.setHint("0");
            values.setHint("0");
        }

    }

    @SuppressLint("ResourceAsColor")
    public void equals(View view) {
        hasdot = false;
        while(flag>0)
        {
            bracclose(values.getRootView());
        }
        if (sign == null) {
            result.setText(values.getText().toString());
            values.setText("");
        } else {
            switch (sign) {
                case "root":
                    result.setText(df.format(Math.sqrt(val1)) + "");
                    values.setText("");
                    sign = null;
                    break;
                case "!":
                    Double res = 1.0;
                    while (val1 > 0) {
                        res = res * val1;
                        val1--;
                    }
                    result.setText(res + "");
                    values.setText("");
                    sign = null;
                    break;
                case "%":
                    result.setText((val1 / 100.0) + "");
                    values.setText("");
                    sign = null;
                    break;
                case "nthroot":
                    int x=values.getText().toString().indexOf("√");
                    String s=values.getText().subSequence(x+1,values.getText().length()).toString();
                    val2 = Double.parseDouble(s);
                    int count = 0, prod = 1;
                    for (int i = 1; i <= val2 / val1; i++) {
                        int j = 1;
                        while (j <= val1) {
                            prod = prod * i;
                            j++;
                        }
                        if (prod == val2) {
                            result.setText(i + "");
                            values.setText("");
                            count++;
                            break;
                        }
                        prod = 1;
                    }
                    if (count == 0) {
                        result.setText("");
                        values.setText("");
                        result.setHint("0");
                        values.setHint("0");
                    }
                    break;
                case "expression":
                    try {
                        Expression expression = new ExpressionBuilder(values.getText().toString()).build();
                        double res1 = expression.evaluate();
                        bd=new BigDecimal(res1);
                        Log.d("expres",bd.longValue()+"");
                        result.setText(bd.doubleValue()+"");
                        values.setText("");
                        sign = null;
                    } catch (Exception e) {
                        result.setHint("0");
                        values.setHint("0");
                    }
                    break;
            }
        }

    }

}
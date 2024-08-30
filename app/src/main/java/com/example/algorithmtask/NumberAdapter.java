package com.example.algorithmtask;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

public class NumberAdapter extends BaseAdapter {

    private Context context;
    private int[][] numbers;
    private NumberType currentType = null;

    public NumberAdapter(Context context, int[][] numbers) {
        this.context = context;
        this.numbers = numbers;
    }

    @Override
    public int getCount() {
        return numbers.length * numbers[0].length;
    }

    @Override
    public Object getItem(int position) {
        int row = position / numbers.length;
        int col = position % numbers[0].length;
        return numbers[row][col];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView;


        if (convertView == null) {
            textView = new TextView(context);
            textView.setLayoutParams(new GridView.LayoutParams(85, 85));
            textView.setGravity(Gravity.CENTER);

        } else {
            textView = (TextView) convertView;

        }

        int number = (int) getItem(position);
        textView.setText(String.valueOf(number));



        if (currentType != null && shouldHighlight(number)) {
            textView.setBackgroundColor(Color.YELLOW);
            textView.setTextColor(Color.BLACK);
        } else {
            textView.setBackgroundColor(Color.TRANSPARENT);
            textView.setTextColor(Color.WHITE);
        }

        return textView;
    }

    public void highlightNumbers(NumberType type) {
        currentType = type;
        notifyDataSetChanged();
    }

    private boolean shouldHighlight(int number) {
        if (currentType == null) return false;

        switch (currentType) {
            case ODD:
                return number % 2 != 0;
            case EVEN:
                return number % 2 == 0;
            case PRIME:
                return isPrime(number);
            case FIBONACCI:
                return isFibonacci(number);
            default:
                return false;
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private boolean isFibonacci(int num) {
        int a = 0, b = 1;
        while (b < num) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        return b == num || num == 0;
    }
}

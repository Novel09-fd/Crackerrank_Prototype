package com.novel.crackerrank_prototype.codeview;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;

import java.util.Objects;

public class CodeView extends androidx.appcompat.widget.AppCompatEditText {
    private Rect rect;
    private Paint paint;

    public CodeView(Context context) {
        super(context);
        init();
    }

    public CodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CodeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        rect = new Rect();
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GRAY);
        paint.setTextSize(35);
        paint.setTypeface(Typeface.MONOSPACE);
    }


    @Override
    protected void onDraw(Canvas canvas) {

        int baseline;
        int lineCount = getLineCount();
        int lineNumber = 1;

        for (int i = 0; i < lineCount; ++i) {
            baseline = getLineBounds(i, null);
            if (i == 0) {
                canvas.drawText("" + lineNumber, rect.left, baseline, paint);
                ++lineNumber;
            } else if (Objects.requireNonNull(getText()).charAt(getLayout().getLineStart(i) - 1) == '\n') {
                canvas.drawText("" + lineNumber, rect.left, baseline, paint);
                ++lineNumber;
            }
        }
// for setting edittext start padding
        if (lineCount < 100) {
            setPadding(45, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        } else if (lineCount < 1000) {
            setPadding(63, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        } else if (lineCount < 10000) {
            setPadding(73, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        } else if (lineCount < 100000) {
            setPadding(83, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }

        super.onDraw(canvas);
    }
}

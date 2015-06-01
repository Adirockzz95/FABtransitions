package adik.fabtransitions;

import android.content.Context;
import android.util.AttributeSet;

import java.util.jar.Attributes;

import io.codetail.widget.RevealLinearLayout;


public class MorphLinearLayout  extends RevealLinearLayout {

        public MorphLinearLayout(Context context, Attributes atrib) {
            this(context);
            setOrientation(VERTICAL);

        }

        public MorphLinearLayout(Context context) {
            super(context);
            setOrientation(VERTICAL);

        }

        public MorphLinearLayout(Context context, AttributeSet atrib) {
            super(context, atrib);
            setOrientation(VERTICAL);


        }

        public MorphLinearLayout(Context context, AttributeSet atrib, int style) {
            super(context, atrib, style);
            setOrientation(VERTICAL);


        }

    }

